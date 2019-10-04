package Flyer;

import Common.DroneCommunicator;
import Common.DroneState;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

class RequestSenderTest {
        @Test
        public void testRequestSender() throws Exception{
            DroneState droneState=new DroneState();
            MockServer testDummy= new MockServer();
            Thread testSimulator= new Thread(testDummy);
            testSimulator.start();
            String IPAddress = "127.0.0.1";
            int senderPort = 8889;
            RequestSender requestSender =new RequestSender(droneState);
            requestSender.initialize(IPAddress, senderPort);
            requestSender.executePreExistingMission(1);
        }

}

class MockServer implements Runnable{
    @Override
    public void run() {
        DroneCommunicator droneCommunicator = null;
        try {
            droneCommunicator = new DroneCommunicator(8889);
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