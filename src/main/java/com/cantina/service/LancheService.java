package com.cantina.service;

import com.cantina.model.Lanche;
import com.cantina.repository.LancheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {

    private final LancheRepository repository;

    public LancheService(LancheRepository repository) {
        this.repository = repository;
    }

    public Lanche cadastrar(Lanche lanche) {
        return repository.save(lanche);
    }

    public List<Lanche> listar() {
        return repository.findAll();
    }
}
