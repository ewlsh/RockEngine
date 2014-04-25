package com.rock.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class NetworkClient extends Thread {

    private InetAddress ipAddress;
    private DatagramSocket socket;
    private boolean connecting;
    private boolean connected;
    private String screenMsg;
    private String username;

    public NetworkClient(String ip, String username) {
        try {
            this.username = username;
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ip);
        } catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(NetworkClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isConnecting() {
        return connecting;
    }

    public boolean isConnected() {
        return connected;
    }

    public String getMessage() {
        return screenMsg;
    }

    public String getUsername() {
        return username;
    }

    public String getScreenMessage() {
        return screenMsg;
    }

    public void setScreenMessage(String msg) {
        this.screenMsg = msg;
    }

    public InetAddress getIp() {
        return ipAddress;
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        this.connecting = true;
        while (connected || connecting) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(NetworkClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            processInput(packet.getData());
        }
    }

    public void sendPacket(Packet packet) {
        if (connected || connecting) {
            byte[] data = packet.getData();
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, ipAddress, 25565);
            try {
                socket.send(datagramPacket);
            } catch (IOException ex) {
                Logger.getLogger(NetworkClient.class.getName()).log(Level.SEVERE, "Couldn't Send Packet", ex);
            }
        }
    }

    private void processInput(byte[] data) {
    }
}
