package com.cantina.dto;

import com.cantina.model.Lanche;

import java.math.BigDecimal;

public record LancheResumoDTO(
        String nome,
        BigDecimal preco
) {
    public static LancheResumoDTO fromEntity(Lanche lanche) {
        return new LancheResumoDTO(lanche.getNome(), lanche.getPreco());
    }
}
