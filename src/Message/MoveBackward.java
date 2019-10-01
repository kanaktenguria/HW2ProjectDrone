package Message;
import Common.DroneCommunicator;
import Common.DroneState;

import java.util.Scanner;

public class MoveBackward extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        System.out.print("Move x cm back. Enter x=");
        Scanner scan= new Scanner(System.in);
        int x= scan.nextInt();
        String request= "back "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double yAxis=-x;
        droneState.move(0,yAxis,0);
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }

}
