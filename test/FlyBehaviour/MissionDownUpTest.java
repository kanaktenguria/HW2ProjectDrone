package FlyBehaviour;

import Common.DroneCommunicator;
import Common.DroneState;
import Flyer.*;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.*;

class MissionDownUpTest {
    @Test
    public void testMissionDownUp() throws Exception{
        MockSenderMissionOne testDummy = new MockSenderMissionOne();
        MockReceiverMissionOne testClient= new MockReceiverMissionOne();
        Thread testReceiver = new Thread(testDummy);
        Thread testRespond= new Thread(testClient);
        testReceiver.start();
        testRespond.start();
    }

}

class MockSenderMissionOne implements Runnable{

    @Override
    public void run() {
        try {
            DroneState droneState = new DroneState();
            String IPAddress = "127.0.0.1";
            int senderPort = 7790;
            RequestSender requestSender= new RequestSender(droneState);
            requestSender.initialize(IPAddress, senderPort);
            requestSender.executePreExistingMission(1);
        }catch(Exception e){

        }
    }
}
class MockReceiverMissionOne implements Runnable{
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