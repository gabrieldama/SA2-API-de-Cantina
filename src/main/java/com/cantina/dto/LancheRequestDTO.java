package com.cantina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record LancheRequestDTO(

        @NotBlank(message = "O nome do lanche e obrigatório")
        String nome,

        @NotBlank(message = "A descrição do lanche é obrigatória")
        String descricao,

        @NotNull(message = "O preço do lanche é obrigatório")
        @Positive(message = "deve ser maior que 0")
        BigDecimal preco
) {
}
