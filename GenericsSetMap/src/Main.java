import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto();
        produto1.setNome("Maquina de lavar");
        produto1.setPreco(1889.90);

        Produto produto2 = new Produto();
        produto2.setNome("Sofá");
        produto2.setPreco(1399.90);

        Produto produto3 = new Produto();
        produto3.setNome("Cama de Casal");
        produto3.setPreco(1199.99);

        List<Produto> produtos = new ArrayList<>();

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        ListaUtil listaUtil = new ListaUtil();

        listaUtil.ordenarExibir(produtos);

    }
}