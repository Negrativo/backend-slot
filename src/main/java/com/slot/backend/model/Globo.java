package com.slot.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class Globo {
    Posicao posicao;
    List<Integer> bolasSorteadas;
}
