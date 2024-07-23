package br.com.java.desafio.picpay.client.dto;

/**
 * Representa a resposta de autorização recebida do serviço de autorização.
 * Contém um campo booleano que indica se a autorização foi concedida ou não.
 *
 * @param authorized Indica se a autorização foi concedida (true) ou não (false).
 */
public record AuthorizationResponse(boolean authorized) {
}
