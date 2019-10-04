package Action;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Status;
import Simulator.RequestReceiver;
import org.junit.jupiter.api.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class BatteryTest {
    @Test
    public void testDoAction() throws Exception {
        DroneCommunicator droneCommunicator= new DroneCommunicator("127.0.0.1",9090);
        DroneState droneState= new DroneState();
        Status status= new Status(0,0,1,10,10,10,5,50,40,80,29,15.2,56,25.5,25.5,25.5);
        droneState.setInCommandMode(true);
        droneState.setHasTakenOff(true);
        droneState.updateFlyingInfo(status);
        Battery battery= new Battery();
        battery.doAction(droneCommunicator,droneState);
    }

    @Test
    public void testGetMessageType(){
        Battery battery= new Battery();
        assertNull(battery.getMessageType());
    }
}
class MockReply{
    String reply=null;
    public void testMockReply() throws Exception {
        DroneCommunicator droneCommunicator1= new DroneCommunicator(9090);
        reply=droneCommunicator1.receiveRequest();
    }
}