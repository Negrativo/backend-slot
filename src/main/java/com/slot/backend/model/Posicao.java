package com.slot.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Posicao {
    public int linha = 0;
    public int coluna = 0;
}
