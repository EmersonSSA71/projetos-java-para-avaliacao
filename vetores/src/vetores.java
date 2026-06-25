import java.util.Scanner;

public class vetores {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Exercicio 1");
        exercicio1(scanner);
        System.out.println("Exercicio 2");
        exercicio2(scanner);
        System.out.println("\nExercicio 3");
        exercicio3(scanner);
        scanner.close();
    }

    public static void exercicio1(Scanner scanner) {
        int[] VetorDoUsuario = new int[4];
        for (int i = 0; i < VetorDoUsuario.length; i++) {
            System.out.println("Digite um numero para o vetor " + i);
            VetorDoUsuario[i] = scanner.nextInt();
        }
        for (int i = 0; i < VetorDoUsuario.length; i++) {
            for (int o = i; o < VetorDoUsuario.length; o++) {
                if (VetorDoUsuario[i] > VetorDoUsuario[o]) {

                    int aux = VetorDoUsuario[i];
                    VetorDoUsuario[i] = VetorDoUsuario[o];
                    VetorDoUsuario[o] = aux;

                }
            }
        }

        System.out.println("Seu vetor em ordem crescente:");
        for (int i = 0; i < VetorDoUsuario.length; i++) {
            System.out.println(VetorDoUsuario[i]);
        }

        scanner.nextLine();
        String PalavraDoUsuario;
        int Verificador = 0;
        char Caracter;

        do {
            System.out.println("Digite uma palavra:");
            PalavraDoUsuario = scanner.nextLine();
            if (!PalavraDoUsuario.matches("[a-zA-Z]+")) {
                System.out.println("Digite somente uma palavra sem espaços, numeros ou simbolos\n");
            }
        } while (!PalavraDoUsuario.matches("[a-zA-Z]+"));

        for (int k = 0; k < PalavraDoUsuario.length(); k++) {
            Caracter = PalavraDoUsuario.charAt(k);

            if (Caracter == 'a' || Caracter == 'e' || Caracter == 'i' || Caracter == 'o' || Caracter == 'u' ||
            Caracter == 'A' || Caracter == 'E' || Caracter == 'I' || Caracter == 'O' || Caracter == 'U') {

                Verificador++;
            }
        }
        System.out.println("Sua palavra tem " + Verificador + " vogais\n");
    }

    public static void exercicio2(Scanner scanner) {

        System.out.print("Digite a quantidade de posições para seu vetor\n");
        int QuantidadeDeVetor = scanner.nextInt();
        double[] Vetor = new double[QuantidadeDeVetor];

        for (int i = 0; i < QuantidadeDeVetor; i++) {
            System.out.println("Digite um numero para o vetor " + i);
            Vetor[i] = scanner.nextInt();
        }

        for (int i = 0; i < QuantidadeDeVetor; i++) {
            if (Vetor[i] % 2 == 0) {
                Vetor[i] = Vetor[i] * 2;
            } else if (i % 2 != 0) {
                Vetor[i] = Math.pow(Vetor[i], 2);
            }
        }

        for (int i = 0; i < QuantidadeDeVetor; i++) {
            if (Vetor[i] % 2 == 0) {
                System.out.print(Vetor[i] + " > Esse vetor é par\n");
            } else if (i % 2 != 0) {
                System.out.print(Vetor[i] + " > Esse vetor é ímpar\n");
            }
        }
        scanner.nextLine();
    }

    public static void exercicio3(Scanner scanner) {

        System.out.print("Digite um nome:\n");
        String nome = scanner.nextLine();
        String[] VetorNome = new String[nome.length()];

        for (int i = 0; i < nome.length(); i++) {
            VetorNome[i] = nome.charAt(i) + "";
        }

        for (int i = 0; i < nome.length() / 2; i++) {

            String aux = VetorNome[i];
            VetorNome[i] = VetorNome[nome.length() - 1 - i];
            VetorNome[nome.length() - 1 - i] = aux;
        }

        System.out.println("O nome que você digitou ao contrario:");

        for (int i = 0; i < nome.length(); i++) {
            System.out.println(VetorNome[i]);
        }
    }
}
