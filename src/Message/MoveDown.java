package Message;
import Communicator.DroneCommunicator;
import Communicator.DroneState;

public class MoveDown extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveDown(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
int x;
    public MoveDown(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        String request= "down "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
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
