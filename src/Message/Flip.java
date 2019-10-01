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

        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        Thread.sleep(5000);
    }

    @Override
    public String getMessageType() {
        return null;
    }
}
