package org.blackjack;

public class Blackjack {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.construirBaralho();
        System.out.println(baralho.getCartas());
        baralho.embaralharCartas();
        System.out.println(baralho.getCartas());

        System.out.println(baralho.getCartas());
        Dealer dealer = new Dealer(baralho.getCartas());

        System.out.println("DEALER:");
        System.out.println(dealer.getCartaEscondida());
        System.out.println(dealer.getMaoDealer());
        System.out.println(dealer.getDealerSoma());
        System.out.println(dealer.getDealerQuantidadeAs());

    }
}