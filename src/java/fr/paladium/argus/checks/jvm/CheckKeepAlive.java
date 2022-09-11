package fr.paladium.argus.checks.jvm;

import fr.paladium.argus.checks.ACheck;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.connection.packets.out.PacketOutKeepAlive;
import fr.paladium.argus.utils.NetworkKey;
import fr.paladium.argus.utils.threading.ThreadStarter;

public class CheckKeepAlive
extends ACheck {
    public CheckKeepAlive(InternalSession session) {
        super(session);
        ThreadStarter.start(this);
    }

    @Override
    public void runCheck(long occurrences) {
        InternalSession session = this.getSession();
        NetworkKey networkKey = session.networkKey;
        networkKey.generateKeepAliveKey();
        this.sendPacket(new PacketOutKeepAlive(networkKey.getKeepAliveKey()));
    }

    @Override
    public int getRepeatTime() {
        return 8;
    }
}
