package br.com.java.desafio.picpay.controller;

import br.com.java.desafio.picpay.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manipulador global de exceções para a aplicação.
 * Captura e trata exceções específicas para fornecer respostas apropriadas.
 */
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * Trata exceções do tipo {@link PicPayException}.
     *
     * @param ex A exceção a ser tratada.
     * @return Detalhes do problema encapsulados em um {@link ProblemDetail}.
     */
    @ExceptionHandler(PicPayException.class)
    public ProblemDetail handlePicPayException(PicPayException ex) {
        return ex.toProblemDetail();
    }

    /**
     * Trata exceções de validação de argumento de método, como {@link MethodArgumentNotValidException}.
     *
     * @param ex A exceção de validação a ser tratada.
     * @return Detalhes do problema encapsulados em um {@link ProblemDetail}.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        var fieldErros = ex.getFieldErrors()
                .stream()
                .map(fieldError -> new InvalidParam(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();

        ProblemDetail pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Sua requisição contém parametros inválidos.");
        pb.setProperty("invalid-params", fieldErros);

        return pb;
    }

    private record InvalidParam(String name, String reason) {}
}
