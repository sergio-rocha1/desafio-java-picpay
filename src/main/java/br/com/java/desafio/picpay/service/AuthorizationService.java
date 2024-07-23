package br.com.java.desafio.picpay.service;

import br.com.java.desafio.picpay.client.AuthorizationClient;
import br.com.java.desafio.picpay.client.dto.AuthorizationResponse;
import br.com.java.desafio.picpay.exception.PicPayException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Serviço responsável pela verificação de autorização com o cliente de autorização.
 */
@Service
@AllArgsConstructor
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    /**
     * Verifica se a autorização foi concedida pelo serviço de autorização.
     *
     * @return {@code true} se autorizado, {@code false} caso contrário.
     * @throws PicPayException Se ocorrer um erro ao consultar o serviço de autorização ou se a resposta for inválida.
     */
    public boolean isAuthorized() {
        ResponseEntity<AuthorizationResponse> authorized = authorizationClient.isAuthorized();

        if(Objects.isNull(authorized.getBody()) || authorized.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return authorized.getBody().authorized();
    }
}
