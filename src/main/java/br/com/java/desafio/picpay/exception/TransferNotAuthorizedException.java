package br.com.java.desafio.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizedException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);
        pb.setTitle("Transferência não autorizada.");
        pb.setDetail("Serviço de autorização não autorizou essa transferência.");

        return pb;
    }
}
