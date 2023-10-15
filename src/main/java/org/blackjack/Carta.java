package org.blackjack;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@EqualsAndHashCode
public class Carta {

    private final String tipo;
    private final String valor;

    public Carta(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public static ArrayList<Carta> obterCartas() {
        String[] tipos = new String[]{"C", "D", "H", "S"};
        String[] valores = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        ArrayList<Carta> cartas = new ArrayList<>();
        for (String i : tipos) {
            for (String j : valores) {
                Carta carta = new Carta(i, j);
                cartas.add(carta);
            }
        }
        return cartas;
    }
}
