package ReadMissionFile;

import Common.DroneCommunicator;
import Common.DroneState;
import Flyer.RequestSender;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.*;

class ReadCSVTest {
    @Test
    public void testCSV(){
        try {
            MockSenderCSV testDummy = new MockSenderCSV();
            MockReceiverCSV testClient= new MockReceiverCSV();
            Thread testReceiver = new Thread(testDummy);
            Thread testRespond= new Thread(testClient);
            testReceiver.start();
            testRespond.start();

        }catch(Exception e){

        }

    }
}
class MockSenderCSV implements Runnable{
    @Test
    @Override
    public void run() {
        try {
            DroneState droneState = new DroneState();
            RequestSender requestSender = new RequestSender(droneState);
            requestSender.initialize("127.0.0.1", 9898);
            ReadMissionFile readMissionFile;
            ReadCSV readCSV = new ReadCSV();
            readMissionFile = readCSV;
            requestSender.readFile(readMissionFile);

            assertNotNull(readCSV);

        }catch(Exception e){

        }
    }
}
class MockReceiverCSV implements Runnable{
    @Override
    public void run() {
        DroneCommunicator droneCommunicator = null;
        try {
            droneCommunicator = new DroneCommunicator(9898);
            droneCommunicator.receiveRequest();
            InetAddress senderAddress = droneCommunicator.getSenderAddress();
            int destinationPort = droneCommunicator.getDestinationPort();
            droneCommunicator.setAddress(senderAddress, destinationPort);
            droneCommunicator.sendRequest("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}