package Flyer;
import Common.DroneCommunicator;
import Common.DroneState;
import FlyBehaviour.FlyBehaviour;
//import ReadMissionFile.ReadFileTemplate;
import ReadMissionFile.ReadMissionFile;
import FlyBehaviour.MissionDownUp;
import FlyBehaviour.MissionForwardLeft;
import FlyBehaviour.MissionLeftRotateRight;

class RequestSender {
    private DroneState droneState;
    private DroneCommunicator droneCommunicator;

    FlyBehaviour flyBehaviour;

    public RequestSender(DroneState droneState) {
        this.droneState=droneState;
    }

//    public void setDroneState(DroneState droneState){
//        this.droneState= droneState;
//    }
    public void initialize(String IPAddress, int senderPort) throws Exception {
        droneCommunicator = new DroneCommunicator(IPAddress, senderPort);
        droneCommunicator.initialize();
        droneState.setInCommandMode(true);

    }

    public void executePreExistingMission(int missionChoice) throws Exception {
        switch (missionChoice){
            case 1:
                MissionDownUp missionDownUp = new MissionDownUp();
                flyBehaviour= missionDownUp;
                break;
            case 2:
                MissionForwardLeft missionForwardLeft= new MissionForwardLeft();
                flyBehaviour=missionForwardLeft;
                break;
            case 3:
                MissionLeftRotateRight missionLeftRotateRight= new MissionLeftRotateRight();
                flyBehaviour=missionLeftRotateRight;
                break;
        }
        flyBehaviour.setDroneCommunicatorAndState(droneCommunicator,droneState);
        flyBehaviour.flyBehaviourTemplate();
    }

    void readFile(ReadMissionFile readMissionFile) throws Exception {
        readMissionFile.readFile(droneCommunicator, droneState);
   }

    public FlyBehaviour getFlyBehaviour() {
        return flyBehaviour;
    }

    //    public void setStatus(Status status){
//        this.status=status;
//    }

}
