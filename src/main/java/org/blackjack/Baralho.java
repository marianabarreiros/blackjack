package org.blackjack;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;

@Getter
@EqualsAndHashCode
public class Baralho {
    private final ArrayList<Carta> cartas;

    public Baralho() {
        this.cartas = this.construirBaralho();
    }

    public ArrayList<Carta> construirBaralho() {
        return Carta.obterCartas();
    }
    public void embaralharCartas() {
        Collections.shuffle(cartas);
    }
}
