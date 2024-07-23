package br.com.java.desafio.picpay.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferDTO(
        @DecimalMin(value = "0.01") @NotNull BigDecimal value,
        @NotNull Long payer,
        @NotNull Long payee) {
}
