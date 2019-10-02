package Message;
import Common.DroneCommunicator;
import Common.DroneState;

import java.util.Scanner;

public class MoveBackward extends Message {

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        if (droneState.getBatteryPercentage() <= 10 || droneState.getHighTemperature() >= 70) {
            System.out.println("Either Battery low or High temperature. Mission aborted");
            System.out.println("Drone is landing.");
            droneCommunicator.sendRequest("land");
            System.out.println(droneCommunicator.receiveRequest() + "received");
            double zAxis = droneState.getPositionZ();
            double xAxis = droneState.getPositionX();
            double yAxis = droneState.getPositionY();
            System.out.println(xAxis + "," + yAxis + "," + zAxis);
            zAxis = 0.0;
            droneState.move(xAxis, yAxis, zAxis);
            Thread.sleep(5000);

        }else {
            System.out.print("Move x cm back. Enter x=");
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            String request = "back " + x;
            double yAxis = -x;
            droneState.move(0, yAxis, 0);
            if(droneState.getPositionX()>200 || droneState.getPositionY()>200){
                System.out.println("Drone stepping outside 2 meter radius, Stopping for 3 seconds.");
                Thread.sleep(3000);
            }
            droneCommunicator.sendRequest(request);
            System.out.println(droneCommunicator.receiveRequest() + "received");

//        droneCommunicator.getState();
            Thread.sleep(5000);
        }
    }

    @Override
    public String getMessageType() {
        return null;
    }

}
