package innopolis.stc21.MA;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MySocket {
    static final int DEFAULT_PORT = 8000;
    static final String DEFAULT_IP = "127.0.0.1";

    public static void main(String[] args) {
        int port = 0;
        String ip = "";
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src\\main\\resources\\MySocket.config");

            Node node = document.getDocumentElement();
            NodeList elements = node.getChildNodes();
            for (int i = 0; i < elements.getLength(); i++) {
                Node element = elements.item(i);
                if (element.getNodeType() != Node.TEXT_NODE && element.getNodeName() == "PORT") {
                    port = Integer.valueOf(element.getChildNodes().item(0).getTextContent());

                }
                if (element.getNodeType() != Node.TEXT_NODE && element.getNodeName() == "IP") {
                    ip = element.getChildNodes().item(0).getTextContent();
                }
            }
        } catch (Throwable e) {
            port = DEFAULT_PORT;
            ip = DEFAULT_IP;
        }
    }

}
