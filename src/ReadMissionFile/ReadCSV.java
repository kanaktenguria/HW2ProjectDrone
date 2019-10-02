package ReadMissionFile;
import Common.DroneCommunicator;
import Common.DroneState;
import Message.Message;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV extends ReadMissionFile {

    @Override
    public void readFile(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
//        Message message = null;
        BufferedReader br = new BufferedReader(new FileReader("src/sampledata1.csv"));
        String fileName;
        fileName = br.readLine();
        String[] result = fileName.split(",");
        Message actionArray[]=executeMission(droneCommunicator,result, droneState);
        for (int i = 0; i < result.length; i++){
            actionArray[i].doAction(droneCommunicator,droneState);
        }
    }
}
