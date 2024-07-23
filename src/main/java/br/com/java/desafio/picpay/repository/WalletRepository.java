package br.com.java.desafio.picpay.repository;

import br.com.java.desafio.picpay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório responsável pelas operações de CRUD (Create, Read, Update, Delete)
 * relacionadas às carteiras dos usuários e empresários.
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    /**
     * Busca uma carteira pelo CPF/CNPJ ou email do proprietário.
     *
     * @param cpfCnpj CPF ou CNPJ do proprietário da carteira.
     * @param email Email do proprietário da carteira.
     * @return Um Optional contendo a carteira encontrada, ou vazio se não for encontrada.
     */
    Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);

}
