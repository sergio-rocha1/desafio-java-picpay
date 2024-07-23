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

/**
 * Serviço responsável pela execução das transferências entre carteiras.
 */
@Service
@AllArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    /**
     * Realiza uma transferência de valores entre carteiras com base nos dados fornecidos.
     *
     * @param dto Dados da transferência a ser realizada, conforme definido em {@link TransferDTO}.
     * @return Uma resposta {@link Transfer} contendo a transferência realizada.
     * @throws WalletNotFoundException Se qualquer das carteiras especificadas não for encontrada.
     * @throws TransferNotAllowedForTypeException Se a transferência não for permitida para o tipo de carteira do remetente.
     * @throws InsufficientBalanceException Se o saldo da carteira remetente for insuficiente.
     * @throws TransferNotAuthorizedException Se a transferência não for autorizada pelo serviço de autorização.
     */
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

    /**
     * Valida os dados da transferência e verifica se ela pode ser realizada.
     *
     * @param dto Dados da transferência a ser validada, conforme definido em {@link TransferDTO}.
     * @param sender Carteira que está enviando os fundos.
     * @throws TransferNotAllowedForTypeException Se a transferência não é permitida para o tipo de carteira do remetente.
     * @throws InsufficientBalanceException Se o saldo da carteira remetente é insuficiente para a transferência.
     * @throws TransferNotAuthorizedException Se a transferência não é autorizada pelo serviço de autorização.
     */
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
