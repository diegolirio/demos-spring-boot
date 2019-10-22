package io.github.diegolirio.usuarioimc.usuario.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Usuario {

    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private Float altura;
    private Float peso;
    private Float imc;
    private ClassificationType classification;
}
