package br.com.java.desafio.picpay.service;

import br.com.java.desafio.picpay.controller.dto.TransferDTO;
import br.com.java.desafio.picpay.entity.Transfer;
import br.com.java.desafio.picpay.entity.Wallet;
import br.com.java.desafio.picpay.exception.InsufficientBalanceException;
import br.com.java.desafio.picpay.exception.TransferNotAllowedForTypeException;
import br.com.java.desafio.picpay.exception.TransferNotAuthorizedException;
import br.com.java.desafio.picpay.exception.WalletNotFoundException;
import br.com.java.desafio.picpay.repository.TransferRepository;
import br.com.java.desafio.picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    @Transactional
    public Transfer transfer(TransferDTO dto) {

        Wallet sender = walletRepository.findById(dto.payer())
                .orElseThrow(() -> new WalletNotFoundException(dto.payer()));

        Wallet receiver = walletRepository.findById(dto.payee())
                .orElseThrow(() -> new WalletNotFoundException(dto.payee()));

        validateTransfer(dto, sender);

        sender.debit(dto.value());
        receiver.credit(dto.value());

        Transfer transfer = new Transfer(sender, receiver, dto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);

        Transfer resultadoTransferencia = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transfer));

        return resultadoTransferencia;
    }

    private void validateTransfer(TransferDTO dto, Wallet sender) {
        if(!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForTypeException();
        }

        if(!sender.isBalanceEqualOrGreaterThan(dto.value())) {
            throw new InsufficientBalanceException();
        }

        if(!authorizationService.isAuthorized()) {
            throw new TransferNotAuthorizedException();
        }
    }
}
