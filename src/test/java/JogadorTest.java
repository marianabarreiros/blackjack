import org.blackjack.Baralho;
import org.blackjack.Jogador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JogadorTest {
    Jogador jogador;
    Baralho baralho;

    @BeforeEach
    public void setUp() {
        baralho = new Baralho();

        baralho.construirBaralho();
        baralho.embaralharCartas();
        jogador = new Jogador(this.baralho.getCartas());
    }

    @Test
    @DisplayName("Contruçao do baralho deve retornar 52 cartas")
    void testeQuantidadeDeCartasNaConstrucaoDoBaralho() {
        assertEquals(52, this.baralho.construirBaralho().size());
    }

    @Test
    @DisplayName("Depois de Distribuir cartas ao jogador, baralho deve ter 50 cartas")
    void testeQuantidadeDeCartasDepoisDeDistribuirCartas() {
        assertEquals(50, this.baralho.getCartas().size());
    }

    @Test
    @DisplayName("Mão do Jogador deve ter 2 cartas")
    void testeQuantidadeDeCartasNaMãoDoJogador() {
        assertEquals(2, this.jogador.getMaoDoJogador().size());
    }
}
