package fr.paladium.argus.connection.packets.in;

public abstract class PacketIn {
    public abstract int getPacketId();

    public abstract void fromBytes(byte[] var1);
}
