package Flyer;

import Common.DroneState;
import Simulator.StateUpdater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testStateReceiverTest{
    @Test
    public void testState() {
        DroneState droneState= new DroneState();
        StateUpdater testUpdater= new StateUpdater(droneState);
        StateReceiver stateReceiver= new StateReceiver(droneState);
        Thread thread1= new Thread(stateReceiver);
        Thread thread2= new Thread(testUpdater);
        thread2.start();
        thread1.start();
    }

}