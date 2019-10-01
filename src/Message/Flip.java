package Message;

import Communicator.DroneCommunicator;
import Communicator.DroneState;

import java.util.Scanner;

public class Flip extends Message{

    @Override
    public void doAction(DroneCommunicator droneCommunicator,DroneState droneState) throws Exception {
        System.out.print("Flip in direction: f,b,r,l->");
        Scanner scan= new Scanner(System.in);
        String direction= scan.next();
        String request= "flip "+ direction;

        if(direction.equals("f")|| direction.equals("b")||direction.equals("l")||direction.equals("r")) {

            droneCommunicator.sendRequest(request);
            System.out.println(droneCommunicator.receiveRequest() + "received");
            double xAxis = droneState.getPositionX();
            double yAxis = droneState.getPositionY();
            double zAxis = droneState.getPositionZ();
            if (direction.equals("f")) {
                yAxis = yAxis+ 10.0;
                droneState.move(xAxis, yAxis, zAxis);
            } else if (direction.equals("b")) {
                yAxis =yAxis- 10.0;
                droneState.move(xAxis, yAxis, zAxis);
            } else if (direction.equals("l")) {
                xAxis= xAxis +10;
                droneState.move(xAxis, yAxis, zAxis);
            } else if (direction.equals("r")) {
                xAxis= xAxis - 10;
                droneState.move(xAxis, yAxis, zAxis);
            }
        }else{
            System.out.println("Invalid Command.");
        }
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
