package FlyBehaviour;
import Action.*;

public class MissionDownUp extends FlyBehaviour {

    @Override
    public void doMission() throws Exception {
        action =new MoveDown();
        action.doAction(droneCommunicator,droneState);
        action = new MoveUp();
        action.doAction(droneCommunicator,droneState);
    }

}
