package com.rock.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class NetworkServer extends Thread {

    private DatagramSocket socket;

    public NetworkServer(int port) {
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException ex) {
            Logger.getLogger(NetworkServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(NetworkServer.class.getName()).log(Level.SEVERE, "Couldn't Retrieve Packet", ex);
            }
            processInput(packet.getData(), packet.getAddress(), packet.getPort());
        }
    }

    private void processInput(byte[] data, InetAddress ipAddress, int port) {
    }

    public void sendData(Packet packet, InetAddress ipAddress, int port) {
        byte[] data = packet.getData();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, ipAddress, port);
        try {
            socket.send(datagramPacket);
        } catch (IOException ex) {
            Logger.getLogger(NetworkServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
