import Funcionario.Funcionario;
import RegistroPonto.RegistroPonto;
import Service.PortalRHService;
import TipoFuncionario.TipoFuncionario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static PortalRHService service = new PortalRHService();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  BEM-VINDO AO PORTAL DE RECURSOS HUMANOS");
        System.out.println("=========================================");

        boolean executando = true;

        while (executando) {
            exibirMenuPrincipal();
            // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Capturar InputMismatchException caso o usuário digite texto no lugar de opção numéricas
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuCriarFuncionario();
                    break;
                case 2:
                    menuRegistrarHoras();
                    break;
                case 3:
                    menuListarFuncionarios();
                    break;
                case 4:
                    menuBuscarFuncionario();
                    break;
                case 5:
                    menuRemoverFuncionario();
                    break;
                case 6:
                    System.out.println("Saindo do portal... Até logo!");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Criar Funcionário");
        System.out.println("2. Registrar Horas");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Buscar Funcionário");
        System.out.println("5. Remover Funcionário");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuCriarFuncionario() {
        System.out.println("\n--- CRIAR FUNCIONÁRIO ---");
        System.out.println("1. Gerente");
        System.out.println("2. Coordenador");
        System.out.println("3. Analista");
        System.out.println("4. Assistente");
        System.out.println("5. Estagiário");
        System.out.println("6. Cancelar");
        System.out.print("Escolha o cargo: ");

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Capturar exceção de entrada de dados não numéricos
        int opcaoCargo = scanner.nextInt();
        scanner.nextLine();

        if (opcaoCargo == 6) {
            System.out.println("Operação cancelada.");
            return;
        }

        TipoFuncionario tipo;
        switch (opcaoCargo) {
            case 1: tipo = TipoFuncionario.GERENTE; break;
            case 2: tipo = TipoFuncionario.COORDENADOR; break;
            case 3: tipo = TipoFuncionario.ANALISTA; break;
            case 4: tipo = TipoFuncionario.ASSISTENTE; break;
            case 5: tipo = TipoFuncionario.ESTAGIARIO; break;
            default:
                System.out.println("Opção de cargo inválida!");
                return;
        }

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        Funcionario f = service.criarFuncionario(nome, tipo);
        System.out.println("Funcionário cadastrado com sucesso! ID gerado: " + f.getId());
    }

    private static void menuRegistrarHoras() {
        System.out.println("\n--- REGISTRAR HORAS ---");
        System.out.println("O funcionário que você deseja registrar horas é Gerente ou Estagiário?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        System.out.print("Opção: ");

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Capturar InputMismatchException para entradas não numéricas
        int eGerenteOuEstagiario = scanner.nextInt();
        scanner.nextLine();

        if (eGerenteOuEstagiario == 1) {
            System.out.println("Mensagem do sistema: Os funcionários gerente e estagiário não batem ponto.");
            return;
        }

        System.out.println("\n--- Registro de horário permitido ---");
        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1. Coordenador");
        System.out.println("2. Analista");
        System.out.println("3. Assistente");
        System.out.println("4. Cancelar");
        System.out.print("Opção: ");

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Capturar InputMismatchException para entradas não numéricas
        int opcaoCargo = scanner.nextInt();
        scanner.nextLine();

        if (opcaoCargo == 4) {
            System.out.println("Operação cancelada.");
            return;
        }

        TipoFuncionario tipo;
        switch (opcaoCargo) {
            case 1: tipo = TipoFuncionario.COORDENADOR; break;
            case 2: tipo = TipoFuncionario.ANALISTA; break;
            case 3: tipo = TipoFuncionario.ASSISTENTE; break;
            default:
                System.out.println("Opção de cargo inválida!");
                return;
        }

        menuListarFuncionarios();

        System.out.print("\nDigite o ID do funcionário: ");
        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Capturar InputMismatchException
        int id = scanner.nextInt();
        scanner.nextLine();

        Funcionario f = service.buscarPorId(id);
        if (f == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        if (f.getTipo() != tipo) {
            System.out.println("Aviso: O funcionário " + f.getNome() + " pertence ao cargo " + f.getTipo().getDescricao() + " e não " + tipo.getDescricao() + ".");
            return;
        }

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Capturar DateTimeParseException se o usuário digitar datas/horas fora do formato (dd/MM/yyyy e HH:mm)
        System.out.print("Digite a data (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr, dateFormatter);

        System.out.print("Digite o horário de entrada (HH:mm): ");
        String entradaStr = scanner.nextLine();
        LocalTime entrada = LocalTime.parse(entradaStr, timeFormatter);

        System.out.print("Digite o horário de saída (HH:mm): ");
        String saidaStr = scanner.nextLine();
        LocalTime saida = LocalTime.parse(saidaStr, timeFormatter);

        boolean sucesso = service.registrarHoras(id, data, entrada, saida);
        if (sucesso) {
            System.out.println("Horas registradas com sucesso para " + f.getNome() + "!");
        }
    }

    private static void menuListarFuncionarios() {
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
        List<Funcionario> lista = service.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario f : lista) {
            System.out.println(f);
            if (f.getRegistrosPonto().isEmpty()) {
                System.out.println("  -> Sem registros de ponto.");
            } else {
                for (RegistroPonto r : f.getRegistrosPonto()) {
                    System.out.println("  -> " + r);
                }
            }
        }
    }

    private static void menuBuscarFuncionario() {
        System.out.println("\n--- BUSCAR FUNCIONÁRIO ---");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por Nome");
        System.out.println("3. Voltar ao menu");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        Funcionario f = null;
        if (opcao == 1) {
            System.out.print("Digite o ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            f = service.buscarPorId(id);
        } else if (opcao == 2) {
            System.out.print("Digite o Nome: ");
            String nome = scanner.nextLine();
            f = service.buscarPorNome(nome);
        } else {
            return;
        }

        if (f != null) {
            System.out.println("\nFuncionário Encontrado:");
            System.out.println(f);
            System.out.println("Registros de Ponto:");
            for (RegistroPonto r : f.getRegistrosPonto()) {
                System.out.println("  " + r);
            }
        } else {
            System.out.println("Exibe mensagem: Funcionário não encontrado.");
        }
    }

    private static void menuRemoverFuncionario() {
        System.out.println("\n--- REMOVER FUNCIONÁRIO ---");
        System.out.println("Filtrar para remoção por cargo:");
        System.out.println("1. Gerente");
        System.out.println("2. Coordenador");
        System.out.println("3. Analista");
        System.out.println("4. Assistente");
        System.out.println("5. Estagiário");
        System.out.println("6. Voltar ao menu");
        System.out.print("Opção: ");

        int opcaoCargo = scanner.nextInt();
        scanner.nextLine();

        if (opcaoCargo == 6) return;

        TipoTipoFuncionarioSelecao(opcaoCargo);
    }

    private static void TipoTipoFuncionarioSelecao(int opcaoCargo) {
        TipoFuncionario tipo = null;
        switch (opcaoCargo) {
            case 1: tipo = TipoFuncionario.GERENTE; break;
            case 2: tipo = TipoFuncionario.COORDENADOR; break;
            case 3: tipo = TipoFuncionario.ANALISTA; break;
            case 4: tipo = TipoFuncionario.ASSISTENTE; break;
            case 5: tipo = TipoFuncionario.ESTAGIARIO; break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        List<Funcionario> lista = service.listarPorTipo(tipo);
        System.out.println("\nFuncionários do tipo " + tipo.getDescricao() + ":");
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado nesse cargo.");
            return;
        }

        for (Funcionario f : lista) {
            System.out.println(f);
        }

        System.out.print("\nDigite o ID do funcionário que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tem certeza que deseja remover? (1- Sim / 2- Não): ");
        int confirmacao = scanner.nextInt();
        scanner.nextLine();

        if (confirmacao == 1) {
            boolean removido = service.removerFuncionario(id);
            if (removido) {
                System.out.println("Funcionário removido com sucesso!");
            } else {
                System.out.println("Exibe mensagem: Funcionário não encontrado.");
            }
        } else {
            System.out.println("Operação de remoção cancelada.");
        }
    }
}