package com.cantina.dto;

import com.cantina.model.Lanche;

import java.math.BigDecimal;

public record LancheResponseDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco
) {
    public static LancheResponseDTO fromEntity(Lanche lanche) {
        return new LancheResponseDTO(
                lanche.getId(),
                lanche.getNome(),
                lanche.getDescricao(),
                lanche.getPreco()
        );
    }
}
