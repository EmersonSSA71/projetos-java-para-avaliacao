import com.orientacaoaobjetos.entity.Aluno;
import java.util.Scanner;

public class InterfaceParaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de Alunos que deseja criar: ");
        int quantidadeDeAlunosDoUsuario = scanner.nextInt();
        Aluno[] aluno = new Aluno[quantidadeDeAlunosDoUsuario];

        for (int i = 0; i < quantidadeDeAlunosDoUsuario; i++) {
            System.out.println("Digite o nome do aluno " + (i + 1) + ":");
            String nomeT = scanner.next();
            System.out.println("Digite a idade do aluno " + (i + 1) + ":");
            int idadeT = scanner.nextInt();
            aluno[i] = new Aluno(nomeT, idadeT);

            for (int j = 0; j < 4; j++) {
                double notaDoAluno;
                do {
                    System.out.print("Digite a nota do " + (j + 1) + " trimestre do " + (i + 1) + " aluno: ");
                    notaDoAluno = scanner.nextDouble();
                    if (notaDoAluno >= 0 && notaDoAluno <=10) {
                        aluno[i].setNota(j, notaDoAluno);
                        break;
                    } else {
                        System.out.println("Você digitou uma nota inválida.\nDigite uma nota de 0 a 10.\n");
                    }
                } while (true);
            }
        }
        System.out.println("\nLISTA DAS NOTAS DE CADA ALUNO:");
        for (int i = 0; i < aluno.length; i++) {
            aluno[i].exibirDados();
            System.out.println();
            aluno[i].mediaDasNotas();
        }
        scanner.close();
    }
}