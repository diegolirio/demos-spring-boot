package com.example.consumerapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private Float altura;
    private Float peso;
    private Float imc;
    private ClassificationType classification;
}