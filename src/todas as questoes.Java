//1. Implemente a classe Fila adicionando os métodos push e pop.

public class Fila {

    
    public void push(int novoValor){

        this.fila.addElemento(novoValor, false);

    }

    public void pop(){ 

        if(this.fila.inicio != null){

           this.fila.removerElementoInicio();

        }else{
            System.out.println("Fila vazia");
            return;
        }

    }
}

//2. Adicione o método “topo” na classe Pilha que retorna o topo da Pilha.

public Bloco topo(){
    return this.pilha.localizarBloco(this.pilha.tamanho());
}

//3. Implemente a classe PilhaFila que utiliza Filas para simular uma Pilha.

public class PilhaFila {

    private Fila pilha = new Fila();

    public void push(int novoElemento){

        this.pilha.push(novoElemento);

    }

    public void pop(){

        if(this.pilha.fila.isVazia()){
            System.out.println("Vazia");
            return;
        }

        Bloco atual = this.pilha.fila.inicio;
        Bloco penultimo = null;

        while(atual.prox != null){
            penultimo = atual;
            atual = atual.prox;
        }
        
        if(penultimo.prox != null){
            penultimo.prox = null;
        }else{

            this.pilha.fila.inicio = null;

        }

    }

    public void mostrarPilhaFila(){

        Bloco atual = this.pilha.fila.inicio;

        System.out.println("PilhaFila:");

        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.prox;
        }

    }

    
    
}


//4. Implemente a classe FilaPilha que utiliza Pilhas para simular uma Fila.

public class FilaPilha {

    Pilha fila = new Pilha();


    public void push(int novoElemento){

        fila.push(novoElemento);

    }

    public void pop(){

        if(this.fila.pilha.isVazia()){
            System.out.println("Vazia");
            return;
        }

        this.fila.pilha.inicio = this.fila.pilha.inicio.prox;
        
    }

    public void mostrarFilaPilha(){
        Bloco aux = this.fila.pilha.inicio;
        System.out.println("FilaPilha:");
        while(aux != null){
            System.out.println(aux.valor);
            aux = aux.prox;
        }

    }
    
}


//5. Defina um método em Pilha que retorna uma Fila equivalente.

public Fila filaEquivalente(){

    if(this.pilha.isVazia()){
        System.out.println("Pilha vazia");
        return null;
    }

    Fila filaEquivalente = new Fila();

    Bloco aux = this.pilha.inicio;

    while(aux != null){
        filaEquivalente.push(aux.valor);
        aux = aux.prox;
    }

    return filaEquivalente;
}

//6. Defina um método em Fila que retorna uma Pilha equivalente.

public Pilha pilhaEquivalente(){

    if(this.fila.inicio == null){
        return null;
    }
    
    Bloco aux = this.fila.inicio;
    Pilha pilhaEquivalente = new Pilha();

    while(aux != null){
        pilhaEquivalente.push(aux.valor);
        aux = aux.prox;
    }

    return pilhaEquivalente;
}

//7. Na classe Lista, implemente o método inverte que retorna uma Lista com os elementos em ordem invertida.

public void inverter(){

    if(this.isVazia()){
        System.out.println("Lista vaiza");
        return;
    }


    Lista listaInvertida = new Lista();
    Bloco aux = this.inicio;
    
    for(int z = this.tamanho(); z > 0; z--){

        listaInvertida.addElementoInicio(aux.valor);
        aux = aux.prox;

    }

    for(int i = this.tamanho(); i > 0;  i--){
   this.removerElementoFim();
}


    aux = listaInvertida.inicio;
    while(aux != null){
        this.addElementoFim(aux.valor);
        aux = aux.prox;
    }

}

//8. Implemente em Lista o método para addElemento(int valor, int pos) que adiciona um elemento na posição especificada. A posição pode ou não existir.

public void addElemento(int novoValor, int pos) {
       
    if(pos >= tamanho() || isVazia()){
       this.addElementoFim(novoValor);

    }else{

       if(pos  == 0){
           Bloco novo = new Bloco();
           novo.valor = novoValor;
           novo.prox = this.inicio;
           this.inicio = novo;
       }else{

           Bloco anterior = localizarBloco(pos + 1);
           Bloco novo = new Bloco();
           novo.valor = novoValor;

           Bloco aux = anterior.prox;
           anterior.prox = novo;
           novo.prox = aux;
           novo.ante = anterior;

       }
       

    }
    
}

//9. Implemente uma classe ListaDupla que implementa o duplo encadeamento dos blocos. Sendo assim o Bloco precisa ser também modificado.

