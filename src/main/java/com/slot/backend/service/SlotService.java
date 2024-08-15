package com.slot.backend.service;

import com.slot.backend.model.*;
import com.slot.backend.util.Regras;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SlotService {

    private List<List<Integer>> matrizReal;
    private List<RegraAcertada> regrasAcertadas;
    private List<RegraServ> matrizDeRegras;
    private List<List<Integer>> cartela;
    private List<Posicao> posicoesGlobo;
    private List<Globo> globosSorteados;
    private List<Integer> bolasSorteadas;
    private List<Integer> numCartela;
    private int qtdeBolasSorteadas = 0;
    private int ganhoCartela;
    private int valorAposta = 1;
    private int numLinhas = 1;
    private int maxPremio = 100000;
    private int qtdeGlobo = 0;
    private Bingo bingo;

    private final int valorBingo = 1000;
    private final int valorContorno = 500;
    private final int valorH = 300;
    private final int valorLinhaDupla = 200;
    private final int valorLinha = 50;

    public List<List<Integer>> buscarMatrizCartela() {
        return montarMatrizRandom(3, 5, 90, false);
    }

    public MatrizJogo buscarMatrizRodilhos(buscarMatrizBody body) {
        int valorAposta = body.getValorAposta();
        int numLinhas = body.getNumLinhas();
        List<List<Integer>> cartelaBingo = body.getCartela();

        this.matrizReal = new ArrayList<>();
        this.regrasAcertadas = new ArrayList<>();
        this.matrizDeRegras = Regras.getInstance().criarMatrizRegras();
        this.posicoesGlobo = new ArrayList<>();
        this.globosSorteados = new ArrayList<>();
        this.numLinhas = numLinhas;
        this.valorAposta = valorAposta;
        this.bolasSorteadas = new ArrayList<>();
        this.numCartela = obterNumerosCartela(cartelaBingo);
        this.cartela = cartelaBingo;
        this.qtdeBolasSorteadas = 0;
        this.ganhoCartela = 0;
        this.qtdeGlobo = 0;

        construirMatrizReal();
        Bingo bingo = new Bingo(ganhoCartela, globosSorteados);
        return new MatrizJogo(matrizReal, regrasAcertadas, bingo);
    }

    private List<Integer> obterNumerosCartela(List<List<Integer>> cartela) {
        return cartela.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }


    public void construirMatrizReal() {
//            this.matrizReal = montarMatrizRandom(3, 5, 10, true);
        this.matrizReal = montarMatrizMock();

        conferirRegras();
        int somaGanhos = this.regrasAcertadas.stream().mapToInt(regraAcertada -> regraAcertada.valor).sum();

        if (somaGanhos > this.maxPremio) {
            this.construirMatrizReal();
        }

        this.getQuantidadeGlobo();

        if (this.qtdeGlobo >= 4 && this.valorBingo + somaGanhos > this.maxPremio) {
            this.construirMatrizReal();
        }
    }

    private List<List<Integer>> montarMatrizMock() {
        List<List<Integer>> matriz = new ArrayList<>();
        matriz.add(Arrays.asList(9, 5, 6));
        matriz.add(Arrays.asList(6, 5, 7));
        matriz.add(Arrays.asList(9, 4, 5));
        matriz.add(Arrays.asList(8, 5, 9));
        matriz.add(Arrays.asList(1, 7, 9));
        return matriz;
    }

    private List<List<Integer>> montarMatrizRandom(int linhas, int colunas, int nuMaximo, boolean permitirRepetidos) {
        List<List<Integer>> matriz = new ArrayList<>();
        List<Integer> arrayNumeros = new ArrayList<>();
        Random rand = new Random();

        for (int z = 1; z <= colunas; z++) {
            List<Integer> array = new ArrayList<>();
            for (int i = 1; i <= linhas; i++) {
                int nuRandom = rand.nextInt(nuMaximo) + 1;

                // nao pode ter mais de um globo(item9) por linha
                if (nuRandom == 9) {
                    while (array.contains(nuRandom)) {
                        nuRandom = rand.nextInt(nuMaximo) + 1;
                    }
                }

                // Se não permitir repetidos, verifica se o número já foi gerado
                if (!permitirRepetidos) {
                    while (arrayNumeros.contains(nuRandom)) {
                        nuRandom = rand.nextInt(nuMaximo) + 1;
                    }
                }


                arrayNumeros.add(nuRandom);
                array.add(nuRandom);
            }
            matriz.add(array);
        }
        return matriz;
    }

    private void conferirRegras() {
        for (Regra regra : this.matrizDeRegras) {
            if (this.numLinhas < Integer.parseInt(regra.numero)) {
                return;
            }
            boolean verdadeiro = true;
            Integer numeroItemAnterior = null;
            Integer numeroItem;
            int qtde = 0;
            for (Posicao pos : regra.posicoes) {
                if (numeroItemAnterior == null) {
                    numeroItemAnterior = this.matrizReal.get(pos.coluna).get(pos.linha);
                } else {
                    numeroItem = this.matrizReal.get(pos.coluna).get(pos.linha);
                    verdadeiro = numeroItem.equals(numeroItemAnterior) && numeroItem != 9;
                }

                if (!verdadeiro) {
                    break;
                }
                qtde++;
            }
            if (qtde >= 3) {
                Integer finalNumeroItemAnterior = numeroItemAnterior;
                ItemServ item = Regras.getInstance().getItens().stream()
                        .filter(i -> i.numero == finalNumeroItemAnterior)
                        .findFirst()
                        .orElse(null);
                int ganhoRegra = this.valorAposta * Regras.getInstance().pegarValor(item, qtde);
                this.regrasAcertadas.add(new RegraAcertada(regra, ganhoRegra, qtde, item.numero));
            }
        }
    }

    private void getQuantidadeGlobo() {
        this.posicoesGlobo.clear();
        this.qtdeGlobo = 0;

        for (int i = 0; i < this.matrizReal.size(); i++) {
            List<Integer> coluna = this.matrizReal.get(i);
            for (int y = 0; y < coluna.size(); y++) {
                int linha = coluna.get(y);
                if (linha == 9) {
                    this.posicoesGlobo.add(new Posicao(y, i));
                    this.qtdeGlobo++;
                }
            }
        }

        if (this.qtdeGlobo >= 4 && (this.numLinhas == 20)) {
            sortearGlobos();
            conferirGanhoCartela();
        }
    }


    private void sortearGlobos() {
        Random random = new Random();
        for (Posicao posicao : posicoesGlobo) {
            List<Integer> numerosSorteados = new ArrayList<>();

            int nuMaxSorteio = 5;
            if (qtdeBolasSorteadas > 10) {
                nuMaxSorteio = 15 - qtdeBolasSorteadas;
            }
            if (qtdeBolasSorteadas >= 14) {
                nuMaxSorteio = 1;
            }

            int nuRandom = random.nextInt(nuMaxSorteio) + 1;
            qtdeBolasSorteadas += nuRandom;

            for (int i = 0; i < nuRandom; i++) {
                if (numCartela.isEmpty()) {
                    break;
                }
                int index = random.nextInt(numCartela.size());
                int numeroSorteado = numCartela.remove(index);
                numerosSorteados.add(numeroSorteado);

            }
            bolasSorteadas.addAll(numerosSorteados);
            globosSorteados.add(new Globo(posicao, numerosSorteados));
        }
    }

    private void conferirGanhoCartela() {
        conferirLinhasCartela();
        conferirH();
        conferirContorno();
    }

    private void conferirContorno() {
        int qtdeLinhaA = 0;
        for (int j = 0; j < 5; j++) {
            if (bolasSorteadas.contains(cartela.get(j).get(0))) {
                qtdeLinhaA++;
            }
        }

        int qtdeLinhaC = 0;
        for (int j = 0; j < 5; j++) {
            if (bolasSorteadas.contains(cartela.get(j).get(2))) {
                qtdeLinhaC++;
            }
        }

        int qtdeColuna1 = 0;
        for (int j = 0; j < 3; j++) {
            if (bolasSorteadas.contains(cartela.get(0).get(j))) {
                qtdeColuna1++;
            }
        }

        int qtdeColuna5 = 0;
        for (int j = 0; j < 3; j++) {
            if (bolasSorteadas.contains(cartela.get(4).get(j))) {
                qtdeColuna5++;
            }
        }

        if (qtdeLinhaA == 5 && qtdeLinhaC == 5 && qtdeColuna1 == 3 && qtdeColuna5 == 3) {
            if (valorContorno > ganhoCartela) {
                ganhoCartela = valorContorno;
            }
        }
    }

    private void conferirH() {
        int qtdeLinhaB = 0;
        for (int j = 0; j < 5; j++) {
            if (bolasSorteadas.contains(cartela.get(j).get(1))) {
                qtdeLinhaB++;
            }
        }

        int qtdeColuna1 = 0;
        for (int j = 0; j < 3; j++) {
            if (bolasSorteadas.contains(cartela.get(0).get(j))) {
                qtdeColuna1++;
            }
        }

        int qtdeColuna5 = 0;
        for (int j = 0; j < 3; j++) {
            if (bolasSorteadas.contains(cartela.get(4).get(j))) {
                qtdeColuna5++;
            }
        }

        if (qtdeLinhaB == 5 && qtdeColuna1 == 3 && qtdeColuna5 == 3) {
            if (valorH > ganhoCartela) {
                ganhoCartela = valorH;
            }
        }
    }

    private void conferirLinhasCartela() {
        // linha A
        int qtdeA = 0;
        for (int j = 0; j < 5; j++) {
            if (bolasSorteadas.contains(cartela.get(j).get(0))) {
                qtdeA++;
            }
        }

        // linha B
        int qtdeB = 0;
        for (int j = 0; j < 5; j++) {
            if (bolasSorteadas.contains(cartela.get(j).get(1))) {
                qtdeB++;
            }
        }

        // linha C
        int qtdeC = 0;
        for (int j = 0; j < 5; j++) {
            if (bolasSorteadas.contains(cartela.get(j).get(2))) {
                qtdeC++;
            }
        }

        if (qtdeA == 5 || qtdeB == 5 || qtdeC == 5) {
            if (valorLinha > ganhoCartela) {
                ganhoCartela = valorLinha;
            }
        }

        int qtdeLinha = 0;
        if (qtdeA == 5) {
            qtdeLinha++;
        }
        if (qtdeB == 5) {
            qtdeLinha++;
        }
        if (qtdeC == 5) {
            qtdeLinha++;
        }

        if (qtdeLinha == 2) {
            if (valorLinhaDupla > ganhoCartela) {
                ganhoCartela = valorLinhaDupla;
            }
        }

        if (qtdeLinha == 3) {
            ganhoCartela = valorBingo;
        }
    }

}
