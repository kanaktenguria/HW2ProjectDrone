package Action;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    @Test
    public void testDoAction() throws Exception {
        DroneCommunicator droneCommunicator= new DroneCommunicator("127.0.0.1",9090);
        DroneState droneState= new DroneState();
        Status status= new Status(0,0,1,10,10,10,5,50,40,80,29,15.2,56,25.5,25.5,25.5);
        droneState.setInCommandMode(true);
        droneState.setHasTakenOff(true);
        droneState.updateFlyingInfo(status);
        Land land= new Land();
        land.doAction(droneCommunicator,droneState);
    }

}