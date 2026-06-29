import java.util.Scanner;

public class matriz {
    public static void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int[][] Matriz = new int[3][3];


        for (int i = 0; i < Matriz.length; i++) {
            for (int o = 0; o < Matriz.length; o++) {
                System.out.print("Digite um numero para matriz na posição [" + i + "] e [" + o + "]: ");
                Matriz[i][o] = scanner.nextInt();
            }

        }
        System.out.print("\n");
        System.out.println("Essa é a sua matriz:");

        for (int i = 0; i < Matriz.length; i++) {
            for (int o = 0; o < Matriz[i].length; o++) {

                System.out.print(Matriz[i][o] + " ");

            }

            System.out.println();
        }







        scanner.close();
    }































}
