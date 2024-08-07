package br.com.java.desafio.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * Exceção lançada quando uma transferência não é permitida para o tipo de carteira.
 */
public class TransferNotAllowedForTypeException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Essa transferência não é permitida para este tipo de carteira.");

        return pb;
    }
}
