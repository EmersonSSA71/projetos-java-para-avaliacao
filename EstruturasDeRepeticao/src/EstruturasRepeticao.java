import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class EstruturasRepeticao {
    public static void main(String[] args) {
        PassoUm();
    }

    public static void PassoUm() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Olá Usuário!\nDigite APENAS seu primeiro nome (obs: Se você digitar seu sobrenome, o sistema irá ignora-lo):");
        String NomeUsuario = sc.next();
        sc.nextLine();

        long NumeroEscolhido;

        do {
                System.out.println("Digite um numero de 1 a 20:");
                NumeroEscolhido = sc.nextLong();

            if (NumeroEscolhido > 0 && NumeroEscolhido < 21) {
                System.out.println("\nORDEM CRESCENTE DE ZERO ATÉ SEU NÚMERO:\n");
                for (long n1 = 0; n1 <= NumeroEscolhido; n1++) {
                    System.out.println(n1);
                }

                System.out.println("\nORDEM DECRESCENTE DO SEU NÚMERO ATÉ ZERO:\n");
                for (long n1 = NumeroEscolhido; n1 >= 0; n1--) {
                    System.out.println(n1);
                }
            } else if (NumeroEscolhido <=0 || NumeroEscolhido >=21) {
                NumeroEscolhido = 0;
                System.out.println("\n<Número inválido!!>\n");
                continue;
            }
        } while (NumeroEscolhido == 0);

        if (NomeUsuario.length() > 6) {
            System.out.println("\n" +NomeUsuario+ ", seu nome tem mais que 6 letras.\nSeu nome será exibido a quantidade de letras:\n");
            for (int n2 = 1; n2 < NomeUsuario.length(); n2++) {
                System.out.println(n2+" "+NomeUsuario);
            }

        } else if (NomeUsuario.length() <=6)
          {
            System.out.println("\n" +NomeUsuario+ ", seu nome tem menos que 6 letras.\nSeu nome será exibido apenas 1 vez:\n");
            System.out.println("1 "+NomeUsuario.toUpperCase());
          }

        System.out.println("\nSr(a), " +NomeUsuario+ ". Obrigado por usar nosso programa. Até logo! ;)");

        sc.close();





















    }
}
