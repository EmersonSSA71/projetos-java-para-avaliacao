package Service;

import Funcionario.Funcionario;
import RegistroPonto.RegistroPonto;
import TipoFuncionario.TipoFuncionario;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PortalRHService {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private int proximoId = 1;

    public Funcionario criarFuncionario(String nome, TipoFuncionario tipo) {
        Funcionario novoFuncionario = new Funcionario(proximoId++, nome, tipo);
        funcionarios.add(novoFuncionario);
        return novoFuncionario;
    }

    public List<Funcionario> listarTodos() {
        return funcionarios;
    }

    public List<Funcionario> listarPorTipo(TipoFuncionario tipo) {
        List<Funcionario> filtrados = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.getTipo() == tipo) {
                filtrados.add(f);
            }
        }
        return filtrados;
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public Funcionario buscarPorNome(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public boolean removerFuncionario(int id) {
        Funcionario f = buscarPorId(id);
        if (f != null) {
            funcionarios.remove(f);
            return true;
        }
        return false;
    }

    public boolean registrarHoras(int funcionarioId, LocalDate data, LocalTime entrada, LocalTime saida) {
        Funcionario f = buscarPorId(funcionarioId);

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Lançar FuncionarioNaoEncontradoException caso f seja null
        if (f == null) {
            System.out.println("Erro: Funcionário não encontrado.");
            return false;
        }

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Lançar CargoInvalidoParaPontoException se !f.getTipo().isBatePonto()
        if (!f.getTipo().isBatePonto()) {
            System.out.println("Erro: Os funcionários gerente e estagiário não batem ponto.");
            return false;
        }

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Lançar HorarioInvalidoException se entrada < 06:00
        if (entrada.isBefore(LocalTime.of(6, 0))) {
            System.out.println("Erro: O horário de entrada não pode ser anterior às 06:00h.");
            return false;
        }

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Lançar HorarioInvalidoException se saída > 22:00
        if (saida.isAfter(LocalTime.of(22, 0))) {
            System.out.println("Erro: O horário de saída não pode ser posterior às 22:00h.");
            return false;
        }

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Lançar HorarioInvalidoException se saída <= entrada
        if (!saida.isAfter(entrada)) {
            System.out.println("Erro: O horário de saída deve ser posterior ao horário de entrada.");
            return false;
        }

        // Cálculo de horas (descontando 1 hora padrão de almoço)
        long minutosTotais = Duration.between(entrada, saida).toMinutes();
        double horasTotais = minutosTotais / 60.0;
        double horasTrabalhadas = horasTotais - 1.0;

        // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Lançar HorarioInvalidoException se a permanência for menor que 1h
        if (horasTrabalhadas <= 0) {
            System.out.println("Erro: O tempo total deve ser superior a 1 hora (tempo do almoço).");
            return false;
        }

        // Cálculo de horas extras (considerando jornada padrão de 8 horas)
        double horasExtras = horasTrabalhadas - 8.0;
        if (horasExtras > f.getTipo().getMaxHorasExtras()) {
            // [LOCAL DE TRATAMENTO DE ERRO AQUI]: Lançar LimiteHorasExtrasExcedidoException
            System.out.println("Erro: Limite de horas extras excedido para o cargo " + f.getTipo().getDescricao()
                    + ". Máximo permitido: " + f.getTipo().getMaxHorasExtras() + "h extras.");
            return false;
        }

        RegistroPonto registro = new RegistroPonto(data, entrada, saida, horasTrabalhadas);
        f.adicionarRegistro(registro);
        return true;
    }
}
