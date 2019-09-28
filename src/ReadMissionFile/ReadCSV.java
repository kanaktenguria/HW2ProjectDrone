package ReadMissionFile;
import Communicator.DroneCommunicator;
import Message.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReadCSV extends ReadMissionFile {

    @Override
    public void readFile(DroneCommunicator droneCommunicator) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/sampledata1.csv"));
        String fileName;
        fileName = br.readLine();
        String[] result = fileName.split(",");
        executeMission(droneCommunicator,result);
    }
}
