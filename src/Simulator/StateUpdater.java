package Simulator;

import Common.DroneCommunicator;
import Common.DroneState;
import Message.Status;

import java.net.SocketException;
import java.net.UnknownHostException;

public class StateUpdater implements Runnable{
    DroneState droneState;
    public StateUpdater(DroneState droneState) {
        this.droneState=droneState;
    }

    @Override
    public void run() {
        Status sendStatus= new Status(0,0,1,10,10,10,5,50,40,80,90,15.2,56,25.5,25.5,25.5);
        String currentStatus=sendStatus.getMessageText();
        droneState.setInCommandMode(true);
        droneState.updateFlyingInfo(sendStatus);
        DroneCommunicator sendStatusCommunicator= null;
        try {
            sendStatusCommunicator = new DroneCommunicator("127.0.0.1",8890);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                sendStatusCommunicator.sendRequest(currentStatus);
//                System.out.println();
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
