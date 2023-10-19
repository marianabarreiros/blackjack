package org.blackjack;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@EqualsAndHashCode
public class Carta {

    private final String tipo;
    private final String valor;

    @Override
    public String toString() {
        return valor + "-" + tipo;
    }

    public Carta(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public static ArrayList<Carta> obterCartas() {
        String[] tipos = new String[]{"C", "D", "H", "S"};
        String[] valores = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int numTipos = tipos.length;
        int numValores = valores.length;
        int tamanhoReal = numTipos * numValores;

        ArrayList<Carta> cartas = new ArrayList<>(tamanhoReal);
        for (String tipo : tipos) {
            for (String valor : valores) {
                Carta carta = new Carta(tipo, valor);
                cartas.add(carta);
            }
        }
        return cartas;
    }

    public int getValor() {
        if ("AJQK".contains(valor)) {
            if (valor.equals("A")) {
                return 11;
            }
            return 10;
        }
        return Integer.parseInt(valor);
    }

    public boolean isAce() {
        return Objects.equals(valor, "A");
    }
}
