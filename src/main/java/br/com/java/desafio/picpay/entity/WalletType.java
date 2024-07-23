package br.com.java.desafio.picpay.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa o tipo de carteira no sistema de carteira digital.
 * Cada tipo de carteira pode ser do tipo usuário ou lojista.
 */
@Entity
@Table(name = "tb_wallet_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class WalletType {

    /**
     * Identificador único do tipo de carteira.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Descrição do tipo de carteira.
     */
    private String description;

    /**
     * Enumeração que define os tipos de carteira possíveis.
     * Inclui tipos de carteira para usuários e empresários.
     */
    @AllArgsConstructor
    public enum Enum {

        /**
         * Tipo de carteira para usuário.
         */
        USER(1L, "User"),
        /**
         * Tipo de carteira para lojista.
         */
        BUSINESS(2L, "Business");

        /**
         * Identificador único do tipo de carteira.
         */
        private final Long id;
        /**
         * Descrição do tipo de carteira.
         */
        private final String description;

        /**
         * Retorna uma nova instância de WalletType baseada nos valores do enum.
         *
         * @return uma instância de WalletType.
         */
        public WalletType get() {
            return new WalletType(id, description);
        }
    }
}
