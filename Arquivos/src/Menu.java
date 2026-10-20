import AtividadeArquivos.*;

import java.util.List;

public class Menu {
    public static void main(String[] args) {
        String caminhoEntrada = CaminhoDoArquivo.CAMINHO_DO_ARQUIVO;

        OperacaoSalvarDados operacao = new OperacaoSalvarDados();
        List<Cliente> listaClientes = operacao.lerClintesDoArquivo(caminhoEntrada);

        GeradorDeArquivo geradorXML = new ArquivoXML();
        geradorXML.gerarArquivos(listaClientes, "clientes_saida");
    }
}