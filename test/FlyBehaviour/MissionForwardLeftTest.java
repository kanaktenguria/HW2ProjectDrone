package FlyBehaviour;

import Common.DroneCommunicator;
import Common.DroneState;
import Flyer.RequestSender;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.*;

class MissionForwardLeftTest {
    @Test
    public void testMissionDownUp() throws Exception{
        MockSenderMissionTwo testDummy = new MockSenderMissionTwo();
        MockReceiverMissionTwo testClient= new MockReceiverMissionTwo();
        Thread testReceiver = new Thread(testDummy);
        Thread testRespond= new Thread(testClient);
        testReceiver.start();
        testRespond.start();
    }

}

class MockSenderMissionTwo implements Runnable{

    @Override
    public void run() {
        try {
            DroneState droneState = new DroneState();
            String IPAddress = "127.0.0.1";
            int senderPort = 7790;
            RequestSender requestSender= new RequestSender(droneState);
            requestSender.initialize(IPAddress, senderPort);
            requestSender.executePreExistingMission(2);
        }catch(Exception e){

        }
    }
}
class MockReceiverMissionTwo implements Runnable{
    @Override
    public void run() {
        DroneCommunicator droneCommunicator = null;
        try {
            droneCommunicator = new DroneCommunicator(7790);
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