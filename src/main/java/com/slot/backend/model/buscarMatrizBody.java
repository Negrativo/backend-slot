package com.slot.backend.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class buscarMatrizBody {

    int valorAposta;
    int numLinhas;
    @NonNull
    List<List<Integer>> cartela;

    public buscarMatrizBody() {
        cartela = List.of();
    }
}
