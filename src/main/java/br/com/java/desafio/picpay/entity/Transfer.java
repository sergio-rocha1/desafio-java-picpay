package br.com.java.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Representa uma transferência de valores entre duas carteiras no sistema de carteira digital.
 * Cada transferência possui um remetente, um destinatário e um valor transferido.
 */
@Entity
@Table(name = "tb_transfer")
@NoArgsConstructor
@Getter @Setter
public class Transfer {

    /**
     * Identificador único da transferência.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Carteira remetente da transferência.
     */
    @JoinColumn(name = "wallet_sender_id")
    @ManyToOne
    private Wallet sender;

    /**
     * Carteira destinatária da transferência.
     */
    @JoinColumn(name = "wallet_receiver_id")
    @ManyToOne
    private Wallet receiver;

    /**
     * Valor transferido entre as carteiras.
     */
    private BigDecimal value;

    /**
     * Construtor da classe Transfer.
     *
     * @param sender Carteira remetente da transferência.
     * @param receiver Carteira destinatária da transferência.
     * @param value Valor transferido.
     */
    public Transfer(Wallet sender, Wallet receiver, BigDecimal value) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }
}
