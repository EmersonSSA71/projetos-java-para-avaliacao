package com.orientacaoaobjetos.entity;

public class Aluno {
    private String nome;
    private int idade;
    private double[] nota;

    public Aluno(String nome1, int idade1){
        this.nome = nome1;
        this.idade = idade1;
        this.nota = new double[4];
    }

    public void setNota(int posicao, double Valornota) {
        this.nota[posicao] = Valornota;
    }

    public void exibirDados() {
        System.out.println("___________________________");
        System.out.println("Aluno(a): " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.print("Notas: ");
        for (int i = 0; i < this.nota.length; i++) {
            System.out.print(this.nota[i] + " | ");
           // this.mediaDasNotas = this.nota[i] + this.mediaDasNotas;  COMENTEI PORQUE CRIEI UM METODO PARA MÉDIA
        }
       // System.out.println("Média: " + (this.mediaDasNotas / this.nota.length)); COMENTEI PORQUE CRIEI UM METODO PARA MÉDIA
    }
    public void mediaDasNotas() {
        double somaMedia = 0;
        for (int i = 0; i < this.nota.length; i++) {
            somaMedia += this.nota[i];
        }
        System.out.println("Média: " + somaMedia / this.nota.length);
    }
}