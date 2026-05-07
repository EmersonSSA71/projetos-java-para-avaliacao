import java.util.Scanner;

public class HelloWorld {

   public static void main(String[] args) {
    Scanner scanner =  new Scanner(System.in);
/// Area de boas vindas ///
       System.out.println("Olá, usuário(a)!" + System.lineSeparator() + "Vamos cadastrar você agora." + System.lineSeparator() + "Aperte 'Enter' para continuar");

scanner.nextLine();
/// NOME ///

       System.out.println("Digite seu nome completo:");
String NomeUsuario = scanner.nextLine();

/// CPF ///

       System.out.println("Digite seu CPF sem pontos:");
long CpfUsuario = scanner.nextLong();

/// IDADE ///

       System.out.println("Agora digite sua Idade:");
byte IdadeUsuario = scanner.nextByte();

/// ESTADO CIVIL ///

       System.out.println("Estamos quase lá... Digite seu estado civil:");
       scanner.nextLine();
       String EstadoCivilUsuario = scanner.nextLine();

/// PESO ///

       System.out.println("Digite seu Peso:");
float PesoUsuario = scanner.nextFloat();

/// ALTURA ///

       System.out.println("Por fim... Digite sua Altura");
       float AlturaUsuario = scanner.nextFloat();

/// RESUMO ///
               System.out.println("RESUMO DO SEU CADASTRO:" + System.lineSeparator() +"| Nome: " + NomeUsuario + System.lineSeparator() + "| CPF: " + CpfUsuario + System.lineSeparator() + "| Idade: " + IdadeUsuario + System.lineSeparator() + "| Peso: " + PesoUsuario + System.lineSeparator() + "| Estado Civil: " + EstadoCivilUsuario);

          scanner.close();

    }
}
