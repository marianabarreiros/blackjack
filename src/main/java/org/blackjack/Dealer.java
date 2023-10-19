package org.blackjack;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class Dealer {
    private Carta cartaEscondida;
    private ArrayList<Carta> maoDealer;
    private int dealerSoma;
    private int dealerQuantidadeAs;
    private Carta carta;

    public Dealer(ArrayList<Carta> baralhoEmbaralhado) {
        // Inicializa a carta escondida
        cartaEscondida = baralhoEmbaralhado.remove(baralhoEmbaralhado.size() - 1);
        dealerSoma += cartaEscondida.getValor();
        dealerQuantidadeAs += cartaEscondida.isAce() ? 1 : 0;

        // Inicializa a mão do dealer
        carta = baralhoEmbaralhado.remove(baralhoEmbaralhado.size() - 1);
        dealerSoma += carta.getValor();
        dealerQuantidadeAs += carta.isAce() ? 1 : 0;
        maoDealer = new ArrayList<>();
        maoDealer.add(carta);
    }
}

