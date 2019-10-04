package Action;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateClockWiseTest {
    @Test
    public void testDoAction() throws Exception {
        Thread mockSenderCW= new Thread(new MockSenderCW());
        Thread mockReplierCW= new Thread(new MockReplierCW());
        mockReplierCW.start();
        mockSenderCW.start();
        //Shows that connection is properly setup and doAction method is working properly. Otherwise it will give some king of exception.
    }

    @Test
    public void testGetMessageType(){
        RotateClockWise moveCW= new RotateClockWise();
        assertNull(moveCW.getMessageType());
    }
}
class MockSenderCW implements Runnable{

    @Override
    public void run() {
        try {
            DroneCommunicator droneCommunicator = new DroneCommunicator("127.0.0.1", 9090);
            DroneState droneState = new DroneState();
            Status status = new Status(0, 0, 1, 10, 10, 10, 5, 50, 40, 80, 29, 15.2, 56, 25.5, 25.5, 25.5);
            droneState.setInCommandMode(true);
            droneState.setHasTakenOff(true);
            droneState.updateFlyingInfo(status);
            RotateClockWise moveCW= new RotateClockWise();
            moveCW.doAction(droneCommunicator, droneState);
        }catch(Exception E){

        }
    }

}
class MockReplierCW implements Runnable{
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