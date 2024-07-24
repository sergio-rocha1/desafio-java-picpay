package br.com.java.desafio.picpay.config;

import br.com.java.desafio.picpay.entity.WalletType;
import br.com.java.desafio.picpay.repository.WalletTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Classe responsável por carregar os dados iniciais no banco de dados.
 * Neste caso, ela carrega os tipos de carteiras (usuário e lojista) ao iniciar a aplicação.
 */
@Configuration
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    /**
     * Repositório de tipos de carteira.
     */
    private final WalletTypeRepository walletTypeRepository;

    /**
     * Método executado ao iniciar a aplicação, responsável por salvar os tipos de carteira no banco de dados.
     *
     * @param args Argumentos de linha de comando.
     */
    @Override
    public void run(String... args) {
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
