package Simulator;

import Common.DroneState;
import Message.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestReceiverTest {
    @Test
    public void testRequestReceiver() throws Exception {
        Status sendStatus= new Status(0,0,1,10,10,10,5,50,40,80,29,15.2,56,25.5,25.5,25.5);
        DroneState droneState= new DroneState();
        droneState.setInCommandMode(true);
        droneState.updateFlyingInfo(sendStatus);
        RequestReceiver requestReceiver= new RequestReceiver(droneState);
        assertNotNull(requestReceiver);
        //We can't test receive logic because it is interminable loop
    }
}