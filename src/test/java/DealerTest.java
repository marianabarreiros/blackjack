import org.blackjack.Baralho;
import org.blackjack.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DealerTest {
    Baralho baralho;
    Dealer dealer;


    @BeforeEach
    public void setUp() {
        baralho = new Baralho();

        baralho.construirBaralho();
        baralho.embaralharCartas();
        dealer = new Dealer(baralho.getCartas());
    }

    @Test
    @DisplayName("Contrutor do Dealer deve inicializar objetos")
    public void testeConstrutorDealer() {
        assertNotNull(dealer);
        assertNotNull(dealer.getCartaEscondida());
        assertNotNull(dealer.getMaoDealer());
        assertNotNull(dealer.getCarta());
    }

    @Test
    @DisplayName("Ao iniciar jogo, mão do Dealer deve ser igual a 1")
    public void testMaoDoDeaderAoIniciarJogo() {
        assertEquals(1, dealer.getMaoDealer().size());
    }

    @Test
    @DisplayName("Ao iniciar jogo, mão do Dealer deve ser >= a 1")
    public void testMaoDoDeaderMaiorIgualAUm() {
        assertTrue(dealer.getDealerSoma() >= 1);
    }

    @Test
    @DisplayName("Ao iniciar jogo, Delaer deve ter quantidade de As >= a 1")
    public void testQuantidadeDeAsDoDealer() {
        assertTrue(dealer.getDealerQuantidadeAs() >= 0);
    }
}
