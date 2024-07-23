package br.com.java.desafio.picpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Para habilitar o feign client no projeto
public class DesafioPicpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPicpayApplication.class, args);
	}

}
