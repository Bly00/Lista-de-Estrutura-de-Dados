public class FilaPrioridade {

    Bloco inicio;

    public static void main(String[] args) {
        
        FilaPrioridade filaPrioridade = new FilaPrioridade();

        filaPrioridade.addElemento(0, 10);
        filaPrioridade.addElemento(10, 5);
        filaPrioridade.addElemento(56, 3);
        filaPrioridade.addElemento(40, 9);

        filaPrioridade.mostraFila();

    }

    
    public void addElemento(int valor, int prioridade) {
        Bloco novo = new Bloco();
        novo.valor = valor;
        novo.prioridade = prioridade;
        
        if (this.inicio == null) {
           
            this.inicio = novo;
        } else {
           
            Bloco atual = this.inicio;
            Bloco anterior = null;
            
            while (atual != null && atual.prioridade >= prioridade) {
                anterior = atual;
                atual = atual.prox;
            }
            
            if (anterior == null) {
                
                novo.prox = this.inicio;
                this.inicio = novo;
            } else {
               
                anterior.prox = novo;
                novo.prox = atual;
            }
        }
    }

    public Bloco removerElemento() {
        if (this.inicio == null) {
            System.out.println("vazia");
            return null;
        }

        Bloco removido = this.inicio;
        this.inicio = this.inicio.prox; 
        return removido;
    }

    public void mostraFila() {
        if (this.inicio == null) {
            System.out.println("vazia");
            return;
        }

        Bloco atual = this.inicio;
        System.out.println("Fila de Prioridade:");
        while (atual != null) {
            System.out.println(atual.valor + " - Prioridade: " + atual.prioridade);
            atual = atual.prox;
        }
    }
    
    public int tamanho() {
        Bloco aux = this.inicio;
        int cont = 0;

        while (aux != null) {
            cont++;
            aux = aux.prox;
        }

        return cont;
    }
}
