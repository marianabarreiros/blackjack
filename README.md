# BLACK JACK (OU 21)

O Blackjack, também conhecido como 21, é um jogo de cartas de cassino em que o objetivo é obter uma mão com um valor total de cartas o mais próximo possível de 21, sem ultrapassá-lo. As regras básicas são:

1. Os jogadores recebem duas cartas viradas para cima, enquanto o dealer (croupier) recebe uma carta virada para cima e uma virada para baixo.

1. As cartas numéricas valem seu valor nominal, cartas de figuras (J, Q, K) valem 10 e o Ás pode valer 1 ou 11, dependendo da escolha do jogador.

1. Os jogadores podem optar por "ficar" (não pegar mais cartas) ou "pedir" (receber mais cartas) para tentar se aproximar de 21.

1. Se um jogador ultrapassar 21 pontos, ele perde imediatamente (chamado de "estourar" ou "bust").

1. Após todos os jogadores decidirem ficar ou pedir, o dealer revela sua carta virada para baixo e pega cartas adicionais até ter um total de 17 pontos ou mais.

1. O jogador com a mão mais próxima de 21 sem ultrapassar vence. Se o dealer ultrapassar 21, todos os jogadores que não estouraram ganham.

O Blackjack é um jogo de habilidade e estratégia, com regras simples, mas muitas nuances. Os jogadores podem tomar decisões estratégicas com base nas cartas visíveis do dealer e em suas próprias cartas para maximizar suas chances de vencer. É um dos jogos de cassino mais populares do mundo devido à sua simplicidade e emoção.


## O que você precisa
- [Java 17](https://www.oracle.com/java/technologies/downloads/) ou anterior
- [Maven 3.5+](https://maven.apache.org/download.cgi)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows) ou sua IDE favorita

## Como baixar esse projeto
- Em uma pasta de sua preferência, clone o repositório utilizando o seguinte comando:

```bash
git clone https://github.com/marianabarreiros/blackjack.git
```
- No intellij IDEA, configure o projeto como mostrado na figura abaixo:
<img width="782" alt="configuracao" src="https://github.com/marianabarreiros/blackjack/assets/7624708/5e4b8fb5-19c3-49f7-a8fa-e83c11a1158b">

- Em seguida, rode a aplicação e seu jogo deverá se parecer com isso:
<img width="547" alt="jogo" src="https://github.com/marianabarreiros/blackjack/assets/7624708/0efe01d0-0c1c-4d64-850e-713fc4497f75">

## Considerações a cerca do projeto

- A classe **Baralho**, representa um baralho de cartas em Java. O construtor cria um novo baralho ao chamar o método *construirBaralho()*, que retorna um ArrayList de cartas obtido a partir da classe Carta. O método *embaralharCartas()* embaralha as cartas no baralho, reorganizando-as em uma ordem aleatória, usando a classe *Collections.shuffle()*. Em resumo, a classe Baralho é responsável por criar um baralho de cartas e permitir que ele seja embaralhado.
- A classe **Carta** em Java representa uma carta de baralho. Ela tem os seguintes principais propósitos:

1. Armazena informações sobre uma carta, incluindo seu tipo (por exemplo, "C" para copas) e valor (por exemplo, "A" para Ás).
Fornece um método *toString()* para obter uma representação de string da carta no formato "valor-tipo" (por exemplo, "A-C" para o Ás de Copas).
1. Oferece um método estático *obterCartas()* que gera uma lista de todas as cartas do baralho, representando todos os tipos e valores possíveis.
1. Possui um método *getValor()* para obter o valor da carta (levando em consideração que "AJQK" tem valores especiais).
1. Oferece um método *isAs()* que verifica se a carta é um Ás.
1. Contém um método *getImagemDaCarta()* que retorna um caminho para uma imagem da carta (para exibição em uma interface de usuário, por exemplo).
Essa classe fornece funcionalidades básicas para representar e trabalhar com cartas de um baralho em um sistema de jogo ou aplicação que envolve cartas.

- A classe **Dealer** representa um dealer em um jogo de cartas, como o Blackjack. Ela tem os seguintes principais propósitos:

1. Armazena informações sobre o dealer, incluindo a carta escondida, a mão do dealer, a soma das cartas na mão do dealer e a quantidade de Ás na mão do dealer.

1. O construtor da classe Dealer é chamado com um baralho embaralhado como entrada. Ele inicializa a carta escondida do dealer, removendo a carta do topo do baralho embaralhado, e calcula a soma e a quantidade de Ás com base nessa carta.

1. Em seguida, o construtor inicializa a mão do dealer, removendo outra carta do topo do baralho embaralhado, calculando novamente a soma e a quantidade de Ás e adicionando a carta à mão do dealer.

Essa classe representa a lógica do dealer em um jogo de cartas, onde o dealer tem uma carta escondida e uma mão visível, e é responsável por distribuir cartas e fazer jogadas de acordo com as regras do jogo. Geralmente é usada em jogos como o Blackjack, onde o dealer precisa seguir regras específicas durante o jogo.

- A classe **Jogador** representa um jogador em um jogo de cartas, como o Blackjack. Ela tem os seguintes principais propósitos:

1. Armazena informações sobre o jogador, incluindo a mão do jogador, a quantidade de pontos do jogador e a quantidade de Ás na mão do jogador.

1. O construtor da classe Jogador pode ser chamado com ou sem um baralho embaralhado como entrada. Quando chamado com um baralho embaralhado, ele inicializa a mão do jogador com duas cartas retiradas do topo do baralho embaralhado, calcula a soma de pontos e a quantidade de Ás com base nessas cartas.

Essa classe representa a lógica de um jogador em um jogo de cartas, onde o jogador começa com uma mão e pode receber mais cartas ao longo do jogo. Geralmente é usada em jogos como o Blackjack, onde os jogadores tentam obter uma mão com um valor o mais próximo possível de 21 sem ultrapassá-lo.

- Por fim, A classe **Blackjack**, representa a lógica de um jogo de Blackjack (21). Ela tem os seguintes principais propósitos:

1. Inicializa um jogo de Blackjack, criando um baralho, embaralhando as cartas e distribuindo cartas para o dealer e o jogador.
1. Define uma interface gráfica simples usando a biblioteca Swing, com botões para "Pedir" e "Ficar".
1. Desenha as cartas do dealer e do jogador na interface gráfica.
1. Lida com as interações do jogador, permitindo que ele peça cartas adicionais ("Pedir") até decidir ficar ("Ficar").
1. Calcula a pontuação dos jogadores e determina o resultado do jogo (vitória, derrota ou empate).
1. Reduz o valor dos As, se necessário, para evitar ultrapassar 21 pontos.
Em resumo, essa classe encapsula a lógica de um jogo de Blackjack e fornece uma interface gráfica simples para os jogadores interagirem com o jogo. Ela também trata da lógica de pontuação e das regras do jogo, como pedir cartas adicionais e determinar o vencedor.

## Contribuindo

Pull requests são bem-vindas. Para mudanças importantes, abra primeiro uma edição para discutir o que você gostaria de mudar.

Certifique-se de atualizar os testes conforme apropriado. =)
## License

Open Source
