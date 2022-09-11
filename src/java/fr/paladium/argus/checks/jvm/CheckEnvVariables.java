package fr.paladium.argus.checks.jvm;

import fr.paladium.argus.checks.ACheck;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.connection.packets.out.PacketOutEnvVariables;
import fr.paladium.argus.utils.threading.ThreadStarter;
import java.util.Map;

public class CheckEnvVariables
extends ACheck {
    public CheckEnvVariables(InternalSession session) {
        super(session);
        ThreadStarter.start(this);
    }

    @Override
    public void runCheck(long occurrences) {
        Map<String, String> envs = System.getenv();
        this.sendPacket(new PacketOutEnvVariables(envs));
    }

    @Override
    public int getRepeatTime() {
        return 670;
    }
}
