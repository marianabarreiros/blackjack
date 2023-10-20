import org.blackjack.Baralho;
import org.blackjack.Carta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BaralhoTest {

    private Baralho baralho;

    @BeforeEach
    public void setUp() {
        baralho = new Baralho();
    }

    @Test
    @DisplayName("Após construção, baralho deve possuir cartas.")
    public void testConstrutorBaralho() {
        assertNotNull(baralho);
        assertNotNull(baralho.getCartas());
    }

    @Test
    @DisplayName("Baralho padrão deve possuir 52 cartas")
    public void testQuantidadeDeCartasNoBaralho() {
        assertEquals(52, baralho.getCartas().size());
    }

    @Test
    @DisplayName("Depois de embaralhar, ordem das cartas deve ser diferente de quando o baralho for criado")
    public void testEmbaralharCartas() {
        ArrayList<Carta> cartasAntesEmbaralhar = new ArrayList<>(baralho.getCartas());
        baralho.embaralharCartas();
        ArrayList<Carta> cartasDepoisEmbaralhar = baralho.getCartas();

        assertNotEquals(cartasAntesEmbaralhar, cartasDepoisEmbaralhar);
    }
}
