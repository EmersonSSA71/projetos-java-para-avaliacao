package com.orientacaoaobjetos.entity;

public class Carro {

    public int QuantidadeDeCarrosCriados;
    public String NomeDoCarro;
    public double PrecoDoCarro;


    public String toString() {
        return "Qntd.: " + QuantidadeDeCarrosCriados + " |" + " Nome: " + NomeDoCarro + " |" + " Preço(R$): " + PrecoDoCarro;

    }
}
