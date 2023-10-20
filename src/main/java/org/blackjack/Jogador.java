package org.blackjack;

import lombok.Getter;
import lombok.Setter;
import org.blackjack.Carta;

import java.util.ArrayList;

@Getter
@Setter
public class Jogador {

    private ArrayList<Carta> maoDoJogador;
    private int quantidadeDePontosDoJogador;
    private int quantidadeDeAsDoJogador;

    public Jogador(ArrayList<Carta> baralhoEmbalhado) {
        this.maoDoJogador = new ArrayList<>();
        this.quantidadeDePontosDoJogador = 0;
        this.quantidadeDeAsDoJogador = 0;

        this.distribuirCartasAoJogador(baralhoEmbalhado);
    }

    public Jogador(){

    }

    public void distribuirCartasAoJogador(ArrayList<Carta> baralhoEmbaralhado) {
        for (int i = 0; i < 2; i++) {
            Carta cartaDistribuida = baralhoEmbaralhado.remove(baralhoEmbaralhado.size() - 1);
            quantidadeDePontosDoJogador += cartaDistribuida.getValor();
            quantidadeDeAsDoJogador += cartaDistribuida.isAs() ? 1 : 0;
            maoDoJogador.add(cartaDistribuida);
        }
    }
}
