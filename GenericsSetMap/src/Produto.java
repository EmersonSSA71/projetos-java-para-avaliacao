public class Produto implements Comparable<Produto> {

    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Produto o) {
        return Double.compare(this.preco, o.preco);
    }

    @Override
    public String toString() {
        return "Nome: |" + this.getNome() + "| Preço: R$" + this.getPreco();
    }
}
