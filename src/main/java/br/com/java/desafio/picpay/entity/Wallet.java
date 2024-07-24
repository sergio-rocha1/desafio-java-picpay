package br.com.java.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
/**
 * Representa uma carteira no sistema de carteira digital.
 * Cada carteira pertence a um usuário ou lojista e contém informações como
 * nome completo, CPF/CNPJ, email, senha, saldo e tipo de carteira.
 */
@Entity
@Table(name= "tb_wallet")
@NoArgsConstructor
@Getter @Setter
public class Wallet {

    /**
     * Identificador único da carteira.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do proprietário da carteira.
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * CPF ou CNPJ do proprietário da carteira.
     * Este valor deve ser único no sistema.
     */
    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    /**
     * Email do proprietário da carteira.
     * Este valor deve ser único no sistema.
     */
    @Column(name= "email", unique = true)
    private String email;

    /**
     * Senha de acesso da carteira.
     */
    @Column(name = "password")
    private String password;

    /**
     * Saldo disponível na carteira.
     * Inicialmente, o saldo é zero.
     */
    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    /**
     * Tipo de carteira (usuário ou empresário).
     * Representa a relação muitos-para-um com a entidade WalletType.
     */
    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;

    /**
     * Construtor da classe Wallet.
     *
     * @param fullName Nome completo do proprietário da carteira.
     * @param cpfCnpj CPF ou CNPJ do proprietário da carteira.
     * @param email Email do proprietário da carteira.
     * @param password Senha de acesso da carteira.
     * @param walletType Tipo de carteira (usuário ou empresário).
     */
    public Wallet(String fullName, String cpfCnpj, String email, String password, WalletType walletType) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.walletType = walletType;
    }

    /**
     * Verifica se a transferência é permitida para o tipo de carteira.
     *
     * @return true se o tipo de carteira for usuário, caso contrário, false.
     */
    public boolean isTransferAllowedForWalletType() {
        return this.walletType.equals(WalletType.Enum.USER.get());
    }

    /**
     * Verifica se o saldo da carteira é igual ou maior que um determinado valor.
     *
     * @param value Valor a ser comparado com o saldo da carteira.
     * @return true se o saldo for igual ou maior que o valor, caso contrário, false.
     */
    public boolean isBalanceEqualOrGreaterThan(BigDecimal value) {
        return this.balance.doubleValue() >= value.doubleValue();
    }

    /**
     * Debita um valor específico do saldo da carteira.
     *
     * @param value Valor a ser debitado.
     */
    public void debit(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    /**
     * Credita um valor específico no saldo da carteira.
     *
     * @param value Valor a ser creditado.
     */
    public void credit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }
}
