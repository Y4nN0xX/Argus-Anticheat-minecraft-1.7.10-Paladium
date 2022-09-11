package fr.paladium.argus.checks.id;

import fr.paladium.argus.checks.ACheck;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.connection.packets.out.PacketOutHWID;
import fr.paladium.argus.utils.threading.ThreadStarter;

public class CheckHWID
extends ACheck {
    public CheckHWID(InternalSession session) {
        super(session);
        ThreadStarter.start(this);
    }

    @Override
    public void runCheck(long occurrences) {
        try {
            this.sendPacket(new PacketOutHWID());
        }
        catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public int getRepeatTime() {
        return 270;
    }
}
