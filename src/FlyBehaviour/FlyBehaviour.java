package FlyBehaviour;
import Communicator.*;

public abstract class FlyBehaviour {

    public abstract void doMission(DroneCommunicator droneCommunicator) throws Exception;
}
