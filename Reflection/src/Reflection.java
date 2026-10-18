import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String... args) throws Exception {
//instaciar a classe
        Lista minhaLista = new Lista();
//instaciar dinamicamente o ArrayList
        Class classeArrayList = Class.forName("java.util.ArrayList");
        Constructor construtor = classeArrayList.getDeclaredConstructor();
        Object outraLista= construtor.newInstance();
//fazer o acesso de um atributo privado por meio do field
        Field acessarListaPrivada = Lista.class.getDeclaredField("atributo");
        acessarListaPrivada.setAccessible(true);
        acessarListaPrivada.set(minhaLista, outraLista);
        // transformar esse acesso em outra lista do tipo object ja instanciando a minha classe
        Object listaInterna = acessarListaPrivada.get(minhaLista);
//usar o Method para invocar o metodo add do meu atributo do tipo List<>
        Method adicionarAdd = classeArrayList.getDeclaredMethod("add", Object.class);

        adicionarAdd.invoke(listaInterna, "Pessoa 1");
        adicionarAdd.invoke(listaInterna, "Pessoa 2");
        adicionarAdd.invoke(listaInterna, "Pessoa 3");
        //metodos size e get para exibir
        Method metodoSize = classeArrayList.getDeclaredMethod("size");
        Method metodoGet = classeArrayList.getDeclaredMethod("get", int.class);

        int tamanho = (int) metodoSize.invoke(listaInterna);

        for (int i = 0; i < tamanho; i++) {
            System.out.println("add " + metodoGet.invoke(listaInterna, i));
        }
    }
}
