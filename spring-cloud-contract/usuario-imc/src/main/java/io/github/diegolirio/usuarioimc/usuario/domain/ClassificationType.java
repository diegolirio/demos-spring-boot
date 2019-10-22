package io.github.diegolirio.usuarioimc.usuario.domain;

import lombok.Getter;

public enum ClassificationType {

    MAGREZA(0),
    NORMAL(1),
    SOBREPESO(2),
    OBESIDADE(3),
    OBESIDADE_GRAVE(4);


    @Getter
    private int value;

    ClassificationType(int value) {
        this.value = value;
    }
}
