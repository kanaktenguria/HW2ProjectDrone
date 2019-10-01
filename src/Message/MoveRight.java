package Message;
import Communicator.DroneCommunicator;
import Communicator.DroneState;

public class MoveRight extends Message {
//    private DroneCommunicator droneCommunicator;
//    public MoveRight(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }
int x;
    public MoveRight(int x){
        this.x=x;
    }
    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        String request= "right "+x;
        droneCommunicator.sendRequest(request);
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double yAxis=droneState.getPositionY();
        double xAxis=x;
        xAxis-=droneState.getPositionX();
        double zAxis=droneState.getPositionZ();
        droneState.move(xAxis,yAxis,zAxis);
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
