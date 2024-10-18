public class Pilha {
    
    public Lista pilha = new Lista();


    public void push(int valor) {

        this.pilha.addElemento(valor,false);
    }

    public int pop() {

        Bloco atual = this.pilha.inicio;

        while(atual.prox != null){
            atual = atual.prox;
        }

        int pop = atual.valor;

        this.pilha.removerElementoFim();

        return pop;

    }

    public void mostrarPilha(){

        Bloco atual = this.pilha.inicio;

        System.out.println("Pilha: ");

        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.prox;
        }
    }


    public Bloco topo(){
        return this.pilha.localizarBloco(this.pilha.tamanho());
    }


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


}
