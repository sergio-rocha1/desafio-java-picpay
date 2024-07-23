package br.com.java.desafio.picpay.controller.dto;

import br.com.java.desafio.picpay.entity.Wallet;
import br.com.java.desafio.picpay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Dados necessários para criar uma nova carteira.
 *
 * @param fullName Nome completo do proprietário da carteira.
 * @param cpfCnpj CPF ou CNPJ do proprietário da carteira.
 * @param email Email do proprietário da carteira.
 * @param password Senha para acessar a carteira.
 * @param walletType Tipo de carteira a ser criada (usuário ou empresário).
 */
public record CreateWalletDTO(@NotBlank String fullName,
                              @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull WalletType.Enum walletType) {

    /**
     * Converte os dados para uma instância de {@link Wallet}.
     *
     * @return Uma nova instância de {@link Wallet}.
     */
    public Wallet toWallet() {
        return new Wallet(fullName, cpfCnpj, email, password, walletType.get());
    }

}
