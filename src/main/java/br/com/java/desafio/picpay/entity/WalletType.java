package br.com.java.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_wallet_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @AllArgsConstructor
    public enum Enum {

        USER(1L, "User"),
        BUSINESS(2L, "Business");

        private final Long id;
        private final String description;

        public WalletType get() {
            return new WalletType(id, description);
        }
    }
}
