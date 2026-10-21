import java.util.Collections;
import java.util.List;

public class ListaUtil {

    public <G extends Produto> void ordenarExibir(List<G> lista){

        Collections.sort(lista);

        for (Produto produto : lista) {
            System.out.println(produto);
        }

    }

}
