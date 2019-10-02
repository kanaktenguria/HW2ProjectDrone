package Message;
import Common.DroneCommunicator;
import Common.DroneState;

import java.util.Scanner;

public class MoveRight extends Message {

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
            System.out.print("Move x cm right. Enter x=");
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            String request = "right " + x;
            droneCommunicator.sendRequest(request);
            System.out.println(droneCommunicator.receiveRequest() + "received");
            double xAxis = -x;
            droneState.move(xAxis, 0, 0);
            Thread.sleep(5000);
        }
    }

    @Override
    public String getMessageType() {
        return null;
    }

}