public class Bloco{
int valor;
Bloco prox;
Bloco ante; //anterior
}
//Bloco ganha anterior

public void addElemento(int novoValor, int pos) {
       
    if(pos >= tamanho() || isVazia()){
       this.addElementoFim(novoValor);

    }else{

       if(pos  == 0){
           Bloco novo = new Bloco();
           novo.valor = novoValor;
           novo.prox = this.inicio;
           this.inicio = novo;
       }else{

           Bloco anterior = localizarBloco(pos + 1);
           Bloco novo = new Bloco();
           novo.valor = novoValor;

           Bloco aux = anterior.prox;
           anterior.prox = novo;
           novo.prox = aux;
           novo.ante = anterior;

       }
    
    }
       

    }private Bloco addElementoInicio(int valor) {

        if(!this.isVazia()){
            System.out.println("Lista Vazia");
            return null;
        }

        Bloco novo = new Bloco();
        novo.valor = valor;
        
        novo.prox = this.inicio;
        this.inicio.ante = novo;
        this.inicio = novo;

        return novo;
    }

    private Bloco addElementoFim(int valor) {

        Bloco novo = null;

        //Bloco fim = this.localizarBloco(this.tamanho());

        Bloco fim = this.inicio;


        if(fim == null) {

            novo = this.addElementoInicio(valor);

        } else {

            while(fim.prox != null){
                fim = fim.prox;
            }

            novo = new Bloco();
            novo.valor = valor;

            fim.prox = novo;
            novo.ante = fim;

        }


        return novo;
    }
    
    //Os metodos de adicionar foram implementados para lidar com o anterior


//10. Implemente a Lista com array ao invés de uma lista encadeada. No array, blocos também serão adicionados.


public class ListaArray {


    int maximo = 0;
    int[] inicio = new int[maximo];


    public void addElemento(int valor, int pos) {
        if (pos > maximo - 1) {
            addElementoFim(valor);
            return;
        }
        if(pos == 0){
            addElementoInicio(valor);
            return;
        }


        maximo++;
        int[] novoInicio = new int[maximo];

        for (int i = 0; i < inicio.length; i++) {

                novoInicio[i] = inicio[i];

        }

        int i;

        for(i = novoInicio.length - 1; i > pos; i--){

           novoInicio[i] = novoInicio[i - 1];

        }

        novoInicio[i] = valor;
        this.inicio = novoInicio;

    }

    public void addElementoInicio(int valor){

        if(maximo == 0){
            maximo++;
            inicio = new int[maximo];
            inicio[0] = valor;
            return;
        }

        maximo++;
        int[] novoInicio = new int[maximo];
        novoInicio[0] = valor;


        for(int i = 1 ,z = 0; z < inicio.length; i++, z++){

            novoInicio[i] = inicio[z];

        }

        this.inicio = novoInicio;

    }

    public void addElementoFim(int novoValor){

        if(maximo == 0){
            maximo++;
            inicio = new int[maximo];
            inicio[0] = novoValor;
            return;
        }


        maximo++;
        int[] novoInicio = new int[maximo];
        for(int i = 0; i < inicio.length; i++){
            novoInicio[i] = inicio[i];
        }

        novoInicio[maximo - 1] = novoValor;
        this.inicio = novoInicio;

    }

    public void removerElemento(int pos){

        if(pos >= maximo - 1){
            removerElementoFim();
            return;
        }
        if(pos == 0){
            removerElementoInicio();
            return;
        }

       maximo--;
        int[] novoInicio = new int[maximo];

    
    for(int i = 0, z = 0; i <= maximo - 1; i++, z++){

        if(z == pos){
            z++;
        }

        novoInicio[i] = inicio[z];

    }

        inicio = novoInicio;

    }

    public void removerElementoFim(){

        if(maximo == 0){
            System.out.println("lista vazia");
            return;
        }

        maximo--;
        int[] novoInicio = new int[maximo];

        for(int i = 0; i < novoInicio.length; i++){

            novoInicio[i] = inicio[i];

        }

        inicio = novoInicio;

    }


    public void removerElementoInicio(){

        maximo--;
        int[] novoInicio = new int[maximo];

        for(int i = 0; i <= novoInicio.length - 1; i++){
            novoInicio[i] = inicio[i + 1];
        }

        inicio = novoInicio;

    }

    public void mostrarListaArray(){

        System.out.println("Lista de Array:");
        for(int i = 0; i < inicio.length; i++){
            System.out.println(inicio[i]);
        }

    }


    
}


//11. Implemente a classe ListaRecursiva que define métodos recursivos de localizar e de tamanha. Lembre-se que os métodos devem ser declarados como private para não ficarem disponíveis para o usuário programador.

