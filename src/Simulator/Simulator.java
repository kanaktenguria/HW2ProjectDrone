package Simulator;

import Common.DroneState;

public class Simulator{

    public static void main(String[] args) throws Exception {
        DroneState droneState = new DroneState();
        StateUpdater stateUpdater= new StateUpdater(droneState);
        Thread thread= new Thread(stateUpdater);
        thread.start();
        RequestReceiver requestReceiver= new RequestReceiver(droneState);
        requestReceiver.receiveRequest();
    }


}

