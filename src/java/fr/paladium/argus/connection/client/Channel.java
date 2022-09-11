package fr.paladium.argus.connection.client;

import fr.paladium.argus.connection.packets.PacketOut;
import java.net.SocketAddress;

public interface Channel {
    public void send(PacketOut var1);

    public void disconnect(String var1);

    public void close();

    public boolean isActive();

    public SocketAddress remoteAddress();
}
