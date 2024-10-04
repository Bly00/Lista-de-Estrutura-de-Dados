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
