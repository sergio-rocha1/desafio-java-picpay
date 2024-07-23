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

@RestController
@AllArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO dto) {
        var response = transferService.transfer(dto);

        return ResponseEntity.ok(response);
    }
}
