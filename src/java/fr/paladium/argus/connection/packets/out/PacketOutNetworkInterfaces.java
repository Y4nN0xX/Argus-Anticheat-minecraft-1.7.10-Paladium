package fr.paladium.argus.connection.packets.out;

import fr.paladium.argus.connection.packets.PacketOut;
import fr.paladium.argus.utils.reflections.MyByteArrayDataOutput;

public class PacketOutNetworkInterfaces
extends PacketOut {
    private final byte[] a;

    public PacketOutNetworkInterfaces(byte[] a) {
        this.a = a;
    }

    @Override
    public int getPacketId() {
        return 48;
    }

    @Override
    public byte[] toBytes() {
        if (this.a == null) {
            return null;
        }
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
