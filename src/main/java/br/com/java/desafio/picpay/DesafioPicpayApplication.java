package br.com.java.desafio.picpay;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Classe principal para iniciar a aplicação Spring Boot.
 * Configura o ambiente e inicializa o contexto da aplicação.
 */
@SpringBootApplication
@EnableFeignClients // Para habilitar o feign client no projeto
public class DesafioPicpayApplication {

	/**
	 * Método principal para iniciar a aplicação Spring Boot.
	 * Carrega variáveis de ambiente a partir do arquivo .env e configura as propriedades do sistema.
	 *
	 * @param args Argumentos de linha de comando passados para a aplicação.
	 */
	public static void main(String[] args) {
		// Carregar o arquivo .env da pasta resources
		Dotenv dotenv = Dotenv.configure()
				.filename("db-acess.env")
				.load();

		System.setProperty("MYSQL_USER", dotenv.get("MYSQL_USER"));
		System.setProperty("MYSQL_PASSWORD", dotenv.get("MYSQL_PASSWORD"));

		SpringApplication.run(DesafioPicpayApplication.class, args);
	}

}
