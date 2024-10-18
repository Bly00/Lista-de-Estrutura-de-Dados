public class JogoCartas {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        Jogador jogador3 = new Jogador();

        jogador1.receberDeck();
        jogador2.receberDeck();
        jogador3.receberDeck();

        Jogador[] jogadores = {jogador1, jogador2, jogador3};

        Jogador vencedor = null;
        int melhorSoma = 0;

        for (int i = 0; i < jogadores.length; i++) {
            jogadores[i].mostrarCartas();
            int soma = jogadores[i].calcularSoma();
            System.out.println("Soma das cartas: " + soma);
            if (soma > melhorSoma) {
                melhorSoma = soma;
                vencedor = jogadores[i];
            }
        }

        System.out.println("O jogador vencedor é: " + (vencedor == jogador1 ? "Jogador 1" : vencedor == jogador2 ? "Jogador 2" : "Jogador 3"));
    }

}