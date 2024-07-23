package br.com.java.desafio.picpay.repository;

import br.com.java.desafio.picpay.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repositório responsável pelas operações de CRUD (Create, Read, Update, Delete)
 * relacionadas às transferências de valores entre carteiras.
 */
@Repository
public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
