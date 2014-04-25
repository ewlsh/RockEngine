package com.rock.network;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
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
