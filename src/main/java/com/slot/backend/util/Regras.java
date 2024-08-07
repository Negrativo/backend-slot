package com.slot.backend.util;

import com.slot.backend.model.ItemServ;
import com.slot.backend.model.Posicao;
import com.slot.backend.model.RegraServ;

import java.util.ArrayList;
import java.util.List;

public class Regras {
    private static Regras instance;

    private List<RegraServ> regras;
    private List<ItemServ> itens;

    public Regras() {
        this.regras = new ArrayList<>();
        this.itens = new ArrayList<>();
        criarArrayItens();
    }

    public static Regras getInstance() {
        if (instance == null) {
            instance = new Regras();
        }
        return instance;
    }

    public List<RegraServ> criarMatrizRegras() {

        if (!this.regras.isEmpty()) {
            return this.regras;
        }

        RegraServ regra1 = new RegraServ();
        regra1.numero = "1";
        regra1.posicoes = new ArrayList<>();
        regra1.posicoes.add(new Posicao(1, 0));
        regra1.posicoes.add(new Posicao(1, 1));
        regra1.posicoes.add(new Posicao(1, 2));
        regra1.posicoes.add(new Posicao(1, 3));
        regra1.posicoes.add(new Posicao(1, 4));
        regra1.cor = "red";
        regra1.inicio = "esquerda";
        this.regras.add(regra1);

        RegraServ regra2 = new RegraServ();
        regra2.numero = "2";
        regra2.posicoes = new ArrayList<>();
        regra2.posicoes.add(new Posicao(0, 4));
        regra2.posicoes.add(new Posicao(0, 3));
        regra2.posicoes.add(new Posicao(0, 2));
        regra2.posicoes.add(new Posicao(0, 1));
        regra2.posicoes.add(new Posicao(0, 0));
        regra2.cor = "DarkOrange";
        regra2.inicio = "direita";
        this.regras.add(regra2);

        RegraServ regra3 = new RegraServ();
        regra3.numero = "3";
        regra3.posicoes = new ArrayList<>();
        regra3.posicoes.add(new Posicao(2, 4));
        regra3.posicoes.add(new Posicao(2, 3));
        regra3.posicoes.add(new Posicao(2, 2));
        regra3.posicoes.add(new Posicao(2, 1));
        regra3.posicoes.add(new Posicao(2, 0));
        regra3.cor = "OrangeRed";
        regra3.inicio = "direita";
        this.regras.add(regra3);

        RegraServ regra4 = new RegraServ();
        regra4.numero = "4";
        regra4.posicoes = new ArrayList<>();
        regra4.posicoes.add(new Posicao(0, 0));
        regra4.posicoes.add(new Posicao(1, 1));
        regra4.posicoes.add(new Posicao(2, 2));
        regra4.posicoes.add(new Posicao(1, 3));
        regra4.posicoes.add(new Posicao(0, 4));
        regra4.cor = "orange";
        regra4.inicio = "esquerda";
        this.regras.add(regra4);

        RegraServ regra5 = new RegraServ();
        regra5.numero = "5";
        regra5.posicoes = new ArrayList<>();
        regra5.posicoes.add(new Posicao(2, 0));
        regra5.posicoes.add(new Posicao(1, 1));
        regra5.posicoes.add(new Posicao(0, 2));
        regra5.posicoes.add(new Posicao(1, 3));
        regra5.posicoes.add(new Posicao(2, 4));
        regra5.inicio = "esquerda";
        this.regras.add(regra5);

        RegraServ regra6 = new RegraServ();
        regra6.numero = "6";
        regra6.posicoes = new ArrayList<>();
        regra6.posicoes.add(new Posicao(0, 4));
        regra6.posicoes.add(new Posicao(0, 3));
        regra6.posicoes.add(new Posicao(1, 2));
        regra6.posicoes.add(new Posicao(0, 1));
        regra6.posicoes.add(new Posicao(0, 0));
        regra6.inicio = "direita";
        this.regras.add(regra6);

        RegraServ regra7 = new RegraServ();
        regra7.numero = "7";
        regra7.posicoes = new ArrayList<>();
        regra7.posicoes.add(new Posicao(2, 4));
        regra7.posicoes.add(new Posicao(2, 3));
        regra7.posicoes.add(new Posicao(1, 2));
        regra7.posicoes.add(new Posicao(0, 1));
        regra7.posicoes.add(new Posicao(0, 0));
        regra7.inicio = "direita";
        this.regras.add(regra7);

        RegraServ regra8 = new RegraServ();
        regra8.numero = "8";
        regra8.posicoes = new ArrayList<>();
        regra8.posicoes.add(new Posicao(1, 4));
        regra8.posicoes.add(new Posicao(2, 3));
        regra8.posicoes.add(new Posicao(2, 2));
        regra8.posicoes.add(new Posicao(2, 1));
        regra8.posicoes.add(new Posicao(1, 0));
        regra8.inicio = "direita";
        this.regras.add(regra8);

        RegraServ regra9 = new RegraServ();
        regra9.numero = "9";
        regra9.posicoes = new ArrayList<>();
        regra9.posicoes.add(new Posicao(1, 0));
        regra9.posicoes.add(new Posicao(0, 1));
        regra9.posicoes.add(new Posicao(0, 2));
        regra9.posicoes.add(new Posicao(0, 3));
        regra9.posicoes.add(new Posicao(1, 4));
        regra9.cor = "Blue";
        regra9.inicio = "esquerda";
        this.regras.add(regra9);

        RegraServ regra10 = new RegraServ();
        regra10.numero = "10";
        regra10.posicoes = new ArrayList<>();
        regra10.posicoes.add(new Posicao(0, 0));
        regra10.posicoes.add(new Posicao(0, 1));
        regra10.posicoes.add(new Posicao(1, 2));
        regra10.posicoes.add(new Posicao(2, 3));
        regra10.posicoes.add(new Posicao(2, 4));
        regra10.cor = "Green";
        regra10.inicio = "esquerda";
        this.regras.add(regra10);

        RegraServ regra11 = new RegraServ();
        regra11.numero = "11";
        regra11.posicoes = new ArrayList<>();
        regra11.posicoes.add(new Posicao(2, 0));
        regra11.posicoes.add(new Posicao(2, 1));
        regra11.posicoes.add(new Posicao(1, 2));
        regra11.posicoes.add(new Posicao(0, 3));
        regra11.posicoes.add(new Posicao(0, 4));
        regra11.cor = "DarkViolet";
        regra11.inicio = "esquerda";
        this.regras.add(regra11);

        RegraServ regra12 = new RegraServ();
        regra12.numero = "12";
        regra12.posicoes = new ArrayList<>();
        regra12.posicoes.add(new Posicao(0, 4));
        regra12.posicoes.add(new Posicao(1, 3));
        regra12.posicoes.add(new Posicao(1, 2));
        regra12.posicoes.add(new Posicao(1, 1));
        regra12.posicoes.add(new Posicao(0, 0));
        regra12.cor = "FireBrick";
        regra12.inicio = "direita";
        this.regras.add(regra12);

        RegraServ regra13 = new RegraServ();
        regra13.numero = "13";
        regra13.posicoes = new ArrayList<>();
        regra13.posicoes.add(new Posicao(2, 4));
        regra13.posicoes.add(new Posicao(1, 3));
        regra13.posicoes.add(new Posicao(1, 2));
        regra13.posicoes.add(new Posicao(1, 1));
        regra13.posicoes.add(new Posicao(2, 0));
        regra13.cor = "LightPink";
        regra13.inicio = "direita";
        this.regras.add(regra13);

        RegraServ regra14 = new RegraServ();
        regra14.numero = "14";
        regra14.posicoes = new ArrayList<>();
        regra14.posicoes.add(new Posicao(1, 4));
        regra14.posicoes.add(new Posicao(1, 3));
        regra14.posicoes.add(new Posicao(0, 2));
        regra14.posicoes.add(new Posicao(1, 1));
        regra14.posicoes.add(new Posicao(1, 0));
        regra14.cor = "Green";
        regra14.inicio = "direita";
        this.regras.add(regra14);

        RegraServ regra15 = new RegraServ();
        regra15.numero = "15";
        regra15.posicoes = new ArrayList<>();
        regra15.posicoes.add(new Posicao(1, 4));
        regra15.posicoes.add(new Posicao(1, 3));
        regra15.posicoes.add(new Posicao(2, 2));
        regra15.posicoes.add(new Posicao(1, 1));
        regra15.posicoes.add(new Posicao(1, 0));
        regra15.cor = "Purple";
        regra15.inicio = "direita";
        this.regras.add(regra15);

        RegraServ regra16 = new RegraServ();
        regra16.numero = "16";
        regra16.posicoes = new ArrayList<>();
        regra16.posicoes.add(new Posicao(1, 0));
        regra16.posicoes.add(new Posicao(0, 1));
        regra16.posicoes.add(new Posicao(1, 2));
        regra16.posicoes.add(new Posicao(0, 3));
        regra16.posicoes.add(new Posicao(1, 4));
        regra16.cor = "SkyBlue";
        regra16.inicio = "esquerda";
        this.regras.add(regra16);

        RegraServ regra17 = new RegraServ();
        regra17.numero = "17";
        regra17.posicoes = new ArrayList<>();
        regra17.posicoes.add(new Posicao(1, 0));
        regra17.posicoes.add(new Posicao(2, 1));
        regra17.posicoes.add(new Posicao(1, 2));
        regra17.posicoes.add(new Posicao(2, 3));
        regra17.posicoes.add(new Posicao(1, 4));
        regra17.inicio = "esquerda";
        this.regras.add(regra17);

        RegraServ regra18 = new RegraServ();
        regra18.numero = "18";
        regra18.posicoes = new ArrayList<>();
        regra18.posicoes.add(new Posicao(0, 0));
        regra18.posicoes.add(new Posicao(1, 1));
        regra18.posicoes.add(new Posicao(0, 2));
        regra18.posicoes.add(new Posicao(1, 3));
        regra18.posicoes.add(new Posicao(0, 4));
        regra18.inicio = "esquerda";
        this.regras.add(regra18);

        RegraServ regra19 = new RegraServ();
        regra19.numero = "19";
        regra19.posicoes = new ArrayList<>();
        regra19.posicoes.add(new Posicao(2, 0));
        regra19.posicoes.add(new Posicao(1, 1));
        regra19.posicoes.add(new Posicao(2, 2));
        regra19.posicoes.add(new Posicao(1, 3));
        regra19.posicoes.add(new Posicao(2, 4));
        regra19.inicio = "esquerda";
        this.regras.add(regra19);

        RegraServ regra20 = new RegraServ();
        regra20.numero = "20";
        regra20.posicoes = new ArrayList<>();
        regra20.posicoes.add(new Posicao(1, 4));
        regra20.posicoes.add(new Posicao(0, 3));
        regra20.posicoes.add(new Posicao(1, 2));
        regra20.posicoes.add(new Posicao(0, 1));
        regra20.posicoes.add(new Posicao(1, 0));
        regra20.cor = "SlateBlue";
        regra20.inicio = "direita";
        this.regras.add(regra20);

        return this.regras;
    }

