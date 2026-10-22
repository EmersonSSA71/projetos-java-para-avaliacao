import java.util.Collections;
import java.util.List;

public class ListaUtil {

    public <G extends Comparable<G>> void ordenarExibir(List<G> lista){

        Collections.sort(lista);

        for (G produto : lista) {
            System.out.println(produto);
        }

    }

}
