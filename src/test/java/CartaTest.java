import org.blackjack.Carta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    Carta carta;

    @BeforeEach
    public void setUp() {
        carta = new Carta("C", "A");
    }

    @Test
    @DisplayName("Construtor deve inicialzar objeto carta corretamente.")
    public void testConstrutorCarta() {
        assertNotNull(carta);
        assertEquals("C", carta.getTipo());
        assertEquals(11, carta.getValor());
    }

    @Test
    @DisplayName("Método toString deve formatar carta corretamente.")
    public void testToString() {
        assertEquals("A-C", carta.toString());
    }

    @Test
    @DisplayName("Método getValor deve retornar valores corretamente.")
    public void testGetValor() {
        assertEquals(11, carta.getValor());

        Carta cartaNumerica = new Carta("D", "7");
        assertEquals(7, cartaNumerica.getValor());

        Carta cartaFigura = new Carta("H", "K");
        assertEquals(10, cartaFigura.getValor());
    }

    @Test
    @DisplayName("Carta deve ser um As")
    public void testIsAce() {
        assertTrue(carta.isAs());
    }

    @Test
    @DisplayName("Carta diferente de A não é um As")
    public void testNoIsAce() {
        Carta outraCarta = new Carta("S", "9");
        assertFalse(outraCarta.isAs());
    }
}