public class ListaRecursiva {

    Bloco inicio;

    public void addBloco(int valor){

        Bloco novoBloco = new Bloco();
        novoBloco.valor = valor;

        if(inicio == null){
            inicio = novoBloco;
        }else{
            addRecursivo(inicio, novoBloco);
        }

    }

    private void addRecursivo(Bloco atual, Bloco novoBloco){

        if(atual.prox == null){
            atual.prox = novoBloco;
        }else{
            addRecursivo(atual.prox, novoBloco);
        }

    }

    public void removerBlocoFim(){

        if(inicio == null){
        }
        else{
            removerFimRecursivo(inicio);
        }

    }

    private void removerFimRecursivo(Bloco atual){

        if(atual.prox.prox != null){
            removerFimRecursivo(atual.prox);
        }else{
            atual.prox = null;
        }

    }

   
    public int tamanho(){
        return calcularTamanhoInicial(inicio);
    }

    private int calcularTamanhoInicial(Bloco bloco){

      if(bloco == null){
        return 0;
      }else if(bloco.prox == null){
        return 1;
      }else{
        return 1 + calcularTamanhoInicial(bloco.prox);
      }

    }

     public Bloco localizarBloco(int pos){
        return avancarBlocos(inicio, pos);
     }
 
     private Bloco avancarBlocos(Bloco bloco, int pos){
 
        if(pos > 0){
         return avancarBlocos(bloco.prox, pos - 1);
        }else{
         return bloco;
         
        }
     }

     public void mostraLista(){

        Bloco atual = inicio;

        System.out.println("Lista: ");

        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.prox;
        }

        System.out.println();

    }
 

    
}


//12. Utilize uma das estruturas para resolver o seguinte problema de soma: ((1+3)*(3+4))+7)/35. Esse problema pode ser modelado assim: 1 3 + 3 4 + * 7 + 35 /.

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

//13. Implemente o método “concatena(Lista l2)” na classe Lista. O método deve concatenar os elementos da lista atual com os elementos da lista passada como parâmetro, retornando uma nova lista.

public Lista concatena(Lista l2){

    Bloco atual = l2.inicio;
    Lista novaListaConcatenada = this;

    while(atual != null){
        novaListaConcatenada.addElementoFim(atual.valor);
        atual = atual.prox;
    }

    return novaListaConcatenada;

}

//14. Implemente um método “removeDuplicados” na classe Lista. Esse método deve percorrer a lista e remover todos os elementos duplicados, mantendo apenas a primeira ocorrência.

//metodo principal

public void removerDuplicados() {
    Bloco atual = this.inicio;

    while (atual != null) {
       
        Lista aux = acharPorValor(atual.valor);

        if (aux.tamanho() > 1) {
          
            Bloco proximo = atual.prox;

            for (int i = 1; i < aux.tamanho(); i++) {
              
                removerElemento(aux.getElemento(i)); 
            }

            atual = proximo; 
        } else {
            atual = atual.prox; 
        }
    }
}

//Retorna uma lista com a posicoes do valor especificado

public Lista acharPorValor(int valor) {
    Bloco atual = this.inicio;
    Lista listaRepetidos = new Lista();

    for (int i = 0; atual != null; i++) {
        if (atual.valor == valor) {
            listaRepetidos.addElementoFim(i); // Armazena o índice
        }
        atual = atual.prox;
    }

    return listaRepetidos;
}

//retorna o valor do blovo na posicao desejada

public int getElemento(int pos) {
    if (pos < 0 || pos >= tamanho()) {
        return 0;
    }

    Bloco atual = this.inicio;
    for (int i = 0; i < pos; i++) {
        atual = atual.prox; 
    }

    return atual.valor; 
}

//15. Crie um método “clone” na classe Lista. Esse método deve retornar uma nova instância de Lista com os mesmos elementos da lista original.

public Lista clone(){

    Lista novoListaClonada = new Lista();
    Bloco atual = this.inicio;

    while(atual != null){

      novoListaClonada.addElementoFim(atual.valor);
      atual = atual.prox;
    }  

    return novoListaClonada;

  }

//16. Implemente a classe FilaPrioridade. os elementos serão retirados com base em sua prioridade (maior prioridade sai primeiro).

public class FilaPrioridade {

    Bloco inicio;

