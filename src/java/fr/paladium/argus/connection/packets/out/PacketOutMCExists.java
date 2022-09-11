package fr.paladium.argus.connection.packets.out;

import fr.paladium.argus.connection.packets.PacketOut;
import fr.paladium.argus.utils.reflections.MyByteArrayDataOutput;

public class PacketOutMCExists
extends PacketOut {
    @Override
    public int getPacketId() {
        return 11;
    }

    @Override
    public byte[] toBytes() {
        try {
            MyByteArrayDataOutput arrayOutputStream = new MyByteArrayDataOutput();
            arrayOutputStream.write(99);
            return arrayOutputStream.toByteArray();
        }
        catch (Exception error) {
            return null;
        }
    }
}
