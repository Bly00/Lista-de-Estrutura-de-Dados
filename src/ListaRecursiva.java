public class ListaRecursiva {

    Lista lista;

    public static void main(String[] args) {
        
        ListaRecursiva lista = new ListaRecursiva();

        lista.lista.addElemento(10, false);
        lista.lista.addElemento(20, false);
        lista.lista.mostraLista();

    }

  
      

    private int tamanhoResursivo(){

        Bloco atual = this.lista.inicio;
        int cont = 0;

        if(atual.prox != null){
            cont++;
            return tamanhoResursivo();
        }

        return cont;

    }
    
}
