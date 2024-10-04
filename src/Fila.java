public class Fila {

    public Lista fila = new Lista();

    public static void main(String[] args) {
        
        Fila fila = new Fila();

        fila.push(10);
        fila.push(20);
        fila.mostrarFila();
        fila.pop();
        fila.mostrarFila();

    }

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
