package br.com.java.desafio.picpay.service;

import br.com.java.desafio.picpay.controller.dto.CreateWalletDTO;
import br.com.java.desafio.picpay.entity.Wallet;
import br.com.java.desafio.picpay.exception.WalletDataAlreadyExistsException;
import br.com.java.desafio.picpay.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela criação de novas carteiras.
 */
@Service
@AllArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    /**
     * Cria uma nova carteira com base nos dados fornecidos.
     *
     * @param dto Dados da carteira a ser criada, conforme definido em {@link CreateWalletDTO}.
     * @return A carteira criada.
     * @throws WalletDataAlreadyExistsException Se já existir uma carteira com o mesmo CPF/CNPJ ou email.
     */
    public Wallet createWallet(CreateWalletDTO dto) {
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj ou Email já estão cadastrados no sistema");
        }

        return walletRepository.save(dto.toWallet());
    }
}
