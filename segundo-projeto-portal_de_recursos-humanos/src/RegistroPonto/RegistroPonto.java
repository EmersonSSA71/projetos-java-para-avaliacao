package RegistroPonto;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroPonto {
    private LocalDate data;
    private LocalTime entrada;
    private LocalTime saida;
    private double horasTrabalhadas;

    public RegistroPonto(LocalDate data, LocalTime entrada, LocalTime saida, double horasTrabalhadas) {
        this.data = data;
        this.entrada = entrada;
        this.saida = saida;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    @Override
    public String toString() {
        return "Data: " + data + " | Entrada: " + entrada + " | Saída: " + saida + " | Horas Liquidas Trabalhadas: " + horasTrabalhadas + "h";
    }
}
