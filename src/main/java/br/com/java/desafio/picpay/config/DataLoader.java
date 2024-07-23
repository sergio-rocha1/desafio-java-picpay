package br.com.java.desafio.picpay.config;

import br.com.java.desafio.picpay.entity.WalletType;
import br.com.java.desafio.picpay.repository.WalletTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
