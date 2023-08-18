package com.unifacisa.airlines;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Airlines {
    public static void main(String[] args) {
        try {
            File file = new File("airlines.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("passenger");

            System.out.println("Total de passageiros: " + nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String origin = element.getElementsByTagName("origin").item(0).getTextContent();
                    String destination = element.getElementsByTagName("destination").item(0).getTextContent();
                    System.out.printf("Passageiro: %s\nOrigem: %s --> Destino: %s\n", name, origin, destination);
                }
            }
        } catch (Exception err) {
            System.out.println("Deu pau --> " + err.getMessage());
        }
    }
}
