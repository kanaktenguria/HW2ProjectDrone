package ReadMissionFile;
import Common.DroneCommunicator;
import Common.DroneState;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV extends ReadMissionFile {

    @Override
    public void readFile(DroneCommunicator droneCommunicator, DroneState droneState) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/sampledata1.csv"));
        String fileName;
        fileName = br.readLine();
        String[] result = fileName.split(",");
        executeMission(droneCommunicator,result, droneState);
    }
}
