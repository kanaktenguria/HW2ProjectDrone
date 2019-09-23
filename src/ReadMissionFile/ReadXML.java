package ReadMissionFile;

import Communicator.DroneCommunicator;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXML extends ReadMissionFile {
    @Override
    public void readFile(DroneCommunicator droneCommunicator) throws IOException, ParserConfigurationException, SAXException {
//        return null;
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
////Build Document
//        Document document = builder.parse(new File("src/testXML.xml"));
//
////Normalize the XML Structure; It's just too important !!
//        document.getDocumentElement().normalize();
//
////Here comes the root node
//        Element root = document.getDocumentElement();
//        System.out.println(root.getNodeName());
//
////Get all employees
//        NodeList nList = document.getElementsByTagName("employee");
//        System.out.println("============================");
//
//        for (int temp = 0; temp < nList.getLength(); temp++)
//        {
//            Node node = nList.item(temp);
//            System.out.println("");    //Just a separator
//            if (node.getNodeType() == Node.ELEMENT_NODE)
//            {
//                //Print each employee's detail
//                Element eElement = (Element) node;
//                System.out.println("Employee id : "    + eElement.getAttribute("id"));
//                System.out.println("First Name : "  + eElement.getElementsByTagName("firstName").item(0).getTextContent());
//                System.out.println("Last Name : "   + eElement.getElementsByTagName("lastName").item(0).getTextContent());
//                System.out.println("Location : "    + eElement.getElementsByTagName("location").item(0).getTextContent());
//            }
//        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document
        Document document = builder.parse(new File("src/testXML.xml"));

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        //Here comes the root node
        Element root = document.getDocumentElement();
//        System.out.println(root.getNodeName());

        //Get all employees
        NodeList nList = document.getElementsByTagName("mission");
//        System.out.println("============================");

        visitChildNodes(nList);
    }
    private static void visitChildNodes(NodeList nList)
    {
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {   String result=node.getTextContent();
                System.out.println("kanak");
                System.out.println(result);
            }
        }
    }
}
