package Message;
import Common.DroneCommunicator;
import Common.DroneState;

import java.util.Scanner;

public class MoveForward extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        System.out.print("Move x cm forward. Enter x=");
        Scanner scan= new Scanner(System.in);
        int x= scan.nextInt();
        String request= "forward "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double yAxis=x;
        double xAxis=droneState.getPositionX();
        yAxis=droneState.getPositionY()+yAxis;
        double zAxis=droneState.getPositionZ();
        droneState.move(xAxis,yAxis,zAxis);
//        droneCommunicator.getState();
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
