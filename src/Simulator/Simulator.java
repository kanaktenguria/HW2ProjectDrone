package Simulator;

import Communicator.DroneCommunicator;
import Communicator.DroneState;
import Message.Status;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Simulator implements Runnable{

    public static void main(String[] args) throws Exception {
        DroneState droneState = new DroneState();
        Simulator sendState= new Simulator();
        Thread thread= new Thread(sendState);
        thread.start();
//        Boolean commandMode= false;
//        Boolean takenOff= false;
        DroneCommunicator droneCommunicator= new DroneCommunicator(8889);

//        droneCommunicator.initializeSimulator(8889);
        while(true) {
            String reply = droneCommunicator.receiveRequest();
            System.out.println(reply);
            InetAddress senderAddress = droneCommunicator.getSenderAddress();
            int destinationPort = droneCommunicator.getDestinationPort();
            droneCommunicator.setAddress(senderAddress, destinationPort);
//            if(reply.equals("command")){
//                commandMode=true;
//            }
            CommandHandler commandHandler= new CommandHandler();
            commandHandler.selectCommand(reply, droneCommunicator);

//            System.out.println("Inside simulator" + reply);
//            if (reply.equals("command")) {
//                commandMode = true;
//                System.out.println("Inside command");
//                droneCommunicator.sendRequest("ok");
//            } else if (commandMode == true) {
//                System.out.println("kanak");
//                reply = droneCommunicator.receiveRequest();
//                if (reply.equals("takeoff")) {
//                    System.out.println("Drone has taken off");
//                    droneCommunicator.sendRequest("error");
//                }
//            } else {
//                System.out.println("Put drone in command mode.");
//            }

        }
    }

    @Override
    public void run() {


        Status sendStatus= new Status(0,0,1,10,10,10,5,50,40,80,90,15.2,56,25.5,25.5,25.5);
        String currentStatus=sendStatus.getMessageText();
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

