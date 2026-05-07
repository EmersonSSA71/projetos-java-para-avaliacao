package ComparacaoNumeroMaiorOuMenor;

import java.util.Scanner;

public class comparacaodenumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número");
        int numero1 = scanner.nextInt();

        System.out.println("Agora digite o segundo número");
        int numero2 = scanner.nextInt();

        if (numero1 == numero2) {
            System.out.println("numeros iguais");
        } else if (numero1 > numero2) {
            System.out.println("O número maior é:" + numero1);
        } else {
            System.out.println("Numero maior é:" + numero2);
        }
    }
}
