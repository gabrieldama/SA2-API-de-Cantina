package com.cantina.dto;

import java.math.BigDecimal;

public record LancheResumoDTO(
        String nome,
        BigDecimal preco
) {
}
