package Communicator;
import FlyBehaviour.FlyBehaviour;
//import ReadMissionFile.ReadFileTemplate;
import ReadMissionFile.ReadMissionFile;

import java.io.IOException;

class Flier implements Runnable{
    private DroneCommunicator droneCommunicator;



    public void initialize(String IPAddress, int senderPort) throws Exception {
        droneCommunicator = new DroneCommunicator(IPAddress, senderPort);
        droneCommunicator.initialize();  }

//    void doMission(FlyBehaviour flyBehaviour) throws Exception {
//        flyBehaviour.doMission(droneCommunicator);
//    }

    void readFile(ReadMissionFile readMissionFile) throws Exception {
        readMissionFile.readFile(droneCommunicator);
//        Message message= Message.missionAction(result);

    }
//
    @Override
    public void run() {
    try {
            droneCommunicator.getState();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
//    void getState() throws Exception{
//
//    }
}
