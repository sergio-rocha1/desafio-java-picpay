package br.com.java.desafio.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

/**
 * Exceção base para erros específicos do sistema PicPay.
 * Fornece um método para criar um {@link ProblemDetail} com uma mensagem padrão para erros internos.
 */
public class PicPayException extends RuntimeException{

    /**
     * Converte a exceção para um {@link ProblemDetail} com detalhes do erro.
     *
     * @return Um {@link ProblemDetail} contendo informações sobre o erro.
     */
    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("PicPay internal server erro");

        return pb;
    }
}
