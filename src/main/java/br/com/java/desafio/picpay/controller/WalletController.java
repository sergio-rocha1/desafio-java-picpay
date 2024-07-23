package br.com.java.desafio.picpay.controller;

import br.com.java.desafio.picpay.controller.dto.CreateWalletDTO;
import br.com.java.desafio.picpay.entity.Wallet;
import br.com.java.desafio.picpay.service.WalletService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDTO dto) {
        var wallet = walletService.createWallet(dto);

        return ResponseEntity.ok(wallet);
    }
}
