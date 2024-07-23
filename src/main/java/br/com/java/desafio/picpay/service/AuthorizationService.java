package br.com.java.desafio.picpay.service;

import br.com.java.desafio.picpay.client.AuthorizationClient;
import br.com.java.desafio.picpay.client.dto.AuthorizationResponse;
import br.com.java.desafio.picpay.exception.PicPayException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public boolean isAuthorized() {
        ResponseEntity<AuthorizationResponse> authorized = authorizationClient.isAuthorized();

        if(Objects.isNull(authorized.getBody()) || authorized.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return authorized.getBody().authorized();
    }
}
