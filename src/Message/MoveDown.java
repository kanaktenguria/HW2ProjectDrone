package Message;
import Common.DroneCommunicator;
import Common.DroneState;

import java.util.Scanner;

public class MoveDown extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        System.out.print("Move x cm down. Enter x=");
        Scanner scan= new Scanner(System.in);
        int x= scan.nextInt();
        String request= "down "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double yAxis=droneState.getPositionY();
        double xAxis=droneState.getPositionX();
        double zAxis=x;
        zAxis=droneState.getPositionZ()-zAxis;

        droneState.move(xAxis,yAxis,zAxis);
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }

}
