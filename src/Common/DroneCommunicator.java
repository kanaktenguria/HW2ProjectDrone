package Common;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DroneCommunicator {

    private InetAddress IPAddress;
    DatagramSocket udpClient;
    private InetAddress senderAddress;
    private int destinationPort;
    private byte[] bytesReceived;
    private String reply;
    private String iPAddress;

    public DroneCommunicator(String iPAddress, int destinationPort) throws SocketException, UnknownHostException {
        this.iPAddress = iPAddress;
        this.destinationPort = destinationPort;
        this.udpClient = new DatagramSocket();
        IPAddress = InetAddress.getByName(iPAddress);
        udpClient.setSoTimeout(1000);
    }

    public DroneCommunicator(int port) throws SocketException {
        udpClient = new DatagramSocket(port);
    }

    public void initialize() throws Exception {


        int maxRetries = 3;
        while (maxRetries > 0) {
            sendRequest("command");
            String reply = receiveRequest();
            if (reply.equals("ok")) {
                System.out.println("Entering command mode.. \nSending mission commands.");
                break;
            }
            System.out.println("Remaining retries: " + maxRetries);
            maxRetries--;
        }
    }

    public void sendRequest(String request) throws Exception {
        byte[] bytesToSent = request.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytesToSent, bytesToSent.length, IPAddress, destinationPort);
        udpClient.send(datagramPacket);
    }

    public String receiveRequest() throws Exception {
        this.bytesReceived = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytesReceived, 1024);
        try {
            udpClient.receive(datagramPacket);
            this.senderAddress = datagramPacket.getAddress();
            this.destinationPort = datagramPacket.getPort();
        } catch (SocketTimeoutException ex) {
            datagramPacket = null;
        }
        if (datagramPacket != null) {
            reply = new String(bytesReceived, 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
        }
        return reply;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public InetAddress getSenderAddress() {
        return senderAddress;
    }

    public void setAddress(InetAddress senderAddress, int senderPort) {
        this.IPAddress = senderAddress;
        this.destinationPort = senderPort;
    }

}