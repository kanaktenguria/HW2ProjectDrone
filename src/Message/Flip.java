package Message;

import Common.DroneCommunicator;
import Common.DroneState;

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
            if (direction.equals("f")) {
                double yAxis = + 10.0;
                droneState.move(0, yAxis,0);
            } else if (direction.equals("b")) {
                double yAxis = - 10.0;
                droneState.move(0, yAxis, 0);
            } else if (direction.equals("l")) {
                double xAxis= +10;
                droneState.move(xAxis, 0,0);
            } else if (direction.equals("r")) {
                double xAxis= - 10;
                droneState.move(xAxis, 0, 0);
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
