package Simulator;

import Communicator.DroneCommunicator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) throws Exception {

        DroneCommunicator droneCommunicator= new DroneCommunicator();
        Scanner scan= new Scanner(System.in);

        droneCommunicator.initializeSimulator(8889);
        String reply=droneCommunicator.receiveRequest();
        InetAddress senderAddress= droneCommunicator.getSenderAddress();
        int senderPort= droneCommunicator.getSenderPort();
        droneCommunicator.setAddress(senderAddress,senderPort);
        System.out.println("Inside simulator"+reply);
        if(reply.equals("command")) {
            System.out.println("Inside command");
            droneCommunicator.sendRequest("ok");
        }


    }
}

