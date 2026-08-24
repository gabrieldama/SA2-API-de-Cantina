package com.cantina.controller;

import com.cantina.model.Lanche;
import com.cantina.service.LancheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lanches")
public class LancheController {

    private final LancheService service;

    public LancheController(LancheService service) {
        this.service = service;
    }

    @PostMapping
    public Lanche cadastrar(@RequestBody Lanche lanche) {
        return service.cadastrar(lanche);
    }

    @GetMapping
    public List<Lanche> listar() {
        return service.listar();
    }
}
