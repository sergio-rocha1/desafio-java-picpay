package br.com.java.desafio.picpay.service;

import br.com.java.desafio.picpay.controller.dto.CreateWalletDTO;
import br.com.java.desafio.picpay.entity.Wallet;
import br.com.java.desafio.picpay.exception.WalletDataAlreadyExistsException;
import br.com.java.desafio.picpay.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    public Wallet createWallet(CreateWalletDTO dto) {
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj ou Email já estão cadastrados no sistema");
        }

        return walletRepository.save(dto.toWallet());
    }
}
