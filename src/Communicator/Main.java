package Communicator;

import FlyBehaviour.FlyBehaviour;
import FlyBehaviour.MissionDownUpRotate;
import FlyBehaviour.MissionForwardLeft;
import FlyBehaviour.MissionLeftRotateRight;
import ReadMissionFile.ReadMissionFile;
import ReadMissionFile.*;

import javax.swing.*;
import java.util.Scanner;


public class Main {
    public static void main(String...args)throws Exception{
        Scanner scan = new Scanner(System.in);
        FlyBehaviour flyBehaviour=null;
        ReadMissionFile readMissionFile = null;
        System.out.print("Enter the IP address:");
        String iPAddress = scan.next();

        System.out.print("Enter Port Number:");
        int dronePort = scan.nextInt();
        int udpStatePort= 8890;
        String stateIPAddress="0.0.0.0";
//        final JFileChooser fc = new JFileChooser();
//        int returnVal = fc.showOpenDialog();
//        System.out.println("");
        System.out.println("1. Load mission from CSV file");
        System.out.println("2. Load mission from XML file"); //downuprotate
        System.out.println("3. Execute your own mission");
//        System.out.println("3. Take off, Move Left, Move 360 Anti Clockwise, Move Right, Land"); //leftrotateright
        System.out.print("Enter number:");
        int fileType= scan.nextInt();
////        ArrayList<FlyBehaviour> missionArray = new ArrayList<FlyBehaviour>();
////        for(int i=0; ){
////
////        }
        if(fileType==1){
//            MissionForwardLeft missionForwardLeft=new MissionForwardLeft();
            ReadCSV readCSV= new ReadCSV();
            readMissionFile= readCSV;
        }

        if(fileType==2){
            ReadXML readXML= new ReadXML();
            readMissionFile= readXML;
//            MissionDownUpRotate missionDownUpRotate=new MissionDownUpRotate();
//            flyBehaviour= missionDownUpRotate;
        }
        if(fileType==3){
            
        }
//
//        if(missionNumber==3){
//            MissionLeftRotateRight missionLeftRotateRight=new MissionLeftRotateRight();
//            flyBehaviour= missionLeftRotateRight;
//        }

        Flier flier=new Flier();
        flier.initialize(iPAddress, dronePort);
//        flier.doMission(flyBehaviour);
        flier.readFile(readMissionFile);
//        flier.getState();
    }
}