import java.util.Scanner;

public class JogoDaVelha {

    
    public static void main(String[] args) {

        Lista jogo = new Lista();
       
        Scanner sc = new Scanner(System.in);

        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
        jogo.addElemento(0, false);
    
        boolean jogador = false;
        //false = X = 1
        //true = 0 = 2

        int pos = 0;
        int status = 0;
        int quantJogadas = 0;

        while(true){

        System.out.println("Escolha posicao");
        pos = sc.nextInt();

        if(pos < 1 || pos > 9){
            System.out.println("Posicao invalida");
        }else{

        Bloco posJogada = jogo.localizarBloco(pos);

        
        
        if(jogador == false){

            if(posJogada.valor == 0){
                posJogada.valor = 1;
            }else{
                System.out.println("Essa posicao ja esta oculpada");
                jogador = !jogador;
                quantJogadas--;
            }

        }else{

            if(posJogada.valor == 0){
                posJogada.valor = 2;
            }else{
                System.out.println("Essa posicao ja esta oculpada");
                jogador = !jogador;
                quantJogadas--;
            }

        }

        quantJogadas++;

        mostrarJogo(jogo);

        status = verificarJogo(jogo);

        if(status != 0 || quantJogadas == 9){
            break;
        }
        jogador = !jogador;

    }

  

    }
    if(status == 0){
        System.out.println("Empate");
    }else if(status == 1){
        System.out.println("X foi o ganhador");
    }
    else if(status == 2){
        System.out.println("0 foi o ganhador");
    }

    sc.close();

    }

    public static void mostrarJogo(Lista jogo){

        Bloco atual = jogo.inicio;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.println("_");
    }
    if(atual.valor == 1){
    System.out.println("X");
    }
    if(atual.valor == 2){
    System.out.println("0");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
    
    atual = atual.prox;
    
    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
    
    atual = atual.prox;
    
    if(atual.valor == 0){
    System.out.println("_");
    }
    if(atual.valor == 1){
    System.out.println("X");
    }
    if(atual.valor == 2){
    System.out.println("0");
    }

    atual = atual.prox;

    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
        
    atual = atual.prox;
        
    if(atual.valor == 0){
    System.out.print("_/");
    }
    if(atual.valor == 1){
    System.out.print("X/");
    }
    if(atual.valor == 2){
    System.out.print("0/");
    }
        
    atual = atual.prox;
        
    if(atual.valor == 0){
    System.out.println("_");
    }
    if(atual.valor == 1){
    System.out.println("X");
    }
    if(atual.valor == 2){
    System.out.println("0");
    }
    

    }

    public static int verificarJogo(Lista jogo){

    if(jogo.localizarBloco(1).valor == 1 && (jogo.localizarBloco(2).valor == 1 && jogo.localizarBloco(3).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(4).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(6).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(7).valor == 1 && (jogo.localizarBloco(8).valor == 1 && jogo.localizarBloco(9).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(1).valor == 1 && (jogo.localizarBloco(4).valor == 1 && jogo.localizarBloco(7).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(2).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(8).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(3).valor == 1 && (jogo.localizarBloco(6).valor == 1 && jogo.localizarBloco(9).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(1).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(9).valor == 1)){
        return 1;
    }
    if(jogo.localizarBloco(3).valor == 1 && (jogo.localizarBloco(5).valor == 1 && jogo.localizarBloco(7).valor == 1)){
        return 1;
    }

        

    if(jogo.localizarBloco(1).valor == 2 && (jogo.localizarBloco(2).valor == 2 && jogo.localizarBloco(3).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(4).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(6).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(7).valor == 2 && (jogo.localizarBloco(8).valor == 2 && jogo.localizarBloco(9).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(1).valor == 2 && (jogo.localizarBloco(4).valor == 2 && jogo.localizarBloco(7).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(2).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(8).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(3).valor == 2 && (jogo.localizarBloco(6).valor == 2 && jogo.localizarBloco(9).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(1).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(9).valor == 2)){
        return 2;
    }
    if(jogo.localizarBloco(3).valor == 2 && (jogo.localizarBloco(5).valor == 2 && jogo.localizarBloco(7).valor == 2)){
        return 2;
    }
        return 0; 

    }
    
}
