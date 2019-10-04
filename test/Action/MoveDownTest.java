package Action;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveDownTest {
    @Test
    public void testDoAction() throws Exception {
        Thread mockSenderDown= new Thread(new MockSenderDown());
        Thread mockReplierDown= new Thread(new MockReplierDown());
        mockReplierDown.start();
        mockSenderDown.start();
        //Shows that connection is properly setup and doAction method is working properly. Otherwise it will give some king of exception.
    }

    @Test
    public void testGetMessageType(){
        MoveDown moveDown= new MoveDown();
        assertNull(moveDown.getMessageType());
    }

}


class MockSenderDown implements Runnable{

    @Override
    public void run() {
        try {
            DroneCommunicator droneCommunicator = new DroneCommunicator("127.0.0.1", 9090);
            DroneState droneState = new DroneState();
            Status status = new Status(0, 0, 1, 10, 10, 10, 5, 50, 40, 80, 29, 15.2, 56, 25.5, 25.5, 25.5);
            droneState.setInCommandMode(true);
            droneState.setHasTakenOff(true);
            droneState.updateFlyingInfo(status);
            MoveDown moveDown= new MoveDown();
            moveDown.doAction(droneCommunicator, droneState);
        }catch(Exception E){

        }
    }

}
class MockReplierDown implements Runnable{
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