//package Flyer;
//
//import org.junit.jupiter.api.Test;
//
//import java.net.InetAddress;
//
//class DroneCommunicatorTest {
//    @Test
//    public void testDroneCommunicatorSetUpIpAddressFailure(){
//        String ipAddress = "hi";
//        int port = 8889;
//        DatagramSocket udpClient = null;
//        try {
//            udpClient = new DatagramSocket();
//            udpClient.setSoTimeout(15000);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//
//        DroneCommunicator droneComm = new DroneCommunicator(ipAddress, port, udpClient);
//    }
//
//    @Test
//    public void testDroneCommunicatorSetUpAndSendNull(){
//        String ipAddress = "127.0.0.1";
//        int port = 8888;
//        DatagramSocket udpClient = null;
//        try {
//            udpClient = new DatagramSocket();
//            udpClient.setSoTimeout(15000);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//
//        DroneCommunicator droneComm = new DroneCommunicator(ipAddress, port, udpClient);
//        droneComm.sendMessage(null);
//    }
//
//    @Test
//    public void testDroneCommunicatorSetUpAndSendCommandToDummyServer(){
//        Thread droneThread = new Thread(new DroneCommCommandThread());
//        Thread serverThread = new Thread(new ServerThread());
//        serverThread.start();
//        droneThread.start();
//
//        try {
//            serverThread.join();
//            droneThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testDroneCommunicatorSetUpAndSendSecretCommandToDummyServer(){
//        Thread droneThread = new Thread(new DroneCommSecretCommandThread());
//        Thread serverThread = new Thread(new ServerThread());
//        serverThread.start();
//        droneThread.start();
//
//        try {
//            serverThread.join();
//            droneThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testDroneCommunicatorSetUpAndSendTakeoffCommandToDummyServer(){
//        Thread droneThread = new Thread(new DroneCommTakeoffThread());
//        Thread serverThread = new Thread(new ServerThread());
//        serverThread.start();
//        droneThread.start();
//
//        try {
//            serverThread.join();
//            droneThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
////This class keeps messages from being sent in order to test the Mission class easily
//class DummyDroneCommunicator extends DroneCommunicator{
//
//    DummyDroneCommunicator(String ipAddress, int port, DatagramSocket udpClient) {
//        super(ipAddress, port, udpClient);
//    }
//
//    @Override
//    void sendMessage(Message message) {
//    }
//}
//
////This class implements a server that responds to the drone communicator
//class DummyServer {
//    DummyServer() {
//    }
//
//    void run(int port) {
//
//        DatagramSocket server = null;
//        try {
//            server = new DatagramSocket(port);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//
//        byte[] bytesReceived = new byte[64];
//        byte[] bytesToSend;
//
//        DatagramPacket receivePacket = new DatagramPacket(bytesReceived, bytesReceived.length);
//        try {
//            assert server != null;
//            server.receive(receivePacket);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
//
//        InetAddress ipAddress = receivePacket.getAddress();
//        if (message.equals("command")){
//            System.out.println("I received a command message");
//            bytesToSend = "ok".getBytes(StandardCharsets.UTF_8);
//        }
//        else {
//            System.out.println("I received something that wasn't a command message");
//            bytesToSend = "error".getBytes(StandardCharsets.UTF_8);
//        }
//        DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, ipAddress, receivePacket.getPort());
//        try {
//            server.send(sendPacket);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("I sent my ok/error back");
//        server.close();
//    }
//}
//
////This class allows a single thread to have the drone communicator send a command message to the dummy server
//class DroneCommCommandThread implements Runnable {
//    @Override
//    public void run() {
//        String ipAddress = "127.0.0.1";
//        int port = 8888;
//        DatagramSocket udpClient = null;
//        try {
//            udpClient = new DatagramSocket();
//            udpClient.setSoTimeout(15000);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//
//        DroneCommunicator droneComm = new DroneCommunicator(ipAddress, port, udpClient);
//        droneComm.sendMessage(new CommandMessage());
//    }
//}
//
////This class allows a single thread to have the drone communicator send a secret command message to the dummy server
//public class DroneCommSecretCommandThread implements Runnable {
//    @Override
//    public void run() {
//        String ipAddress = "127.0.0.1";
//        int port = 8888;
//        DatagramSocket udpClient = null;
//        try {
//            udpClient = new DatagramSocket();
//            udpClient.setSoTimeout(15000);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//
//        DroneCommunicator droneComm = new DroneCommunicator(ipAddress, port, udpClient);
//        droneComm.sendMessage(new SecretCommandMessage());
//    }
//}
//
////This class allows a single thread to have the drone communicator send a takeoff message to the dummy server
//class DroneCommTakeoffThread implements Runnable {
//    @Override
//    public void run() {
//        String ipAddress = "127.0.0.1";
//        int port = 8888;
//        DatagramSocket udpClient = null;
//        try {
//            udpClient = new DatagramSocket();
//            udpClient.setSoTimeout(15000);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//
//        DroneCommunicator droneComm = new DroneCommunicator(ipAddress, port, udpClient);
//        droneComm.sendMessage(new TakeoffMessage());
//    }
//}
//
////This class allows a single thread to start up the server so that it may receive messages while another send it
//class ServerThread implements Runnable {
//    @Override
//    public void run() {
//        DummyServer server = new DummyServer();
//        server.run(8888);
//    }
////    DroneCommunicator droneCommunicator;
////
////    @Test
////    public void TestSocketConstructor() throws Exception {
////        droneCommunicator = new DroneCommunicator("127.0.0.1",8889);
////        assertEquals(InetAddress.getByName("127.0.0.1"), droneCommunicator.getDroneAddress());
//////        droneCommunicator.close();
////    }
////    @Test
////    public void TestSendAndReceiveMethod() throws Exception {
////        droneCommunicator = new DroneCommunicator("127.0.0.1",8889);
////        droneCommunicator.sendRequest("command");
////        droneCommunicator.receiveRequest();
////        assertEquals("ok", droneCommunicator.receiveRequest());
////    }
//}