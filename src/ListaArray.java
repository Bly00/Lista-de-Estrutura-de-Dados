public class ListaArray {

    //lista com array

    int maximo = 0;
    int[] inicio = new int[maximo];


    public static void main(String[] args) {

        ListaArray listaArray = new ListaArray();

        //10
        //20
        //25
        //30
        //35
        //40


        listaArray.addElementoFim(10);
        listaArray.addElementoFim(20);
        listaArray.addElementoFim(30);
        listaArray.addElementoFim(40);
        listaArray.addElemento(25, 2);
        listaArray.addElemento(35, 4);
        //listaArray.addElemento(15,1);
        //listaArray.addElemento(50,8);
        //listaArray.addElemento(45,7);

    //addElemento posiçao pewcisa ser consertado

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

        int i = 0;

        for(i = novoInicio.length-1; i > (maximo - 1) - pos; i--){

            novoInicio[i] = novoInicio[i-1];
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

    public void mostrarListaArray(){

        for(int i = 0; i < inicio.length; i++){
            System.out.println(inicio[i]);
        }

    }


    
}
