public class Questao12 {

    Pilha calculadora = new Pilha();

    public static void main(String[] args) {
        Questao12 q12 = new Questao12();

        q12.calculadora.push(1);
        q12.calculadora.push(3);
        //pilha: 1 3
        
        q12.soma();//pilha: (1 + 3) -> pilha: 4
       
        q12.calculadora.push(3);
        q12.calculadora.push(4);
        //pilha: 4 3 4
        
        q12.soma(); //pilha: 4 (3 + 4) -> pilha: 4 7
        
        q12.multiplicacao();// pilha: (4 * 7) -> pilha: 28

        q12.calculadora.push(7);
        //pilha: 28 7
        
        q12.soma();// pilha (28 + 7) -> pilha: 35
    
        q12.calculadora.push(35);
        //Pilha: 35 35

        q12.divisao();//Pilha: (35 / 35) -> pilha: 1


        q12.calculadora.mostrarPilha();
        //pilha: 1
    }

   
    public void soma() {
        if (calculadora.pilha.tamanho() < 2) {
            System.out.println("Sem elementos suficientes");
            return;
        }

        int valor1 = calculadora.pop();
        int valor2 = calculadora.pop();

        int resultado = valor1 + valor2;
        calculadora.push(resultado);
    }

    
    public void multiplicacao() {
        if (calculadora.pilha.tamanho() < 2) {
            System.out.println("Sem elementos suficientes");
            return;
        }

       
        int valor1 = calculadora.pop();
        int valor2 = calculadora.pop();

        int resultado = valor1 * valor2;
        calculadora.push(resultado);
    }

    
    public void divisao() {
        if (calculadora.pilha.tamanho() < 2) {
            System.out.println("Nao ha elementos suficientes");
            return;
        }

        int divisor = calculadora.pop();
        int dividendo = calculadora.pop();

        if (divisor == 0) {
            System.out.println("Erro: divisao por zero");
            calculadora.push(dividendo);
            calculadora.push(divisor);
            return;
        }

        
        int resultado = dividendo / divisor;
        calculadora.push(resultado);
    }
}
