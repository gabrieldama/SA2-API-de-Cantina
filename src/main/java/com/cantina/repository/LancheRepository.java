package com.cantina.repository;

import com.cantina.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancheRepository extends JpaRepository<Lanche, Long> {
}
