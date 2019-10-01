package Message;
import Communicator.DroneCommunicator;
import Communicator.DroneState;

import java.util.Scanner;

public class RotateAntiClockWise extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        System.out.print("Rotate x degrees anti-clockwise. Enter x=");
        Scanner scan= new Scanner(System.in);
        int x= scan.nextInt();
        String request= "ccw "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }

}
