public class Pilha {
    
    public Lista pilha = new Lista();

    public void push(int valor) {

        this.pilha.addElemento(valor,false);

    }

    public Bloco pop() {

        return  this.pilha.removerElementoFim();
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

        Lista atual = pilha;

        System.out.println("Topo: " + atual.localizarBloco(atual.tamanho()).valor);

    }

    public Fila paraFila(){

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
