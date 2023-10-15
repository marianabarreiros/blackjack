package org.blackjack;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@EqualsAndHashCode
public class Baralho {
    private ArrayList<Carta> cartas;

    public Baralho(){
        this.cartas = this.construirBaralho();
    }

    public ArrayList<Carta> construirBaralho(){
       return Carta.obterCartas();
    }
}