    public static void main(String[] args) {
        
        FilaPrioridade filaPrioridade = new FilaPrioridade();

        filaPrioridade.addElemento(0, 10);
        filaPrioridade.addElemento(10, 5);
        filaPrioridade.addElemento(56, 3);
        filaPrioridade.addElemento(40, 9);

        filaPrioridade.mostraFila();

    }

    
    public void addElemento(int valor, int prioridade) {
        Bloco novo = new Bloco();
        novo.valor = valor;
        novo.prioridade = prioridade;
        
        if (this.inicio == null) {
           
            this.inicio = novo;
        } else {
           
            Bloco atual = this.inicio;
            Bloco anterior = null;
            
            while (atual != null && atual.prioridade >= prioridade) {
                anterior = atual;
                atual = atual.prox;
            }
            
            if (anterior == null) {
                
                novo.prox = this.inicio;
                this.inicio = novo;
            } else {
               
                anterior.prox = novo;
                novo.prox = atual;
            }
        }
    }

    public Bloco removerElemento() {
        if (this.inicio == null) {
            System.out.println("vazia");
            return null;
        }

        Bloco removido = this.inicio;
        this.inicio = this.inicio.prox; 
        return removido;
    }

    public void mostraFila() {
        if (this.inicio == null) {
            System.out.println("vazia");
            return;
        }

        Bloco atual = this.inicio;
        System.out.println("Fila de Prioridade:");
        while (atual != null) {
            System.out.println(atual.valor + " - Prioridade: " + atual.prioridade);
            atual = atual.prox;
        }
    }
    
    public int tamanho() {
        Bloco aux = this.inicio;
        int cont = 0;

        while (aux != null) {
            cont++;
            aux = aux.prox;
        }

        return cont;
    }
}


//17. Implemente o método “removeElemento(int pos)” na classe Lista. Esse método devecremover o elemento na posição especificada.

public void removerElemento(int pos){

    if(pos < 0 || pos >= tamanho()){
        return;
    }

    if(pos == 0){
        this.inicio = this.inicio.prox;
        return;
    }
    if(pos == tamanho() - 1){
        this.removerElementoFim();
        return;
    }

    Bloco target = this.localizarBloco(pos);
    target.prox = target.prox.prox;

}

//18. Adicione o método “localizarMaior(int valor)” na classe Lista. Esse método deve retornar uma Lista com todos os blocos que contenham um valor maior do que o valor passado .

public Lista localizarMaior(int valor){

    Lista listaComMaiores = new Lista();
    
    Bloco atual = this.inicio;

    while(atual != null){

        if(atual.valor > valor){
            listaComMaiores.addElementoFim(atual.valor);
        }

        atual = atual.prox;
    }

    return listaComMaiores;

}

//19. Implemente um jogo de baralho com dois decks, um para cartas jogador. O jogador vencedor é o que retira as 5 primeiras cartas com a maior soma.

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

//20. Tipicamente os jogos da velha são implementados através de matrizes, porém o desafio aqui é implementar utilizando uma única lista.

import java.util.Scanner;

public class JogoDaVelha {

    
    public static void main(String[] args) {

        Lista jogo = new Lista();
       
        Scanner sc = new Scanner(System.in);

        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
    
        boolean jogador = false;
        //false = X = 1
        //true = 0 = 2

        int pos = 0;
        int status = 0;
        int quantJogadas = 0;

        while(true){

        System.out.println("Escolha posicao");
        pos = sc.nextInt();

        if(pos < 1 || pos > 9){
            System.out.println("Posicao invalida");
        }else{

        Bloco posJogada = jogo.localizarBloco(pos);

        
        
        if(jogador == false){

            if(posJogada.valor == 0){
                posJogada.valor = 1;
            }else{
                System.out.println("Essa posicao ja esta oculpada");
                jogador = !jogador;
                quantJogadas--;
            }

        }else{

            if(posJogada.valor == 0){
                posJogada.valor = 2;
            }else{
                System.out.println("Essa posicao ja esta oculpada");
                jogador = !jogador;
                quantJogadas--;
            }

        }

        quantJogadas++;

        mostrarJogo(jogo);

        status = verificarJogo(jogo);

        if(status != 0 || quantJogadas == 9){
            break;
        }
        jogador = !jogador;

    }

  

    }
    if(status == 0){
        System.out.println("Empate");
    }else if(status == 1){
        System.out.println("X foi o ganhador");
    }
    else if(status == 2){
        System.out.println("0 foi o ganhador");
    }

    sc.close();

    }

