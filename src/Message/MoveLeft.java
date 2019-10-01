package Message;
import Communicator.DroneCommunicator;
import Communicator.DroneState;

import java.util.Scanner;

public class MoveLeft extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        System.out.print("Move x cm left. Enter x=");
        Scanner scan= new Scanner(System.in);
        int x= scan.nextInt();
        String request= "left "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double yAxis=droneState.getPositionY();
        double xAxis=x;
        xAxis=droneState.getPositionX()+xAxis;
        double zAxis=droneState.getPositionZ();
        droneState.move(xAxis,yAxis,zAxis);
//        droneCommunicator.getState();
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }

}
