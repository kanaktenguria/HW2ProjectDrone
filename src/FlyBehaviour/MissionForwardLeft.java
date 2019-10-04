package FlyBehaviour;
import Action.*;

public class MissionForwardLeft extends FlyBehaviour {

    @Override
    public void doMission() throws Exception {
        action =new MoveForward();
        action.doAction(droneCommunicator,droneState);
        action = new MoveLeft();
        action.doAction(droneCommunicator,droneState);
        action =new MoveBackward();
        action.doAction(droneCommunicator,droneState);
    }

}
