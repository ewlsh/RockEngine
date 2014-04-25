/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rock.network;

/**
 *
 * @author evan
 */
public abstract class Packet {

    public byte packetId;

    public Packet(int packedId) {
        this.packetId = (byte) packetId;
    }

    public abstract byte[] getData();

    public String readData(byte[] data) {
        String message = new String(data).trim();
        return message.substring(2);
    }
}
