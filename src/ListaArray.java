
public class ListaArray {

    //lista com array

    int maximo = 0;
    int[] inicio = new int[maximo];


    public static void main(String[] args) {

        ListaArray listaArray = new ListaArray();

  
        //60 10 20 34 58 30 40 10 80 4 50 70 80
        //60 10 20 30 40 4 80
       
        

        listaArray.addElementoFim(10);
        listaArray.addElementoFim(20);
        listaArray.addElementoFim(30);
        listaArray.addElementoFim(40);
        listaArray.addElemento(80,5);
        listaArray.addElemento(34,2);
        listaArray.addElemento(4,7);
        listaArray.addElementoFim(50);
        listaArray.addElementoInicio(60);
        listaArray.addElementoFim(70);
        listaArray.addElementoFim(80);
        listaArray.addElemento(58,4);
        listaArray.addElemento(10,7);

        listaArray.removerElemento(3);
        listaArray.removerElemento(9);
        listaArray.removerElemento(6);
        listaArray.removerElemento(6);
        listaArray.removerElemento(3);
        listaArray.removerElemento(6);

     

   

        listaArray.mostrarListaArray();

    }


    public void addElemento(int valor, int pos) {
        if (pos > maximo - 1) {
            addElementoFim(valor);
            return;
        }
        if(pos == 0){
            addElementoInicio(valor);
            return;
        }


        maximo++;
        int[] novoInicio = new int[maximo];

        for (int i = 0; i < inicio.length; i++) {

                novoInicio[i] = inicio[i];

        }

        int i;

        for(i = novoInicio.length - 1; i > pos; i--){

           novoInicio[i] = novoInicio[i - 1];

        }

        novoInicio[i] = valor;
        this.inicio = novoInicio;

    }

    public void addElementoInicio(int valor){

        if(maximo == 0){
            maximo++;
            inicio = new int[maximo];
            inicio[0] = valor;
            return;
        }

        maximo++;
        int[] novoInicio = new int[maximo];
        novoInicio[0] = valor;


        for(int i = 1 ,z = 0; z < inicio.length; i++, z++){

            novoInicio[i] = inicio[z];

        }

        this.inicio = novoInicio;

    }

    public void addElementoFim(int novoValor){

        if(maximo == 0){
            maximo++;
            inicio = new int[maximo];
            inicio[0] = novoValor;
            return;
        }


        maximo++;
        int[] novoInicio = new int[maximo];
        for(int i = 0; i < inicio.length; i++){
            novoInicio[i] = inicio[i];
        }

        novoInicio[maximo - 1] = novoValor;
        this.inicio = novoInicio;

    }

    public void removerElemento(int pos){

        if(pos >= maximo - 1){
            removerElementoFim();
            return;
        }
        if(pos == 0){
            removerElementoInicio();
            return;
        }

       maximo--;
        int[] novoInicio = new int[maximo];

    
    for(int i = 0, z = 0; i <= maximo - 1; i++, z++){

        if(z == pos){
            z++;
        }

        novoInicio[i] = inicio[z];

    }

        inicio = novoInicio;

    }

    public void removerElementoFim(){

        if(maximo == 0){
            System.out.println("lista vazia");
            return;
        }

        maximo--;
        int[] novoInicio = new int[maximo];

        for(int i = 0; i < novoInicio.length; i++){

            novoInicio[i] = inicio[i];

        }

        inicio = novoInicio;

    }


    public void removerElementoInicio(){

        maximo--;
        int[] novoInicio = new int[maximo];

        for(int i = 0; i <= novoInicio.length - 1; i++){
            novoInicio[i] = inicio[i + 1];
        }

        inicio = novoInicio;

    }

    public void mostrarListaArray(){

        System.out.println("Lista de Array:");
        for(int i = 0; i < inicio.length; i++){
            System.out.println(inicio[i]);
        }

    }


    
}
