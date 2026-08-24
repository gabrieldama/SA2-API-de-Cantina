package com.cantina.repository;

import com.cantina.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LancheRepository extends JpaRepository<Lanche, Long> {

    boolean existsByNome(String nome);

    Optional<Lanche> findByNome(String nome);
}
