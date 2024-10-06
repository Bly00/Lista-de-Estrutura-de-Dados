public class Lista {

    Bloco inicio;

    public static void main(String[] args) {
        
        Lista lista = new Lista();

        lista.addElemento(10, false);
        lista.addElemento(20, false);
        lista.addElemento(50, false);
        lista.addElemento(60, false);

        lista.addElemento(900, 2);
        lista.addElemento(600, 7);
        lista.addElemento(100, 0);
        lista.addElemento(500, 3);
        
        lista.mostraLista();

    }

    public Bloco addElemento(int valor,boolean posicaoIncio) {

        Bloco novo = null;

        if(posicaoIncio == true) {

            novo = this.addElementoInicio(valor);

        } else {

            novo = this.addElementoFim(valor);
        }

        return novo;
    }


    public void addElemento(int novoValor, int pos) {
       
         if(pos >= tamanho() || isVazia()){
            this.addElementoFim(novoValor);
         }else{

            if(pos  < 1){
               Bloco novo = new Bloco();
               novo.valor = novoValor;
               novo.prox = this.inicio.prox;
               this.inicio.prox = novo;
            }else{

                Bloco anterior = localizarBloco(pos + 1);
                Bloco novo = new Bloco();
                novo.valor = novoValor;

                Bloco aux = anterior.prox;
                anterior.prox = novo;
                novo.prox = aux;

            }
            

         }
         
    }
    
      
    

      
    public Bloco removerElementoFim() {

        Bloco result = null;

        if(this.isVazia()) {
            return result;
        }

        if(this.tamanho() == 1) {
            //this.inicio = null;
            result = this.removerElementoInicio();
        } else {

            Bloco target = this.localizarBloco(this.tamanho()-1);
    
            result = target.prox;
            target.prox = null;
        }

        return result;
    }

    public Bloco removerElementoInicio() {

        Bloco result = this.inicio;
        if(!this.isVazia()) {

            this.inicio = this.inicio.prox;
        }

        return result;
    }

    public boolean isVazia() {
        return this.inicio == null;
    }

    private Bloco addElementoInicio(int valor) {

        if(!this.isVazia()){
            System.out.println("Lista vazia");
            return null;
        }

        Bloco novo = new Bloco();
        novo.valor = valor;
        
        novo.prox = this.inicio;
        this.inicio = novo;
              
        return novo;
    }

    private Bloco addElementoFim(int valor) {

        Bloco novo = null;

        Bloco fim = this.localizarBloco(this.tamanho());

        if(fim == null) {

            novo = this.addElementoInicio(valor);
        } else {

            novo = new Bloco();
            novo.pos = this.tamanho();
            novo.valor = valor;
            novo.usado = true;
            
            fim.usado = true;
            fim.prox = novo; 
        }

        return novo;
    }

    public Bloco localizarBloco(int pos) {

        Bloco aux = this.inicio;
        int cont = 0;

        while(aux!= null && cont < pos -1) {

            cont++;
            aux = aux.prox;
        }

        return aux;
    }

    public int tamanho() {

        Bloco aux = this.inicio;
        int cont =0;

        while(aux != null) {

            cont++;
            aux = aux.prox;
        }

        return cont;
    } 

    public void mostraLista(){

        Bloco atual = inicio;

        System.out.println("Lista: ");

        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.prox;
        }

    }

    public void inverter(){

        if(this.isVazia()){
            System.out.println("Lista vaiza");
            return;
        }

    
        Lista listaInvertida = new Lista();
        Bloco aux = this.inicio;
        
        for(int z = this.tamanho(); z > 0; z--){

            listaInvertida.addElementoInicio(aux.valor);
            aux = aux.prox;

        }

        for(int i = this.tamanho(); i > 0;  i--){
       this.removerElementoFim();
    }


        aux = listaInvertida.inicio;
        while(aux != null){
            this.addElementoFim(aux.valor);
            aux = aux.prox;
        }

    }
    
}