import java.util.Random;

public class Turma {

    Lista alunos = new Lista();
    Disciplina disciplina;
    int codigo;

    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno("Gabriel");
        Aluno aluno2 = new Aluno("Ana Kelry");
        Aluno aluno3 = new Aluno("Alerrandro");

        Disciplina disciplina1 = new Disciplina("Matematica");
        Turma turma1 = new Turma(disciplina1);

        turma1.addAluno(aluno1);
        turma1.addAluno(aluno2);
        turma1.addAluno(aluno3);

        turma1.mostrarListaAluno();
        
        turma1.removerAluno("Alerrandro");
        
        turma1.mostrarListaAluno();
    }

    public Turma(Disciplina disciplina) {
        Random ram = new Random(); 
        this.disciplina = disciplina;
        this.codigo = ram.nextInt(1000);
    }

    public void addAluno(Aluno novoAluno) {
        Bloco novoBloco = new Bloco();
        novoBloco.aluno = novoAluno; 
    
       
        if (this.alunos.isVazia()) {
            this.alunos.inicio = novoBloco;
        } else {
            
            Bloco atual = this.alunos.inicio;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            
            atual.prox = novoBloco;
            novoBloco.ante = atual;
        }
    }

    public void removerAluno(String nome) {
        if (this.alunos.isVazia()) {
            System.out.println("A lista de alunos está vazia.");
            return;
        }

        Bloco atual = this.alunos.inicio;
        Bloco anterior = null;

        while (atual != null) {
            if (atual.aluno.nome.equals(nome)) {
                
                if (anterior == null) {
                    this.alunos.inicio = atual.prox;
                } else {
                    anterior.prox = atual.prox;
                }
                System.out.println("Aluno " + nome + " removido.");
                return;
            }
            anterior = atual;
            atual = atual.prox;
        }

        System.out.println("Aluno " + nome + " não encontrado.");
    }


    public Aluno localizarAluno(String nome) {
        Bloco atual = this.alunos.inicio;

        while (atual != null) {
            if (atual.aluno.nome.equals(nome)) {
                return atual.aluno;
            }
            atual = atual.prox;
        }

        System.out.println("Aluno " + nome + " não encontrado.");
        return null;
    }
    
    public void mostrarListaAluno() {
        Bloco atual = this.alunos.inicio;
        int i = 1;
    
        while (atual != null) {
            Aluno aluno = atual.aluno; 
            System.out.println("Aluno " + i);
            System.out.println("Nome: " + aluno.nome);
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println();
            atual = atual.prox;
            i++;
        }
    }
    
}
