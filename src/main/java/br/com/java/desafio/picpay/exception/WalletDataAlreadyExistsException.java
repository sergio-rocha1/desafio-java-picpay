package br.com.java.desafio.picpay.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * Exceção lançada quando há tentativa de criar uma carteira com dados que já existem no sistema.
 */
@AllArgsConstructor
public class WalletDataAlreadyExistsException extends PicPayException {

    private final String detail;

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Carteira já está cadastrada no sistema");
        pb.setDetail(detail);

        return pb;
    }
}
