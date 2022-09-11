package fr.paladium.argus.checks.id;

import fr.paladium.argus.checks.ACheck;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.connection.packets.out.PacketOutUsername;
import fr.paladium.argus.utils.threading.ThreadStarter;

public class CheckUsername
extends ACheck {
    public CheckUsername(InternalSession session) {
        super(session);
        ThreadStarter.start(this);
    }

    @Override
    public void runCheck(long occurrences) {
        String us = System.getProperty("user.name", "__NOTSET__");
        try {
            this.sendPacket(new PacketOutUsername(us));
        }
        catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public int getRepeatTime() {
        return 219;
    }
}
