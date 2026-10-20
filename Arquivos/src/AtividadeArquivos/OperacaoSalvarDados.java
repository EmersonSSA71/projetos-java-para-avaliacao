package AtividadeArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class OperacaoSalvarDados {

    public List<Cliente> lerClintesDoArquivo(String caminho) {

        List<Cliente> lista = new ArrayList<>();

        BufferedWriter writer = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] dados = linha.split(";");
                Cliente cliente = new Cliente(dados[0], dados[1], dados[2]);
                lista.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;

    }
}