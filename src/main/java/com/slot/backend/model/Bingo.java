package com.slot.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class Bingo {

    int ganhoCartela;
    private List<Globo> globosSorteados;

}
