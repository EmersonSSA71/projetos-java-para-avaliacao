package AtividadeArquivos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class ArquivoXML implements GeradorDeArquivo {

    @Override
    public void gerarArquivos(List<Cliente> lista, String caminhoDoArquivo){

        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element raiz = document.createElement("Raiz");
            document.appendChild(raiz);

            for (Cliente cliente : lista) {

                Element elementoCliente = document.createElement("cliente");

                Element id = document.createElement("id");
                id.appendChild(document.createTextNode(cliente.getId()));
                elementoCliente.appendChild(id);

                Element nome = document.createElement("nome");
                nome.appendChild(document.createTextNode(cliente.getNome()));
                elementoCliente.appendChild(nome);

                Element email = document.createElement("email");
                email.appendChild(document.createTextNode(cliente.getEmail()));
                elementoCliente.appendChild(email);


                raiz.appendChild(elementoCliente);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();


            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(caminhoDoArquivo + ".xml"));
            transformer.transform(source, result);

            System.out.println("Arquivo XML gerado com sucesso em " +caminhoDoArquivo+ ".xml" );

        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo XML" + e.getMessage());
            e.printStackTrace();
        }
    }
}
