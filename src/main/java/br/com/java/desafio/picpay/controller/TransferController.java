package br.com.java.desafio.picpay.controller;

import br.com.java.desafio.picpay.controller.dto.TransferDTO;
import br.com.java.desafio.picpay.entity.Transfer;
import br.com.java.desafio.picpay.service.TransferService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pelas operações de transferência de valores entre carteiras.
 * Fornece um endpoint para realizar uma transferência.
 */
@RestController
@AllArgsConstructor
public class TransferController {

    private final TransferService transferService;

    /**
     * Realiza uma transferência de valores entre carteiras com base nos dados fornecidos.
     *
     * @param dto Dados da transferência a ser realizada, conforme definido em {@link TransferDTO}.
     * @return Uma resposta contendo a transferência realizada.
     */
    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO dto) {
        var response = transferService.transfer(dto);

        return ResponseEntity.ok(response);
    }
}
