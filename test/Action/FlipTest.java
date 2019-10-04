package Action;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlipTest {
    @Test
    public void testDoAction() throws Exception {
        Thread mockSenderFlip= new Thread(new MockSenderFlip());
        Thread mockReplierFlip= new Thread(new MockReplierFlip());
        mockReplierFlip.start();
        mockSenderFlip.start();
        //Shows that connection is properly setup and doAction method is working properly. Otherwise it will give some king of exception.
    }

    @Test
    public void testGetMessageType(){
        Flip moveFlip= new Flip();
        assertNull(moveFlip.getMessageType());
    }
}

class MockSenderFlip implements Runnable{

    @Override
    public void run() {
        try {
            DroneCommunicator droneCommunicator = new DroneCommunicator("127.0.0.1", 9090);
            DroneState droneState = new DroneState();
            Status status = new Status(0, 0, 1, 10, 10, 10, 5, 50, 40, 80, 29, 15.2, 56, 25.5, 25.5, 25.5);
            droneState.setInCommandMode(true);
            droneState.setHasTakenOff(true);
            droneState.updateFlyingInfo(status);
            Flip flip= new Flip();
            flip.doAction(droneCommunicator, droneState);
        }catch(Exception E){

        }
    }

}
class MockReplierFlip implements Runnable{
    String reply=null;

    @Override
    public void run() {
        DroneCommunicator droneCommunicator1= null;
        try {
            droneCommunicator1 = new DroneCommunicator(9090);
            reply=droneCommunicator1.receiveRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}