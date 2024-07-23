package br.com.java.desafio.picpay.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@AllArgsConstructor
public class WalletDataAlreadyExistsException extends PicPayException {

    private final String detail;

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Wallet data already exists");
        pb.setDetail(detail);

        return pb;
    }
}
