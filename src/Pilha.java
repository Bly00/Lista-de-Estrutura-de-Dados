public class Pilha {
    
    public Lista pilha = new Lista();


    public void push(int valor) {

        this.pilha.addElemento(valor,false);
    }

    public void pop() {

        this.pilha.removerElementoFim();
    }

    public void mostrarPilha(){

        Bloco atual = this.pilha.inicio;

        System.out.println("Pilha: ");

        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.prox;
        }
    }


    public void topo(){
        System.out.println("Topo: " + this.pilha.localizarBloco(this.pilha.tamanho()).valor);
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
