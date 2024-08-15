package com.slot.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class MatrizJogo {
    private List<List<Integer>> matrizReal;
    private List<RegraAcertada> regrasAcertadas;
    private Bingo bingo;
}
