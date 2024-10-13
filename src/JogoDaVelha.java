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
            }

        }else{

            if(posJogada.valor == 0){
                posJogada.valor = 2;
            }else{
                System.out.println("Essa posicao ja esta oculpada");
                jogador = !jogador;
            }

        }

        mostrarJogo(jogo);
        verificarJogo(jogo);//fazer
        jogador = !jogador;

    }

   
    

    }


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

        return 0; //fazer

    }
    
}
