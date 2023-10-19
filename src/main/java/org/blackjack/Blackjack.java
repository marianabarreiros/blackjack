package org.blackjack;

public class Blackjack {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        System.out.println(baralho.construirBaralho());
        baralho.embaralharCartas();
        System.out.println(baralho.getCartas());
    }
}