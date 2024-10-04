public class Fila {

    public Lista fila = new Lista();
    

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

    public void mostrarFila(){

        System.out.println("Fila:");

        Bloco aux = this.fila.inicio;

        while(aux != null){
            System.out.println(aux.valor);
            aux = aux.prox;
        }

    }


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

    
}
