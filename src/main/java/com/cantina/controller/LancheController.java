package com.cantina.controller;

import com.cantina.dto.LancheRequestDTO;
import com.cantina.dto.LancheResponseDTO;
import com.cantina.dto.LancheResumoDTO;
import com.cantina.service.LancheService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/lanches")
public class LancheController {

    private final LancheService lancheService;

    public LancheController(LancheService lancheService) {
        this.lancheService = lancheService;
    }

    @Operation(summary = "Cadastrar um lanche", description = "Cadastra u novo lanche no cardapio da cantina.")
    @PostMapping
    public ResponseEntity<LancheResponseDTO> cadastrarLanche(@RequestBody @Valid LancheRequestDTO dto,
                                                             UriComponentsBuilder uriBuilder) {
        LancheResponseDTO lancheCriado = lancheService.cadastrar(dto);
        var uri = uriBuilder.path("/lanches/{id}").buildAndExpand(lancheCriado.id()).toUri();
        return ResponseEntity.created(uri).body(lancheCriado);
    }

    @Operation(summary = "Listar todos os lanches", description = "Retorna nome e preço de todos os lanches cadastrados.")
    @GetMapping
    public ResponseEntity<List<LancheResumoDTO>> listarLanches() {
        return ResponseEntity.ok(lancheService.listarTodos());
    }

    @Operation(summary = "Consultar um lanche", description = "Retorna todas as informações de um lanche pelo id.")
    @GetMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> consultarLanchePorId(@PathVariable Long id) {
        return ResponseEntity.ok(lancheService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar um lanche", description = "Atualiza os dados de um lanche ja cadastrado.")
    @PutMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> atualizarLanche(@PathVariable Long id,
                                                             @RequestBody @Valid LancheRequestDTO dto) {
        return ResponseEntity.ok(lancheService.atualizar(id, dto));
    }

    @Operation(summary = "Deleta um lanche", description = "Deleta um lanche do cardápio a partir do ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLanche(@PathVariable Long id) {
        lancheService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
