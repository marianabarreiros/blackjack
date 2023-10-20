package org.blackjack;

public class Blackjack {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.construirBaralho();
        System.out.println(baralho.getCartas().size());
        baralho.embaralharCartas();
        System.out.println(baralho.getCartas().size());

        System.out.println(baralho.getCartas());
        Dealer dealer = new Dealer(baralho.getCartas());
        Jogador jogador =  new Jogador(baralho.getCartas());

        System.out.println("DEALER:");
        System.out.println(dealer.getCartaEscondida());
        System.out.println(dealer.getMaoDealer());
        System.out.println(dealer.getDealerSoma());
        System.out.println(dealer.getDealerQuantidadeAs());

        System.out.println("JOGADOR: ");
        System.out.println(jogador.getMaoDoJogador());
        System.out.println(jogador.getQuantidadeDePontosDoJogador());
        System.out.println(jogador.getQuantidadeDeAsDoJogador());

    }
}