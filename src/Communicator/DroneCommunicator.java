package Communicator;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DroneCommunicator {
    private int dronePort;
    private InetAddress droneAddress;
    DatagramSocket udpClient;
//    private DatagramPacket datagramPacket;
//    String request= null;
    private String reply = null;
    private String iPAddress;


    public DroneCommunicator(String iPAddress, int dronePort){
        this.iPAddress= iPAddress;
        this.dronePort= dronePort;
    }

    public void getState() throws IOException {
//        byte[] bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        InetAddress stateDroneAddress = InetAddress.getByName("0.0.0.0");
        int udpStatePort= 8890;
//        byte[] bytesToSent= new byte[256];
//        DatagramPacket datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, stateDroneAddress, udpStatePort);
//        udpClient.send(datagramPacket);
//        System.out.println("Sent " + request + " bytes to Drone");
        DatagramSocket socket= new DatagramSocket(8890);

        byte[] bytesReceived = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytesReceived, 64, stateDroneAddress, udpStatePort);
        try {
            socket.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println(reply + " received.");
        }
        System.out.print(reply);
//        return reply;
//        byte[] buf= new byte[256];
//        DatagramSocket socket= new DatagramSocket(8890);
//        DatagramPacket packet
//                = new DatagramPacket(buf, buf.length);
//        socket.receive(packet);
//
//        InetAddress address = InetAddress.getByName("0.0.0.0");
//        int port = packet.getPort();
//        packet = new DatagramPacket(buf, buf.length, address, port);
//        String received
//                = new String(packet.getData(), 0, packet.getLength());
//        System.out.print("KANAK");
//        System.out.print(received+"Kanak");
    }
    public void initialize() throws Exception {
        udpClient =  new DatagramSocket();
        droneAddress = InetAddress.getByName(iPAddress);
        udpClient.setSoTimeout(1000);
        int maxRetries = 3;
        while (maxRetries > 0){
        sendRequest("command");
        String reply= receiveRequest();
            if (reply.equals("ok")) {
                System.out.println("Entering command mode.. \nSending mission commands.");
                break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
    }
    public int getLocalPort(){
        return udpClient.getLocalPort();
    }

    public void sendRequest(String request) throws Exception{
        byte[] bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, droneAddress, dronePort);
        udpClient.send(datagramPacket);
        System.out.println("Sent " + request + " bytes to Drone"); // with address " + droneAddress.toString() + ":" + dronePort);
    }

    public String receiveRequest() throws Exception{
        byte[] bytesReceived = new byte[64];
        DatagramPacket datagramPacket = new DatagramPacket(bytesReceived, 64);
        try {
            udpClient.receive(datagramPacket);
        }
        catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
//            System.out.println(String.format("Received %d bytes", datagramPacket.getLength()));
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
            System.out.println(reply + " received.");
        }
        return reply;
    }

    public InetAddress getDroneAddress() {
        return droneAddress;
    }
}

