package com.cadastroreservahotel.entity;

public class Reserva {
    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDiasDiaria;
    private double valorDiaria;

    public Reserva(String nome, String quarto, int diasDiaria, double valorDiaria) {
        this.nomeHospede = nome;
        this.tipoQuarto = quarto;
        this.numeroDiasDiaria = diasDiaria;
        this.valorDiaria = valorDiaria;
    }

    public boolean setNomeHospede(String nome) {
        if (nome != null && nome.matches("[a-zA-ZáàâãéèêíïóôõöúçÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇ ]+")) {
            this.nomeHospede = nome;
            return true;
        }
        return false;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public boolean setNumeroDiasDiaria(int diasDiaria) {
        if (diasDiaria > 0) {
            this.numeroDiasDiaria = diasDiaria;
            return true;
        }
        return false;
    }

    public int getNumeroDiasDiaria() {
        return numeroDiasDiaria;
    }

    public double CalcularValorTotal () {
        return this.valorDiaria * this.numeroDiasDiaria;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nomeHospede + " | " + "Quarto: " + this.tipoQuarto + " | " + "Qntd. de estadia: "
                + this.numeroDiasDiaria + " | " + "Valor diaria: R$ " + this.valorDiaria;
    }
}
