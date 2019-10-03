package Flyer;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Status;

import java.net.SocketException;

public class StateReceiver implements Runnable{
    DroneState droneState;
    private Status status;
    public StateReceiver(DroneState droneState) {
        this.droneState=droneState;
    }

    @Override
    public void run() {
        DroneCommunicator State = null;
        try {
            State = new DroneCommunicator(8890);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                 String reply = State.receiveRequest();
                status = new Status(reply);
               droneState.updateFlyingInfo(this.status);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
