public class Pilha {
    
    public Lista lista = new Lista();

    public void push(int valor) {

        this.lista.addElemento(valor,false);

    }

    public Bloco pop() {

        return  this.lista.removerElementoFim();
    }

    public void topo(){

        Lista atual = lista;

        System.out.println("Topo: " + atual.localizarBloco(atual.tamanho()).valor);

    }
}
