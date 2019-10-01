package Message;
import Common.DroneCommunicator;
import Common.DroneState;

import java.util.Scanner;

public class MoveUp extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        System.out.print("Move x cm up. Enter x=");
        Scanner scan= new Scanner(System.in);
        int x= scan.nextInt();
        String request= "up "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double zAxis=x;
        droneState.move(0,0,zAxis);
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }

}
