package br.com.java.desafio.picpay.client;

import br.com.java.desafio.picpay.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Cliente Feign para interagir com o serviço de notificação.
 * Utiliza o Feign para enviar requisições para o serviço de notificação configurado na URL especificada.
 */
@FeignClient(
        name="NotificationClient",
        url = "${client.notification-service.url}"
)
public interface NotificationClient {

    /**
     * Envia uma notificação com base na transferência fornecida.
     *
     * @param transfer Objeto Transfer contendo os detalhes da transferência a ser notificada.
     * @return Uma instância de ResponseEntity indicando o status da operação de envio da notificação.
     */
    @PostMapping
    ResponseEntity<Void> sendNotification(@RequestBody Transfer transfer);
}
