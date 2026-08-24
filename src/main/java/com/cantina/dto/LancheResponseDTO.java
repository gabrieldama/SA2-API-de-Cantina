package com.cantina.dto;

import java.math.BigDecimal;

public record LancheResponseDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco
) {
}
