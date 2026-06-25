import java.util.Scanner;

public class LacoEControleDeFluxo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Tabuada(sc);
        Menu(sc);

        sc.close();
    }


    public static void Tabuada (Scanner sc) {

        String OpcaoEscolhida;
        String NumeroEscolhido1;
        String NumeroEscolhido2;
        String NumeroEscolhido3;
        String NumeroEscolhido4;
        int Fator;

        do {
            System.out.println("\nTABUADA SIMPLES\nDigite a opção de qual tipo de tabuada:\n1. Soma\n2. Subtração\n3. Multiplicação\n4. Divisão\n0. Pular Etapa");
            OpcaoEscolhida = sc.nextLine();

            Fator = 0;

            if (OpcaoEscolhida.equals("1")) {

                // SOMA //

                do {
                    System.out.println("Digite um numero 0 a 10 para calcular sua tabuada:");
                    NumeroEscolhido1 = sc.nextLine();

                    if (!NumeroEscolhido1.matches("[0-9]|10")) {
                        System.out.println("!Erro!");
                    }
                } while (!NumeroEscolhido1.matches("[0-9]|10"));

                int NumeroInteiro1 = Integer.parseInt(NumeroEscolhido1);

                while (Fator <= 10) {
                    System.out.println(NumeroInteiro1 + " + " + Fator + " = " + (NumeroInteiro1 + Fator));
                    Fator++;
                }

                // SUBTRACÃO //

            } else if (OpcaoEscolhida.equals("2")) {
                do {
                    System.out.println("Digite um numero 0 a 10 para calcular sua tabuada:");
                    NumeroEscolhido2 = sc.nextLine();
                    if (!NumeroEscolhido2.matches("[0-9]|10")) {
                        System.out.println("!Erro!");
                    }
                } while (!NumeroEscolhido2.matches("[0-9]|10"));

                int NumeroInteiro2 = Integer.parseInt(NumeroEscolhido2);

                while (Fator <= 10)
                    if (NumeroInteiro2 >= Fator) {
                        System.out.println(NumeroInteiro2 + " - " + Fator + " = " + Math.abs(NumeroInteiro2 - Fator));
                        Fator++;
                    } else {
                        System.out.println(NumeroInteiro2 + " - " + Fator + " = " + (NumeroInteiro2 - Fator));
                        Fator++;
                    }

                // MULTIPLICAÇÃO //

            } else if (OpcaoEscolhida.equals("3")) {
                do {
                    System.out.println("Digite um numero 0 a 10 para calcular sua tabuada:");
                    NumeroEscolhido3 = sc.nextLine();
                    if (!NumeroEscolhido3.matches("[0-9]|10")) {
                        System.out.println("!Erro!");
                    }
                } while (!NumeroEscolhido3.matches("[0-9]|10"));

                int NumeroInteiro3 = Integer.parseInt(NumeroEscolhido3);

                while (Fator <= 10) {
                    System.out.println(NumeroEscolhido3 + " x " + Fator + " = " + (NumeroInteiro3 * Fator));
                    Fator++;
                }

                // DIVISÃO //

            } else if (OpcaoEscolhida.equals("4")) {
                do {
                    System.out.println("Digite um numero entre 0 a 10 para calcular sua tabuada:");
                    NumeroEscolhido4 = sc.nextLine();
                    if (!NumeroEscolhido4.matches("[0-9]|10")) {
                        System.out.println("!Erro!");
                    }
                } while (!NumeroEscolhido4.matches("[0-9]|10"));

                double NumeroInteiro4 = Double.parseDouble(NumeroEscolhido4);

                while (Fator <= 10) {
                    if (NumeroInteiro4 == 0) {
                        System.out.println(NumeroInteiro4 + " / " + Fator + " = " + (0));
                        Fator++;
                    } else if (Fator == 0) {
                        System.out.println(NumeroInteiro4 + " / " + Fator + " = " + (0));
                        Fator++;
                    } else {
                        System.out.println(NumeroInteiro4 + " / " + Fator + " = " + (NumeroInteiro4 / Fator));
                        Fator++;
                    }
                }

                // SAÍDA //

            } else if (OpcaoEscolhida.equals("0")) {
                break;
            } else {
                System.out.println("\n!Erro!\nDigite uma opção válida!");
            }
        } while (true);
    }

        public static void Menu (Scanner sc) {

        String EscolhaDoUsuario2;
        String PalavraOuFraseDoUsuario;

            do {
                System.out.println("Escolha o que gostaria de fazer agora:\n1. Continuar\n2. Sair");
                EscolhaDoUsuario2 = sc.nextLine();

                if (EscolhaDoUsuario2.equals("1")) {
                    do {
                        System.out.println("\nDigite uma palavra ou uma frase:");
                        PalavraOuFraseDoUsuario = sc.nextLine();

                        if (!PalavraOuFraseDoUsuario.matches("[a-zA-Z ]+")) {
                            System.out.println("\n!Erro!\nDigite uma palavra ou frase válida!\n");
                        } else {
                            System.out.println("Essa foi a palavra ou frase que você digitou: > " + PalavraOuFraseDoUsuario + " <\n");
                            break;
                        }
                    } while (true);


                } else if (EscolhaDoUsuario2.equals("2")) {
                    System.out.println("\nObrigado por utilizar o nosso sistema, espero que tenha gostado.");
                    break;
                } else {
                    System.out.println("\n!Erro!\nDigite uma opção válida!\n");
                }
            } while (true);
    }
}