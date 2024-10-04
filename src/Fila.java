public class Fila {

    public Lista fila = new Lista();

    public void push(int novoValor){

        Lista atual = fila;

        atual.addElemento(novoValor, false);

    }

    public void pop(){

        this.fila.removerElementoInicio();

    }

    public void mostrarFila(){

        System.out.println("Fila:");

        while(fila.inicio != null){
            System.out.println(fila.inicio.valor);
            fila.inicio = fila.inicio.prox;
        }

    }

    
}
