package Service;

import Exceptions.HorarioInvalidoException;
import Exceptions.LimiteDeHorasExtrasException;
import Funcionario.Funcionario;
import RegistroPonto.RegistroPonto;
import TipoFuncionario.TipoFuncionario;

import java.text.Normalizer;
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
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        String buscaNormalizada = removerAcentos(nome.trim().toLowerCase());

        for (Funcionario f : funcionarios) {
            if (f.getNome() != null) {
                String nomeCadastradoNormalizado = removerAcentos(f.getNome().toLowerCase());

                if (nomeCadastradoNormalizado.contains(buscaNormalizada)) {
                    return f;
                }
            }
        }
        return null;
    }

    private String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return textoNormalizado.replaceAll("\\p{M}", "");
    }

    public boolean removerFuncionario(int id) {
        Funcionario f = buscarPorId(id);
        if (f != null) {
            funcionarios.remove(f);
            return true;
        }
        return false;
    }

    public boolean registrarHoras(int funcionarioId, LocalDate data, LocalTime entrada, LocalTime saida){

        Funcionario f = buscarPorId(funcionarioId);

        if (entrada.isBefore(LocalTime.of(6, 0))) {
            throw new HorarioInvalidoException("Erro: O horário de entrada não pode ser anterior às 06:00h.");
        }

        if (saida.isAfter(LocalTime.of(22, 0))) {
            throw new HorarioInvalidoException("Erro: O horário de saída não pode ser posterior às 22:00h.");
        }

        if (!saida.isAfter(entrada)) {
            throw new HorarioInvalidoException("Erro: O horário de saída deve ser posterior ao horário de entrada.");
        }

        long minutosTotais = Duration.between(entrada, saida).toMinutes();
        double horasTotais = minutosTotais / 60.0;
        double horasTrabalhadas = horasTotais - 1.0;

        if (horasTrabalhadas <= 0) {
            throw new HorarioInvalidoException("Erro: O tempo total deve ser superior a 1 hora (tempo do almoço).");
        }

        double horasExtras = horasTrabalhadas - 8.0;
        if (horasExtras > f.getTipo().getMaxHorasExtras()) {
            throw new LimiteDeHorasExtrasException("Erro: Limite de horas extras excedido para o cargo " + f.getTipo().getDescricao()
                    + ". Máximo permitido: " + f.getTipo().getMaxHorasExtras() + "h extras.");
        }

        RegistroPonto registro = new RegistroPonto(data, entrada, saida, horasTrabalhadas);
        f.adicionarRegistro(registro);
        return true;
    }
}