package fr.paladium.argus.connection.client;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Bytes;
import fr.paladium.argus.connection.client.Channel;
import fr.paladium.argus.connection.client.Connection;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.connection.packets.PacketOut;
import fr.paladium.argus.connection.packets.in.PacketIn;
import fr.paladium.argus.keys.DynamicKeyGetter;
import fr.paladium.argus.keys.KeyUtils;
import java.io.ByteArrayInputStream;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Base64;
import java.util.zip.InflaterInputStream;

public class ClientHandler
implements Connection,
Channel {
    private Channel channel;

    @Override
    public void send(PacketOut packet) {
    }

    @Override
    public void disconnect(String reason) {
    }

    @Override
    public void close() {
    }

    @Override
    public boolean isActive() {
        return this.channel != null && this.channel.isActive();
    }

    @Override
    public SocketAddress remoteAddress() {
        return this.channel.remoteAddress();
    }

    @Override
    public void connected(io.netty.channel.Channel channel) {
    }

    @Override
    public void disconnected(io.netty.channel.Channel channel) {
    }

    @Override
    public void handle(String msg) {
        try {
            byte[] decodedMessage = Base64.getDecoder().decode(msg);
            if (decodedMessage == null) {
                return;
            }
            byte[] dc = KeyUtils.decrypt(DynamicKeyGetter.IiIIiI(), decodedMessage);
            if (dc == null) {
                return;
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(dc);
            InflaterInputStream iis = new InflaterInputStream(bais);
            int rlen = -1;
            byte[] buf1 = new byte[1];
            ArrayList<Byte> bytes = new ArrayList<Byte>();
            while ((rlen = iis.read(buf1)) != -1) {
                bytes.addAll(Bytes.asList(buf1));
            }
            byte[] decoded = Bytes.toArray(bytes);
            ByteArrayDataInput input = ByteStreams.newDataInput(decoded);
            byte mgc = input.readByte();
            if (mgc != 42) {
                return;
            }
            byte id = input.readByte();
            long time = input.readLong();
            short randShort = input.readShort();
            int dataLength = input.readInt();
            if (dataLength < 0 || dataLength >= 65535) {
                return;
            }
            byte[] data = new byte[dataLength];
            input.readFully(data);
            if (InternalSession.instance != null) {
                PacketIn pkt = InternalSession.instance.inPackets.stream().filter(packet -> packet.getPacketId() == id).findFirst().orElse(null);
                if (pkt == null) {
                    return;
                }
                InternalSession.instance.srv.submit(() -> {
                    try {
                        pkt.fromBytes(data);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                });
            }
        }
        catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public void exception(Throwable exception) {
    }
}
