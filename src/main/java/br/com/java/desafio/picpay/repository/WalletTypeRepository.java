package br.com.java.desafio.picpay.repository;

import br.com.java.desafio.picpay.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório responsável pelas operações de CRUD (Create, Read, Update, Delete)
 * relacionadas aos tipos de carteira.
 */
@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
