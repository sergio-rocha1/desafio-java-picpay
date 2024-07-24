package br.com.java.desafio.picpay.client;

import br.com.java.desafio.picpay.client.dto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Cliente Feign para interagir com o serviço de autorização.
 * Utiliza o Feign para enviar requisições para o serviço de autorização configurado na URL especificada.
 */
@FeignClient(
        name="AuthorizationClient",
        url = "${client.authorization-service.url}"
)
public interface AuthorizationClient {

    /**
     * Verifica se a autorização foi concedida.
     *
     * @return Uma instância de ResponseEntity contendo a resposta de autorização.
     */
    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();

}
