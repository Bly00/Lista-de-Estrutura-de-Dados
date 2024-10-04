public class Fila {

    Lista fila = new Lista();


    public void push(int novoValor){

        Lista atual = fila;

        System.out.println("Adicionado " + novoValor + " a fila");

        atual.addElemento(novoValor, false);

    }

    public void pop(){
        
        Lista atual = fila;

        System.out.println("Removido " + atual.inicio.valor + " da fila");

        atual.removerElementoInicio();

    }

    public void mostrarFila(){

        Lista atual = fila;
        
        System.out.println("Fila:");

        while(atual.inicio != null){
            System.out.println(atual.inicio.valor);
            atual.inicio = atual.inicio.prox;
        }

    }

    
}
