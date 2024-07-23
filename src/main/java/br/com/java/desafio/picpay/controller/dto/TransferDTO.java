package br.com.java.desafio.picpay.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * Dados necessários para realizar uma transferência de valores entre carteiras.
 *
 * @param value Valor da transferência, deve ser maior ou igual a 0.01.
 * @param payer Identificador da carteira pagadora.
 * @param payee Identificador da carteira recebedora.
 */
public record TransferDTO(
        @DecimalMin(value = "0.01") @NotNull BigDecimal value,
        @NotNull Long payer,
        @NotNull Long payee) {
}
