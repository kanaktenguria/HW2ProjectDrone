package ReadMissionFile;

import Communicator.DroneCommunicator;
import Message.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class ReadMissionFile {
    public abstract void readFile(DroneCommunicator droneCommunicator) throws Exception;

    public void executeMission(DroneCommunicator droneCommunicator, String[] result) throws Exception {
        Message message;
        Scanner scan= new Scanner(System.in);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            if (result[i].equals("takeoff")) {
                message = new TakeOff();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("cw")) {
                System.out.print("Rotate x degrees clockwise. Enter x=");
                int x= scan.nextInt();

                message = new RotateClockWise();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("ccw")) {
                message = new RotateAntiClockWise();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("up")) {
                message = new MoveUp();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("right")) {
                message = new MoveRight();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("left")) {
                message = new MoveLeft();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("forward")) {
                message = new MoveForward();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("down")) {
                message = new MoveDown();
                message.doAction(droneCommunicator);
            }
            if (result[i].equals("back")) {
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
