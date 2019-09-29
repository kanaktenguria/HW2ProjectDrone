package Message;

import Communicator.DroneCommunicator;

public class Flip extends Message{
    String direction=null;
    public Flip(String direction){
        this.direction=direction;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator) throws Exception {
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
