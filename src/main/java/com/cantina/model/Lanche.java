package com.cantina.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "lanches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lanche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
}
