public class Sla {

   Bloco inicio;

    public static void main(String[] args) {
        
        Sla sla = new Sla();

        sla.addElemento(10);
        sla.addElemento(20);
        sla.addElemento(30);
        sla.mostrar();
        sla.revomeInicio();
        sla.mostrar();        
     


    }

    public void mostrar(){

        Bloco atual = this.inicio;

        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.prox;
        }
    }

    public void addElemento(int valor){

        Bloco novo = new Bloco();
        novo.valor = valor;
        novo.prox = null;

        if(this.inicio == null){
            this.inicio = novo;
        }else{
            Bloco atual = this.inicio;
            while(atual.prox != null){
                atual = atual.prox;
            }
            atual.prox = novo;
        }
       
    }

    public void revomeInicio(){

      Bloco aux = this.inicio;

      if(aux != null){
        aux = aux.prox;
      }

    }
    
}