    public int pegarValor(ItemServ item, int qtde) {
        if (qtde == 3) {
            return item.valor1;
        } else if (qtde == 4) {
            return item.valor2;
        } else if (qtde == 5) {
            return item.valor3;
        }
        return 0;
    }

    private void criarArrayItens() {

        //ameixa
        ItemServ item1 = new ItemServ();
        item1.numero = 1;
        item1.valor1 = 20;
        item1.valor2 = 40;
        item1.valor3 = 100;
        this.itens.add(item1);

        //sino
        ItemServ item2 = new ItemServ();
        item2.numero = 2;
        item2.valor1 = 25;
        item2.valor2 = 60;
        item2.valor3 = 150;
        this.itens.add(item2);

        //melancia
        ItemServ item3 = new ItemServ();
        item3.numero = 3;
        item3.valor1 = 100;
        item3.valor2 = 200;
        item3.valor3 = 500;
        this.itens.add(item3);

        //7
        ItemServ item4 = new ItemServ();
        item4.numero = 4;
        item4.valor1 = 300;
        item4.valor2 = 750;
        item4.valor3 = 1500;
        this.itens.add(item4);

        //bar
        ItemServ item5 = new ItemServ();
        item5.numero = 5;
        item5.valor1 = 50;
        item5.valor2 = 100;
        item5.valor3 = 250;
        this.itens.add(item5);

        //2x bar
        ItemServ item6 = new ItemServ();
        item6.numero = 6;
        item6.valor1 = 30;
        item6.valor2 = 80;
        item6.valor3 = 200;
        this.itens.add(item6);

        // 3x bar
        ItemServ item7 = new ItemServ();
        item7.numero = 7;
        item7.valor1 = 200;
        item7.valor2 = 500;
        item7.valor3 = 1000;
        this.itens.add(item7);

        //cereja
        ItemServ item8 = new ItemServ();
        item8.numero = 8;
        item8.valor1 = 60;
        item8.valor2 = 120;
        item8.valor3 = 300;
        this.itens.add(item8);

        //globo
        ItemServ item9 = new ItemServ();
        item9.numero = 9;
        item9.valor1 = 0;
        item9.valor2 = 0;
        item9.valor3 = 0;
        this.itens.add(item9);

        //ouro
        ItemServ item10 = new ItemServ();
        item10.numero = 10;
        item10.valor1 = 80;
        item10.valor2 = 150;
        item10.valor3 = 400;
        this.itens.add(item10);
    }

    public List<RegraServ> getRegras() {
        return regras;
    }

    public List<ItemServ> getItens() {
        return itens;
    }

}
