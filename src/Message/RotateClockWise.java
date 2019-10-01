package Message;
import Common.DroneCommunicator;
import Common.DroneState;

import java.util.Scanner;

public class RotateClockWise extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        System.out.print("Rotate x degrees clockwise. Enter x=");
        Scanner scan= new Scanner(System.in);
        int x= scan.nextInt();
        String request= "cw "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }

//    @Override
//    public String getMessageType() {
//        return null;
//    }
}