    public static void mostrarJogo(Lista jogo){

        Bloco atual = jogo.inicio;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.println("_");
    }
    if(atual.valor == 1){
    System.out.println("X");
    }
    if(atual.valor == 2){
    System.out.println("0");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
    
    atual = atual.prox;
    
    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
    
    atual = atual.prox;
    
    if(atual.valor == 0){
    System.out.println("_");
    }
    if(atual.valor == 1){
    System.out.println("X");
    }
    if(atual.valor == 2){
    System.out.println("0");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
        
    atual = atual.prox;
        
    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
        
    atual = atual.prox;
        
    if(atual.valor == 0){
    System.out.println("_");
    }
    if(atual.valor == 1){
    System.out.println("X");
    }
    if(atual.valor == 2){
    System.out.println("0");
    }
    

    }

    public static int verificarJogo(Lista jogo){

    if(jogo.localizarBloco(1).valor == 1 && (jogo.localizarBloco(2).valor == 1 && jogo.localizarBloco(3).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(4).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(6).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(7).valor == 1 && (jogo.localizarBloco(8).valor == 1 && jogo.localizarBloco(9).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(1).valor == 1 && (jogo.localizarBloco(4).valor == 1 && jogo.localizarBloco(7).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(2).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(8).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(3).valor == 1 && (jogo.localizarBloco(6).valor == 1 && jogo.localizarBloco(9).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(1).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(9).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(3).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(7).valor == 1)){
        return 1;
    }

        

    if(jogo.localizarBloco(1).valor == 2 && (jogo.localizarBloco(2).valor == 2 && jogo.localizarBloco(3).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(4).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(6).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(7).valor == 2 && (jogo.localizarBloco(8).valor == 2 && jogo.localizarBloco(9).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(1).valor == 2 && (jogo.localizarBloco(4).valor == 2 && jogo.localizarBloco(7).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(2).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(8).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(3).valor == 2 && (jogo.localizarBloco(6).valor == 2 && jogo.localizarBloco(9).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(1).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(9).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(3).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(7).valor == 2)){
        return 2;
    }
        return 0; 

    }
    
}


//Questão especial:

//21. Implemente as classes “Aluno” com os atributos “nome” e “matrícula” e “Disciplina” com o atributo nome. Implemente também a classe “Turma” com os atributos “alunos”, “disciplina” e “código”. A lista de alunos deve ser implementada com a classe Lista que vem sendo desenvolvida até então.
//22. Para complementar a questão 21, implemente uma solução para o cadastro das notas dos alunos. Lembre-se, sempre que houver a necessidade de uso de lista, utilize a classe Lista que vem sendo desenvolvida até então.

import java.util.Random;

public class Aluno {

    public String nome;
    private int matricula;
    public Lista notas; 

    public Aluno(String nome) {
        Random ram = new Random();
        this.nome = nome;
        this.matricula = ram.nextInt(1000); 
        this.notas = new Lista();
    }

    public int getMatricula() {
        return matricula;
    }

}


import java.util.Random;

public class Turma {

    Lista alunos = new Lista();
    Disciplina disciplina;
    int codigo;

    

    public Turma(Disciplina disciplina) {
        Random ram = new Random(); 
        this.disciplina = disciplina;
        this.codigo = ram.nextInt(1000);
    }

    public void addAluno(Aluno novoAluno) {
        Bloco novoBloco = new Bloco();
        novoBloco.aluno = novoAluno; 
    
       
        if (this.alunos.isVazia()) {
            this.alunos.inicio = novoBloco;
        } else {
            
            Bloco atual = this.alunos.inicio;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            
            atual.prox = novoBloco;
            novoBloco.ante = atual;
        }
    }

    public void removerAluno(String nome) {
        if (this.alunos.isVazia()) {
            System.out.println("A lista de alunos está vazia.");
            return;
        }

        Bloco atual = this.alunos.inicio;
        Bloco anterior = null;

        while (atual != null) {
            if (atual.aluno.nome.equals(nome)) {
                
                if (anterior == null) {
                    this.alunos.inicio = atual.prox;
                } else {
                    anterior.prox = atual.prox;
                }
                System.out.println("Aluno " + nome + " removido.");
                return;
            }
            anterior = atual;
            atual = atual.prox;
        }

        System.out.println("Aluno " + nome + " não encontrado.");
    }


    public Aluno localizarAluno(String nome) {
        Bloco atual = this.alunos.inicio;

        while (atual != null) {
            if (atual.aluno.nome.equals(nome)) {
                return atual.aluno;
            }
            atual = atual.prox;
        }

        System.out.println("Aluno " + nome + " não encontrado.");
        return null;
    }
    
    public void mostrarListaAluno() {
        Bloco atual = this.alunos.inicio;
        int i = 1;
    
        while (atual != null) {
            Aluno aluno = atual.aluno; 
            System.out.println("Aluno " + i);
            System.out.println("Nome: " + aluno.nome);
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println();
            atual = atual.prox;
            i++;
        }
    }
    
}

