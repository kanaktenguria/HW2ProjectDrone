package ReadMissionFile;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Message;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXML extends ReadMissionFile {
    @Override
    public void readFile(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
//        Message message = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/testXML.xml"));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        NodeList nList = document.getElementsByTagName("task");
        String[] result= new String[nList.getLength()];
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {   result[temp] =node.getTextContent();
            }
        }
        Message actionArray[]=executeMission(droneCommunicator,result, droneState);
        for (int i = 0; i < result.length; i++){
            actionArray[i].doAction(droneCommunicator,droneState);
        }
    }
}
