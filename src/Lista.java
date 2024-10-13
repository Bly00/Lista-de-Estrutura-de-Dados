import java.util.Scanner;

public class Lista {

    Bloco inicio;

    public static void main(String[] args) {
        
        Lista lista = new Lista();
        Scanner sc = new Scanner(System.in);


        lista.addElementoFim(50);
        lista.addElementoFim(20);
        lista.addElementoFim(80);//
        lista.addElementoFim(50);//
        lista.addElementoFim(60);//
        lista.addElementoFim(60);//
        lista.addElementoFim(80);//
        lista.addElementoFim(20);
        lista.addElementoFim(60);//
        lista.addElementoFim(30);
        lista.addElementoFim(30);
        lista.addElementoFim(60);//
        
        
       

        lista.removerDuplicados();

        lista.mostraLista();
        
       
        
     
        

       

      
    }

    public Bloco addElemento(int valor,boolean posicaoIncio) {

        Bloco novo = null;

        if(posicaoIncio == true) {

            novo = this.addElementoInicio(valor);


        } else {

            novo = this.addElementoFim(valor);

        }

        return novo;
    }


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
                System.out.println("Bloco localizado: " + anterior.valor);
                Bloco novo = new Bloco();
                novo.valor = novoValor;

                Bloco aux = anterior.prox;
                anterior.prox = novo;
                novo.prox = aux;
                novo.ante = anterior;

            }
            

         }
         
    }

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

   
    

    public Bloco removerElementoFim() {

        Bloco result = null;

        if(this.isVazia()) {
            return result;
        }

        if(this.tamanho() == 1) {
            //this.inicio = null;
            result = this.removerElementoInicio();
        } else {

            Bloco target = this.localizarBloco(this.tamanho()-1);
    
            result = target.prox;
            target.prox = null;

        }

        return result;
    }

    public Bloco removerElementoInicio() {

        Bloco result = this.inicio;
        if(!this.isVazia()) {

            this.inicio = this.inicio.prox;
        }

        return result;
    }

    public boolean isVazia() {
        return this.inicio == null;
    }

    private Bloco addElementoInicio(int valor) {

        if(!this.isVazia()){
            System.out.println("Lista vazia");
            return null;
        }

        Bloco novo = new Bloco();
        novo.valor = valor;
        
        novo.prox = this.inicio;
        this.inicio = novo;
              
        return novo;
    }

    private Bloco addElementoFim(int valor) {

        Bloco novo = null;

        Bloco fim = this.localizarBloco(this.tamanho());

        if(fim == null) {

            novo = this.addElementoInicio(valor);

        } else {

            novo = new Bloco();
            novo.valor = valor;

            fim.prox = novo;
            novo.ante = fim;

        }


        return novo;
    }

    public Bloco localizarBloco(int pos) {

        Bloco aux = this.inicio;
        int cont = 0;

        while(aux!= null && cont < pos -1) {

            cont++;
            aux = aux.prox;
        }

        return aux;
    }

    public int tamanho() {

        Bloco aux = this.inicio;
        int cont =0;

        while(aux != null) {

            cont++;
            aux = aux.prox;
        }

        return cont;
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


    public void infoElemento(Bloco atual){

        if(this.isVazia()) {
            System.out.println("lista vazia");
            return;
        }else if(atual == null && atual.ante == null){
            System.out.println("Elemento vazio");
            return;
        }

        int ante = 0, pro = 0;


        if(atual.ante == null){
            ante = 1;
        }
        if(atual.prox == null){
            pro = 1;
        }

        if(ante != 1 && atual == null){
            System.out.println("Anterior: " + atual.ante.valor);
            System.out.println("Atual é vazio");
            System.out.println("Proximo é vazio");
            return;
        }

        if(ante != 1 && pro != 1){
            System.out.println("Anterior: " + atual.ante.valor);
            System.out.println("Atual: " + atual.valor);
            System.out.println("Proximo: " + atual.prox.valor);
            return;
        }

        if(ante == 1 && pro != 1){
            System.out.println("Anterior é null");
            System.out.println("Atual: " + atual.valor);
            System.out.println("Proximo: " + atual.prox.valor);
            return;
        }
        if(ante != 1 && pro == 1){
            System.out.println("Anterior: " + atual.ante.valor);
            System.out.println("Atual: " + atual.valor);
            System.out.println("Proximo é null");
            return;
        }

    }

    public void mostrarListaInfo(){

        for(int i = 1; localizarBloco(i) != null; i++){
            infoElemento(localizarBloco(i));
            System.out.println();
        }

    }
    
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

    /*public void removerDuplicados(){

        Bloco atual = this.inicio;
        Lista aux = null;

        while(atual != null){

            System.out.println("valor veerificado: " + atual.valor);

            aux = acharPorValor(atual.valor);
            Bloco aux2 = aux.inicio;

            int tam = aux.tamanho();


            if(aux2.prox != null){
            }else{
                aux2 = aux2.prox;
            }
            
            while(aux2.prox != null && tam > 1){

                removerElemento(aux2.valor);

                aux2 = aux2.prox;

            }

            atual = atual.prox;
        }

}*/

public void removerDuplicados() {
    Bloco atual = this.inicio;

    while (atual != null) {
        // Encontre todas as ocorrências do valor atual
        Lista aux = acharPorValor(atual.valor);

        // Se há mais de uma ocorrência, remova as duplicatas
        if (aux.tamanho() > 1) {
            // A primeira ocorrência já está em 'atual'
            Bloco proximo = atual.prox;

            // Remover as duplicatas
            for (int i = 1; i < aux.tamanho(); i++) {
                // Remova a duplicata
                removerElemento(aux.getElemento(i)); // assume que você tenha um método getElemento que retorna o valor pelo índice
            }

            // Mova o ponteiro atual para o próximo
            atual = proximo; 
        } else {
            atual = atual.prox; // avança apenas se não houver duplicatas
        }
    }
}


public int getElemento(int pos) {
    if (pos < 0 || pos >= tamanho()) {
        throw new IndexOutOfBoundsException("Posição inválida");
    }

    Bloco atual = this.inicio;
    for (int i = 0; i < pos; i++) {
        atual = atual.prox; // Avança para o próximo bloco
    }

    return atual.valor; // Retorna o valor do bloco na posição desejada
}

}