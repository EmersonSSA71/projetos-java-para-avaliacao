import java.util.Scanner;

public class CadastroUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = scanner.next();
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        try {
            cadastrarUsuario(nome, idade);
        } catch (IdadeInvalidaException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.print("Processo de cadastro finalizado.");
        }
    }

    public static void cadastrarUsuario(String nome, int idade) throws IdadeInvalidaException{

        if (idade < 18) {
            throw new IdadeInvalidaException("Idade inválida! Usuario precisa ter 18 anos ou mais");
        }
        else if (idade > 18) {
            System.out.println("Usuário " + nome + ", foi cadastrado com sucesso.");
        }

    }

}