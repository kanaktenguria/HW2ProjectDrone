package Message;
import Common.DroneCommunicator;
import Common.DroneState;

public class Land extends Message {
//    private DroneCommunicator droneCommunicator;
//    public Land(DroneCommunicator droneCommunicator) {
//        this.droneCommunicator = droneCommunicator;
//    }

    @Override
    public void doAction(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        droneCommunicator.sendRequest("land");
        System.out.println(droneCommunicator.receiveRequest()+"received");
        double zAxis=droneState.getPositionZ();
        double xAxis=droneState.getPositionX();
        double yAxis=droneState.getPositionY();
        System.out.println(xAxis+","+yAxis+","+zAxis);
        zAxis=-80.0;
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
