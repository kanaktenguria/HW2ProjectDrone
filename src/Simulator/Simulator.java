package Simulator;

import Communicator.DroneCommunicator;
import Communicator.DroneState;
import Message.Status;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

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

