import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> listaNomes = new ArrayList<>();

        listaNomes.add("Ana");
        listaNomes.add("Bruno");
        listaNomes.add("Carlos");
        listaNomes.add("Amanda");
        listaNomes.add("Beatriz");

        FiltroNome filtroNome = (nomes) -> {

            boolean nome = nomes.startsWith("A");

            return nome;

        };

       listaNomes.stream().filter(nomes -> filtroNome.testar(nomes)).forEach(System.out::println);

    }
}