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

        Bloco fila = this.fila.inicio;

        while(fila != null){
            System.out.println(fila.valor);
            fila = fila.prox;
        }

    }

    
}
