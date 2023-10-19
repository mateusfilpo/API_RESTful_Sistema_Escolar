package com.sistemaescolar.model.enums;

public enum MateriaEscolar {
	MATEMATICA(0),
    PORTUGUES(1),
    CIENCIAS(2),
    HISTORIA(3),
    GEOGRAFIA(4),
    INGLES(5),
    EDUCACAO_FISICA(6),
    ARTE(7);

    private final int numero;

    MateriaEscolar(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
	
}
