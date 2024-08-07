package com.slot.backend.model;

import lombok.Data;

@Data
public class RegraAcertada {
    public Regra regra;
    public int valor;
    public int qtdeAcertada;
    public int item;

    public RegraAcertada(Regra regra, int valor, int qtdeAcertada, int item) {
        this.regra = regra;
        this.valor = valor;
        this.qtdeAcertada = qtdeAcertada;
        this.item = item;
    }

    @Override
    public String toString() {
        return "RegraAcertada{" +
                "regra=" + regra +
                ", valor=" + valor +
                ", qtdeAcertada=" + qtdeAcertada +
                ", item=" + item +
                '}';
    }
}
