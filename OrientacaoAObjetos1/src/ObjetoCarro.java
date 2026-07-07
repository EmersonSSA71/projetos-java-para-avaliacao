import com.orientacaoaobjetos.entity.Carro;
import java.util.Scanner;

public class ObjetoCarro {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro[] ListaDeCarros;
        int QuantidadeDesCarros;
        Carro carro;
        double PrecoTotalDosCarros = 0;

        do {
            System.out.println("Digite quantos carros você precisa (máx: 50):");
            QuantidadeDesCarros = scanner.nextInt();
            if (QuantidadeDesCarros == 0) {
                System.out.println("Inválido! Digite um valor maior que 0");
            }else if (QuantidadeDesCarros > 50) {
                System.out.println("Quantidade inválida!");
            }
        } while (QuantidadeDesCarros <= 0 || QuantidadeDesCarros > 50);

        ListaDeCarros = new Carro[QuantidadeDesCarros];


        for (int i = 0; i < QuantidadeDesCarros; i++) {

            carro = new Carro();

            System.out.println("Digite a quantidade do carro " + i + ":");
            carro.QuantidadeDeCarrosCriados = scanner.nextInt();
            System.out.println("Digite o nome do carro " + i + ":");
            carro.NomeDoCarro = scanner.next();
            System.out.println("Digite o preço do carro " + i + ":");
            carro.PrecoDoCarro = scanner.nextInt();

            ListaDeCarros[i] = carro;
        }

        for (int i = 0; i < QuantidadeDesCarros; i++) {
            PrecoTotalDosCarros = ListaDeCarros[i].PrecoDoCarro + PrecoTotalDosCarros;
            System.out.println(ListaDeCarros[i]);
        }

        System.out.println("Esse é o valor total dos seus carros: R$" + PrecoTotalDosCarros);

        scanner.close();
    }
}








