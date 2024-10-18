import java.util.Random

;class Jogador {
    Bloco deck;

    public void receberDeck() {
        Random r = new Random();
        // Inicializa o primeiro bloco com um valor aleatório
        this.deck = new Bloco(r.nextInt(10) + 1); 

        Bloco atual = this.deck;
        for (int i = 1; i < 5; i++) { // Adiciona mais 4 blocos
            atual.prox = new Bloco(r.nextInt(10) + 1);
            atual = atual.prox;
        }
    }

    public int calcularSoma() {
        int soma = 0;
        Bloco atual = this.deck;
        while (atual != null) {
            soma += atual.valor;
            atual = atual.prox;
        }
        return soma;
    }

    public void mostrarCartas() {
        Bloco atual = this.deck;
        System.out.print("Cartas do jogador: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }
        System.out.println();
    }
}