package org.blackjack;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Blackjack {

    public static void main(String[] args) {
        int boardWidth = 600;

        int cardWidth = 110;
        int cardHeight = 154;

        Baralho baralho = new Baralho();
        baralho.construirBaralho();
        baralho.embaralharCartas();

        Dealer dealer = new Dealer(baralho.getCartas());
        Jogador jogador = new Jogador(baralho.getCartas());

        JPanel buttonPanel = new JPanel();
        JButton hitButton = new JButton("Hit");
        JButton stayButton = new JButton("Stay");


        JFrame frame = new JFrame("Black Jack");
        JPanel gamePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                try {
                    Image cartaFiguraEscondida = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../carta/BACK.png"))).getImage();
                    if (!stayButton.isEnabled()) {
                        cartaFiguraEscondida = new ImageIcon(Objects.requireNonNull(getClass().getResource(dealer.getCartaEscondida().getImagemDaCarta()))).getImage();
                    }
                    graphics.drawImage(cartaFiguraEscondida, 20, 20, cardWidth, cardHeight, null);

                    //Desenha a mão do Dealer
                    for (int i = 0; i < dealer.getMaoDealer().size(); i++) {
                        Carta carta = dealer.getMaoDealer().get(i);
                        Image cartaFigura = new ImageIcon(Objects.requireNonNull(getClass().getResource(carta.getImagemDaCarta()))).getImage();
                        graphics.drawImage(cartaFigura, cardWidth + 25 + (cardWidth + 5) * i, 20, cardWidth, cardHeight, null);
                    }

                    //Desenha a mão do jogador
                    for (int i = 0; i < jogador.getMaoDoJogador().size(); i++) {
                        Carta carta = jogador.getMaoDoJogador().get(i);
                        Image cartaFigura = new ImageIcon(Objects.requireNonNull(getClass().getResource(carta.getImagemDaCarta()))).getImage();
                        graphics.drawImage(cartaFigura, 20 + (cardWidth + 5) * i, 320, cardWidth, cardHeight, null);
                    }

                    if (!stayButton.isEnabled()) {
                        dealer.setDealerSoma(reduzirOValorDosAsDoDealer(dealer));
                        jogador.setQuantidadeDePontosDoJogador(reduzirOValorDosAsDoJogador(jogador));
                        System.out.println("STAY: ");
                        System.out.println(dealer.getDealerSoma());
                        System.out.println(jogador.getQuantidadeDePontosDoJogador());

                        String message;
                        if (jogador.getQuantidadeDePontosDoJogador() > 21) {
                            message = "Você Perdeu!";
                        } else if (dealer.getDealerSoma() > 21) {
                            message = "Você ganhou!";
                        }
                        //both you and dealer <= 21
                        else if (jogador.getQuantidadeDePontosDoJogador() == dealer.getDealerSoma()) {
                            message = "Empate!";
                        } else if (jogador.getQuantidadeDePontosDoJogador() > dealer.getDealerSoma()) {
                            message = "Você Ganhou!";
                        } else {
                            message = "Você Perdeu!";
                        }

                        graphics.setFont(new Font("Arial", Font.PLAIN, 30));
                        graphics.setColor(Color.white);
                        graphics.drawString(message, 220, 250);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        frame.setVisible(true);
        frame.setSize(boardWidth, boardWidth);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53, 101, 77));
        frame.add(gamePanel);

        hitButton.setFocusable(false);
        buttonPanel.add(hitButton);
        stayButton.setFocusable(false);
        buttonPanel.add(stayButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        hitButton.addActionListener(e -> {
            Carta carta = baralho.getCartas().remove(baralho.getCartas().size() - 1);
            jogador.setQuantidadeDePontosDoJogador(jogador.getQuantidadeDePontosDoJogador() + carta.getValor());
            int as = carta.isAs() ? 1 : 0;
            jogador.setQuantidadeDeAsDoJogador(jogador.getQuantidadeDeAsDoJogador() + as);
            jogador.getMaoDoJogador().add(carta);
            if (reduzirOValorDosAsDoJogador(jogador) > 21) { //A + 2 + J --> 1 + 2 + J
                hitButton.setEnabled(false);
            }
            gamePanel.repaint();
        });

        stayButton.addActionListener(e -> {
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);

            while (dealer.getDealerSoma() < 17) {
                Carta carta = baralho.getCartas().remove(baralho.getCartas().size() - 1);
                dealer.setDealerSoma(dealer.getDealerSoma() + carta.getValor());
                int As = carta.isAs() ? 1 : 0;
                dealer.setDealerQuantidadeAs(dealer.getDealerQuantidadeAs() + As);
                dealer.getMaoDealer().add(carta);
            }
            gamePanel.repaint();
        });
    }

    private static int reduzirOValorDosAsDoJogador(Jogador jogador) {
        while (jogador.getQuantidadeDePontosDoJogador() > 21 && jogador.getQuantidadeDeAsDoJogador() > 0) {
            jogador.setQuantidadeDePontosDoJogador(jogador.getQuantidadeDePontosDoJogador() - 10);
            jogador.setQuantidadeDeAsDoJogador(jogador.getQuantidadeDeAsDoJogador() - 1);
        }
        return jogador.getQuantidadeDePontosDoJogador();
    }

    public static int reduzirOValorDosAsDoDealer(Dealer dealer) {
        while (dealer.getDealerSoma() > 21 && dealer.getDealerQuantidadeAs() > 0) {
            dealer.setDealerSoma(dealer.getDealerSoma() + 10);
            dealer.setDealerQuantidadeAs(dealer.getDealerQuantidadeAs() - 1);
        }
        return dealer.getDealerSoma();
    }
}