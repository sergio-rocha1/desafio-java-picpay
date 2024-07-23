package br.com.java.desafio.picpay.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * Exceção lançada quando uma carteira não é encontrada pelo ID fornecido.
 */
@AllArgsConstructor
public class WalletNotFoundException extends PicPayException {

    private Long walletId;

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Carteira não encontrada");
        pb.setDetail("Não foi possível encontrar a carteira com o ID " + walletId + ".");

        return pb;
    }
}
