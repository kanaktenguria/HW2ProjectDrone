package Common;

//import Flyer.DroneCommSecretCommandThread;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class DroneCommunicatorTest {

    @Test
    public void testSendReceiveAndGetterSetter() throws Exception {
        DroneCommunicator sender= new DroneCommunicator("127.0.0.1",9090);
        DroneCommunicator receiver= new DroneCommunicator(9090);
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
        String message= "hi";
        sender.sendRequest(message);
        assertEquals(receiver.receiveRequest(),message);
        assertEquals(9090,sender.getDestinationPort());
        assertEquals(IPAddress,receiver.getSenderAddress());
    }

    @Test
    public void testDroneCommunicatorSendCommandToMockServer() throws InterruptedException {
        Thread droneThread = new Thread(new CommandSender());
        Thread serverThread = new Thread(new ServerThread());
        droneThread.start();
        Thread.sleep(3000);
        serverThread.start();
    }

//    @Test
//    public void testInitialize() throws Exception {
//        DroneCommunicator commandReceiver= new DroneCommunicator(10000);
//        DroneCommunicator commandSender= new DroneCommunicator("127.0.0.1",10000);
//        commandReceiver.sendRequest("ok");
//        commandSender.initialize();
//        assertEquals("command",commandReceiver.receiveRequest());
//    }

}

class MockServer {
    public void run() throws SocketException {
        byte[] bytesReceived = new byte[64];
        byte[] bytesToSend;
        DatagramSocket server = new DatagramSocket(9099);
        DatagramPacket receivePacket = new DatagramPacket(bytesReceived, bytesReceived.length);
        try {
            assert server != null;
            server.receive(receivePacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

        InetAddress ipAddress = receivePacket.getAddress();
        if (message.equals("command")){
            System.out.println("Command message received.");
            bytesToSend = "ok".getBytes(StandardCharsets.UTF_8);
        }
        else {
            System.out.println("Command message not received");
            bytesToSend = "error".getBytes(StandardCharsets.UTF_8);
        }
        DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, ipAddress, receivePacket.getPort());
        try {
            server.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ok or error sent.");
//        server.close();
    }

}

class ServerThread implements Runnable {
    @Override
    public void run() {
        MockServer server = new MockServer();
        try {
            server.run();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}

class CommandSender implements Runnable {
    @Override
    public void run() {
        String ipAddress = "127.0.0.1";
        int port = 9099;

        DroneCommunicator droneComm = null;
        try {
            droneComm = new DroneCommunicator(ipAddress, port);
            droneComm.sendRequest("command");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}