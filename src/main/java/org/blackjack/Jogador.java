package org.blackjack;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Jogador {

    private final ArrayList<Carta> maoDoJogador;
    private int quantidadeDePontosDoJogador;
    private int quantidadeDeAsDoJogador;
    private Carta carta;

    public Jogador(ArrayList<Carta> baralhoEmbalhado) {
        this.maoDoJogador = new ArrayList<>();
        this.quantidadeDePontosDoJogador = 0;
        this.quantidadeDeAsDoJogador = 0;

        this.distribuirCartasAoJogador(baralhoEmbalhado);
    }

    public ArrayList<Carta> distribuirCartasAoJogador(ArrayList<Carta> baralhoEmbaralhado) {
        for (int i = 0; i < 2; i++) {
            Carta cartaDistribuida = baralhoEmbaralhado.remove(baralhoEmbaralhado.size() - 1);
            quantidadeDePontosDoJogador += cartaDistribuida.getValor();
            quantidadeDeAsDoJogador += cartaDistribuida.isAce() ? 1 : 0;
            maoDoJogador.add(cartaDistribuida);
        }
        return maoDoJogador;
    }
}
