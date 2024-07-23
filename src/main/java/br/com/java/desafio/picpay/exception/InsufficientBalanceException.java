package br.com.java.desafio.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * Exceção lançada quando há saldo insuficiente para realizar uma transferência.
 */
public class InsufficientBalanceException extends PicPayException{

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Saldo Insuficiente.");
        pb.setDetail("Não pode ser transferido mais do que o saldo disponível.");

        return pb;
    }
}
