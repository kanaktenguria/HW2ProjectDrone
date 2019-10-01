package FlyBehaviour;
import Common.DroneCommunicator;
import Common.DroneState;
import Message.*;

public abstract class FlyBehaviour {

    DroneCommunicator droneCommunicator;
    DroneState droneState;
    Message message;

    public void setDroneCommunicatorAndState(DroneCommunicator droneCommunicator, DroneState droneState){
        this.droneCommunicator= droneCommunicator;
        this.droneState=droneState;
    }

    public DroneCommunicator getDroneCommunicator() {
        return droneCommunicator;
    }

    public DroneState getDroneState() {
        return droneState;
    }

    public final void flyBehaviourTemplate() throws Exception {
        droneTakeoff();
        doMission();
        droneLand();
    }

    public void droneTakeoff() throws Exception {
        if(droneState.getBatteryPercentage()<=10 || droneState.getHighTemperature()>=70) {
            System.out.println("Either Battery low or High temperature. Mission aborted");
        }
        else{
            droneState.setHasTakenOff(true);
            message = new TakeOff();
            message.doAction(droneCommunicator,droneState);
        }
    }

    public abstract void doMission() throws Exception;

    public void droneLand() throws Exception {
        message = new Land();
        message.doAction(droneCommunicator,droneState);
    }
}
