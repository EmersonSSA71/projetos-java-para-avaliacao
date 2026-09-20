package Funcionario;

import RegistroPonto.RegistroPonto;
import TipoFuncionario.TipoFuncionario;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private int id;
    private String nome;
    private TipoFuncionario tipo;
    private List<RegistroPonto> registrosPonto;

    public Funcionario(int id, String nome, TipoFuncionario tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.registrosPonto = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public List<RegistroPonto> getRegistrosPonto() {
        return registrosPonto;
    }

    public void adicionarRegistro(RegistroPonto registro) {
        this.registrosPonto.add(registro);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Cargo: " + tipo.getDescricao();
    }
}
