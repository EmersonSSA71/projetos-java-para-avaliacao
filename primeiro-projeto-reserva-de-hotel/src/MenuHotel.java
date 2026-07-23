import com.cadastroreservahotel.entity.Reserva;
import java.util.Scanner;

public class MenuHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reserva[] reserva = new Reserva[10];
        int opcaoDoHospede;
        do {
            System.out.println("\nMENU PRINCIPAL\n");
            System.out.println("1. Nova reserva (máx.: 10)\n2. Listar reserva\n3. Buscar por nome do hospede\n4. Ordenar reservas por dias (ordem decrescente)\n5. Sair");
            System.out.print("> ");
            opcaoDoHospede = ValidarNumeroInteiro(scanner);
            switch (opcaoDoHospede) {
                case 1 -> {
                    CadastrarNovaReserva(scanner, reserva);
                    System.out.print("Reservas restantes: " + ReservasDisponiveis(reserva) + "\n");
                }
                case 2 -> ListarReservas(reserva);
                case 3 -> BuscarReservasPorNome(scanner, reserva);
                case 4 -> OrdenarReservasDecrescente(reserva);
                case 5 -> Sair();
                default -> {
                    System.out.println("<Erro: você não digitou uma opção válida>");
                    opcaoDoHospede = 1;
                }
            }
        }while (opcaoDoHospede != 5);
        scanner.close();
    }
    public static void CadastrarNovaReserva(Scanner scanner, Reserva[] reserva){
        //LIMPA SCANNER DO MENU
        scanner.nextLine();

        //PERCORRE VETOR DO OBJETO
        for (int i = 0; i < reserva.length; i++) {

            //VERIFICA SE O VETOR ESTÁ VAZIO
            if (reserva[i] == null) {

                //VARIAVEL PARA CRIACAO DO OBJETO <String nome, String quarto, int diasDiaria, int valorDiaria>
                String nome;
                int escolhaQuartoInt;
                String quarto = "";
                int diasDiaria;
                double valorDiaria = 0;
                int confirmarReserva;

                //COLETA NOME DO HOSPEDE
                System.out.print("Digite seu nome: ");
                nome = scanner.nextLine();

                //VALIDAÇÃO DE OPÇÃO DO QUARTO DO HOSPEDE
                while (true) {
                    System.out.print("\nDigite a opção do quarto:\n1. Standard R$ 89,90 diaria\n2. Luxo R$ 109,90 diaria\n3. Presidencial R$ 129,90 diaria\n> ");
                    escolhaQuartoInt = ValidarNumeroInteiro(scanner);
                    if (escolhaQuartoInt == 1 || escolhaQuartoInt == 2 || escolhaQuartoInt == 3){
                        break;
                    }
                    System.out.println("<Erro: Digite uma opção da lista>");
                }

                //ATRIBUI/COLETA NOME QUARTO E VALOR DIARIA
                switch (escolhaQuartoInt) {
                    case 1: quarto = "Standard";
                            valorDiaria = 89.90;
                        break;
                    case 2: quarto = "Luxo";
                            valorDiaria = 109.90;
                        break;
                    case 3: quarto = "Presidencial";
                            valorDiaria = 129.90;
                        break;
                }

                //COLETA DIARIAS DO HOSPEDE
                System.out.print("\nDigite quantos dias pretende ficar: ");
                diasDiaria = ValidarNumeroInteiro(scanner);

                //RESUMO DA RESERVA
                System.out.println("\n---------RESUMO---------");
                System.out.println("Nome: " + nome + "\nQuarto: " + quarto + "\nEstadias: " + diasDiaria + "\nValor diaria: R$ " + valorDiaria + "\nTotal: R$ " + valorDiaria * diasDiaria);

                //VALIDAÇÃO OPÇÃO CONFIRMAR RESERVA
                while (true) {
                    System.out.print("\nConfirmar reserva?\n1. Sim\n2. Não\n> ");
                    confirmarReserva = ValidarNumeroInteiro(scanner);
                    if (confirmarReserva == 1 || confirmarReserva == 2) {
                        break;
                    }
                    System.out.println("<Erro: Digite uma opção válida>");
                }

                //CONFIMARCAO OU NÃO DA RESERVA
                switch (confirmarReserva){
                    case 1:
                        reserva[i] = new Reserva(nome, quarto, diasDiaria, valorDiaria);
                        if (reserva[i].setNomeHospede(nome) && reserva[i].setNumeroDiasDiaria(diasDiaria)) {
                            System.out.println("Reserva criada com sucesso!\n");
                            return;
                        } else
                            reserva[i] = null;
                            System.out.println("<Erro ao criar cadastro: nome inválido ou diaria menor que 1>\n");
                        return;

                    case 2:
                        System.out.println("Reserva cancelada!\n");
                        return;
                }
            }

            //CASO O VETOR DO OBJETO ESTIVER TOTALMENTE CHEIO
        } System.out.println("\n<Erro: incapaz de criar nova reserva. O hotel está cheio>");
    }
    public static void ListarReservas(Reserva[] reserva){
        boolean reservaCadastrada = false;
        System.out.println("-----------LISTA DE RESERVA------------");
        for (int i = 0; i < reserva.length; i++) {
            if (reserva[i] != null) {
                System.out.println("|");
                System.out.println("Hospede " + (i + 1) + ": " + reserva[i].toString() + " | " + "Total: R$ " + reserva[i].CalcularValorTotal());
                reservaCadastrada = true;
            }
        }
        if (!reservaCadastrada) {
            System.out.println("Nenhuma reserva cadastrada ainda");
        }
    }
    public static void BuscarReservasPorNome(Scanner scanner, Reserva[] reserva){
        scanner.nextLine();
        System.out.print("Digite o nome do hospede cadastrado: ");
        String nomePesquisaHospede = scanner.nextLine().trim();
        boolean encontrar = false;
        for (int i = 0; i < reserva.length; i++) {
            if (reserva[i] != null && reserva[i].getNomeHospede() != null) {
                if (reserva[i].getNomeHospede().toLowerCase().contains(nomePesquisaHospede.toLowerCase())) {
                    if (!encontrar) {
                        System.out.println("\nHospede(s) encontrado(s)!");
                        System.out.println("-------------------------------------------");
                        encontrar = true;
                    }
                    System.out.println("|\n" + reserva[i] + " | " + "Total: R$ " + reserva[i].CalcularValorTotal());
                }
            }
        }
        if (!encontrar) {
            System.out.print("Hospede não encontrado!\n");
        }
    }
    public static void OrdenarReservasDecrescente(Reserva[] reserva){
        for (int i = 0; i < reserva.length - 1; i++) {
            for (int j = 0; j < reserva.length - 1 - i; j++) {
                if (reserva[j] == null && reserva[j + 1] != null) {
                    Reserva aux = reserva[j];
                    reserva[j] = reserva[j + 1];
                    reserva[j + 1] = aux;
                } else if (reserva[j] != null && reserva[j + 1] != null) {
                    if (reserva[j].getNumeroDiasDiaria() < reserva[j + 1].getNumeroDiasDiaria()) {
                        Reserva aux = reserva[j];
                        reserva[j] = reserva[j + 1];
                        reserva[j + 1] = aux;
                    }
                }
            }
        }
        System.out.println("Suas reservas foram ordenadas. Liste novamente"); // TESTANDO!//
    }
    public static void Sair() {
        System.out.println("Obrigado pela preferência! ;)");
    }
    public static int ValidarNumeroInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("<Erro: Digite apenas números inteiros>\n>");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static int ReservasDisponiveis(Reserva[] reserva) {
        int reservasDisponiveis = 0;

        for (int i = 0; i < reserva.length; i++) {
            if (reserva[i] == null) {
                reservasDisponiveis++;
            }
        }
        return reservasDisponiveis;
    }
}
