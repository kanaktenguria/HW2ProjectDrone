package ReadMissionFile;

import Communicator.DroneCommunicator;
import Message.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ReadMissionFile {
    public abstract void readFile(DroneCommunicator droneCommunicator) throws Exception;

    public void executeMission(DroneCommunicator droneCommunicator, String[] result) throws Exception {
        Message message;
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            if (result[i].equals("takeoff")) {
                message = new TakeOff();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("cw 360")) {
                message = new RotateClockWise();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("ccw 360")) {
                message = new RotateAntiClockWise();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("up 50")) {
                message = new MoveUp();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("right 50")) {
                message = new MoveRight();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("left 50")) {
                message = new MoveLeft();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("forward 50")) {
                message = new MoveForward();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("down 50")) {
                message = new MoveDown();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("back 50")) {
                message = new MoveBackward();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("land")) {
                message = new Land();
                message.doAction(droneCommunicator);
            }
        }
    }

}
