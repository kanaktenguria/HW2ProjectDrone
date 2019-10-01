package Communicator;

import ReadMissionFile.ReadMissionFile;
import ReadMissionFile.*;
import java.util.Scanner;


public class Main {
    public static void main(String...args)throws Exception{
        Scanner scan = new Scanner(System.in);
        DroneState droneState=new DroneState();
        ReadMissionFile readMissionFile = null;
        System.out.print("Enter the IP address:");
        String IPAddress = scan.next();

        System.out.print("Enter senders port Number:");
        int senderPort = scan.nextInt();
        System.out.println("1. Load mission from CSV file");
        System.out.println("2. Load mission from XML file"); //downuprotate
        System.out.println("3. Execute pre existing mission:");
//        //leftrotateright
        System.out.print("Enter number:");

        int fileType= scan.nextInt();
        Flier flier=new Flier();
        flier.setDroneState(droneState);
        flier.initialize(IPAddress, senderPort);
        Thread thread= new Thread(flier);
        thread.start();
        Thread.sleep(5000);

        if(fileType==1){
            ReadCSV readCSV= new ReadCSV();
            readMissionFile= readCSV;
            flier.readFile(readMissionFile);
        }

        if(fileType==2){
            ReadXML readXML= new ReadXML();
            readMissionFile= readXML;
            flier.readFile(readMissionFile);
        }

        if(fileType==3){
            System.out.println("1. Move Down, Move Up");
            System.out.println("2. Move Forward, Move Left, Move Backward");
            System.out.println("3. Move Left, Move Anti Clockwise, Move Right");
            int missionChoice= scan.nextInt();
            flier.executePreExistingMission(missionChoice);
        }

    }
}