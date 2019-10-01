package Message;

import Communicator.DroneCommunicator;
import Communicator.DroneState;

public class Flip extends Message{
    String direction=null;
    public Flip(String direction){
        this.direction=direction;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator,DroneState droneState) throws Exception {


//        droneState.move();
        String request= "flip "+ direction;
        if(direction.equals("f")|| direction.equals("b")||direction.equals("l")||direction.equals("r")) {
            droneCommunicator.sendRequest(request);
            System.out.println(droneCommunicator.receiveRequest() + "received");
            double xAxis = droneState.getPositionX();
            double yAxis = droneState.getPositionY();
            double zAxis = droneState.getPositionZ();
            if (direction.equals("f")) {
                yAxis += 10.0;
                droneState.move(xAxis, yAxis, zAxis);
            } else if (direction.equals("b")) {
                yAxis -= 10.0;
                droneState.move(xAxis, yAxis, zAxis);
            } else if (direction.equals("l")) {
                xAxis += 10;
                droneState.move(xAxis, yAxis, zAxis);
            } else if (direction.equals("r")) {
                xAxis -= 10;
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
