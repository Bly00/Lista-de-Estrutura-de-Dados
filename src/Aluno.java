import java.util.Random;

public class Aluno {

    public String nome;
    private int matricula;
    public Lista notas; 

    public Aluno(String nome) {
        Random ram = new Random();
        this.nome = nome;
        this.matricula = ram.nextInt(1000); 
        this.notas = new Lista();
    }

    public int getMatricula() {
        return matricula;
    }

}
