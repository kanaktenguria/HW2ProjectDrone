package Communicator;
import FlyBehaviour.FlyBehaviour;
//import ReadMissionFile.ReadFileTemplate;
import ReadMissionFile.ReadMissionFile;

import java.io.IOException;

class Flier{
    private DroneCommunicator droneCommunicator;

    public void initialize(String iPAddress, int dronePort) throws Exception {
        droneCommunicator = new DroneCommunicator(iPAddress, dronePort);
        droneCommunicator.initialize();
    }

//    void doMission(FlyBehaviour flyBehaviour) throws Exception {
//        flyBehaviour.doMission(droneCommunicator);
//    }

    void readFile(ReadMissionFile readMissionFile) throws Exception {
        readMissionFile.readFile(droneCommunicator);
//        Message message= Message.missionAction(result);

    }
//    void getState() throws Exception{
//        droneCommunicator = new DroneCommunicator();
//        droneCommunicator.getState();
//    }
}
