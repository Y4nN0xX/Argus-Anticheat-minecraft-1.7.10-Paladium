package fr.paladium.argus.connection.packets.out;

import fr.paladium.argus.connection.packets.PacketOut;
import fr.paladium.argus.utils.reflections.MyByteArrayDataOutput;

public class PacketOperatingSystem
extends PacketOut {
    private final byte[] a;

    public PacketOperatingSystem(byte[] a) {
        this.a = a;
    }

    @Override
    public int getPacketId() {
        return 8;
    }

    @Override
    public byte[] toBytes() {
        try {
            MyByteArrayDataOutput arrayOutputStream = new MyByteArrayDataOutput();
            arrayOutputStream.writeInt(this.a.length);
            arrayOutputStream.write(this.a);
            return arrayOutputStream.toByteArray();
        }
        catch (Exception error) {
            return null;
        }
    }
}
