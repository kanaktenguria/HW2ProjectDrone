package FlyBehaviour;
import Communicator.*;

public abstract class FlyBehaviour {

    DroneCommunicator droneCommunicator;
    public void setDroneCommunicator(DroneCommunicator droneCommunicator){
        this.droneCommunicator= droneCommunicator;
    }
    public final void MissionTemplate() throws Exception {
        droneTakeoff();
        doMission();
        droneLand();
    }
    public abstract void droneTakeoff();
    public abstract void doMission() throws Exception;
    public abstract void droneLand();
}
