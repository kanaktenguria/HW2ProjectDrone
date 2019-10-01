package Simulator;

import Common.DroneCommunicator;
import Common.DroneState;

import java.net.InetAddress;

public class RequestReceiver {
    DroneState droneState;
    public RequestReceiver(DroneState droneState) {
        this.droneState=droneState;
    }
    public void receiveRequest() throws Exception {
        DroneCommunicator droneCommunicator= new DroneCommunicator(8889);

        while(true) {
            String reply = droneCommunicator.receiveRequest();
            System.out.println(reply);
            InetAddress senderAddress = droneCommunicator.getSenderAddress();
            int destinationPort = droneCommunicator.getDestinationPort();
            droneCommunicator.setAddress(senderAddress, destinationPort);

            RequestHandler requestHandler = new RequestHandler();
            requestHandler.selectCommand(reply, droneCommunicator);
        }
    }
}
