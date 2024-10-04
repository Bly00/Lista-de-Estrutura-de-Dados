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
