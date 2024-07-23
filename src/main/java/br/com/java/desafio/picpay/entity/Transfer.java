package br.com.java.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
@NoArgsConstructor
@Getter @Setter
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "wallet_sender_id")
    @ManyToOne
    private Wallet sender;

    @JoinColumn(name = "wallet_receiver_id")
    @ManyToOne
    private Wallet receiver;

    private BigDecimal value;

}
