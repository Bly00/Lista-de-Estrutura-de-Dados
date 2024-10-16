public class ListaRecursiva {

    Bloco inicio;

    public static void main(String[] args) {
        
        ListaRecursiva listaRecursiva = new ListaRecursiva();

        listaRecursiva.addBloco(0);
        listaRecursiva.addBloco(1);
        listaRecursiva.addBloco(2);
        listaRecursiva.addBloco(3);
        listaRecursiva.addBloco(4);

        listaRecursiva.mostraLista();

    }


    public Bloco addBloco(int valor){

        Bloco novo = localizarBloco(tamanho());
        novo.valor = valor;
        int n = 0;
        

        if(novo.prox == null){
            this.inicio.prox = novo;
            return novo;
        }else{
            return addBloco(valor);
        }

    }

   
    private int tamanho(){
        return calcularTamanhoInicial(inicio);
    }

    public int calcularTamanhoInicial(Bloco bloco){

      if(bloco == null){
        return 0;
      }else if(bloco.prox == null){
        return 1;
      }else{
        return 1 + calcularTamanhoInicial(bloco.prox);
      }

    }

    private Bloco localizarBloco(int pos){
        return avancarBlocos(inicio, pos);
     }
 
     public Bloco avancarBlocos(Bloco bloco, int pos){
 
        if(pos > 0){
         return avancarBlocos(bloco.prox, pos - 1);
        }else{
         return bloco;
         
        }
     }

     public void mostraLista(){

        Bloco atual = inicio;

        System.out.println("Lista: ");

        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.prox;
        }

        System.out.println();

    }
 

    
}
