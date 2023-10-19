package com.sistemaescolar.model.enums;

public enum Bimestre {
	PRIMEIRO(0),
	SEGUNDO(1),
    TERCEIRO(2),
    QUARTO(3);
    
    private final int numero;

	Bimestre(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
}
