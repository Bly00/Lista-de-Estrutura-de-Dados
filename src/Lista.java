public class Lista {

    Bloco inicio;

    public Bloco addElemento(int valor,boolean posicaoIncio) {

        Bloco novo = null;

        if(posicaoIncio == true) {

            novo = this.addElementoInicio(valor);

        } else {

            novo = this.addElementoFim(valor);
        }

        return novo;
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
            novo.valor = valor;
    
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