package br.com.java.desafio.picpay.service;

import br.com.java.desafio.picpay.client.NotificationClient;
import br.com.java.desafio.picpay.entity.Transfer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationClient notificationClient;

    public void sendNotification(Transfer transfer) {
        try {
            logger.info("Enviando notificação de transação...");
            var response = notificationClient.sendNotification(transfer);

            if(response.getStatusCode().isError()) {
                logger.error("Erro enquanto enviava notificação de transação, status code is not Ok ({}).", response.getStatusCode());
            }
        } catch (Exception e) {
            logger.error("Erro enquanto enviava notificação de transação", e);
        }
    }
}
