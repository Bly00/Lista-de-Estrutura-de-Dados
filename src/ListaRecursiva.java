public class ListaRecursiva {

    Bloco inicio;

    public void addBloco(int valor){

        Bloco novoBloco = new Bloco();
        novoBloco.valor = valor;

        if(inicio == null){
            inicio = novoBloco;
        }else{
            addRecursivo(inicio, novoBloco);
        }

    }

    private void addRecursivo(Bloco atual, Bloco novoBloco){

        if(atual.prox == null){
            atual.prox = novoBloco;
        }else{
            addRecursivo(atual.prox, novoBloco);
        }

    }

    public void removerBlocoFim(){

        if(inicio == null){
        }
        else{
            removerFimRecursivo(inicio);
        }

    }

    private void removerFimRecursivo(Bloco atual){

        if(atual.prox.prox != null){
            removerFimRecursivo(atual.prox);
        }else{
            atual.prox = null;
        }

    }

   
    public int tamanho(){
        return calcularTamanhoInicial(inicio);
    }

    private int calcularTamanhoInicial(Bloco bloco){

      if(bloco == null){
        return 0;
      }else if(bloco.prox == null){
        return 1;
      }else{
        return 1 + calcularTamanhoInicial(bloco.prox);
      }

    }

     public Bloco localizarBloco(int pos){
        return avancarBlocos(inicio, pos);
     }
 
     private Bloco avancarBlocos(Bloco bloco, int pos){
 
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
