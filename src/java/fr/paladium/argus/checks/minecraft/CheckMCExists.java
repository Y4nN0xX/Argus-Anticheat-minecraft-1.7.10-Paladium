package fr.paladium.argus.checks.minecraft;

import fr.paladium.argus.checks.ACheck;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.connection.packets.out.PacketOutMCExists;
import fr.paladium.argus.utils.threading.ThreadStarter;
import java.lang.reflect.Method;

public class CheckMCExists
extends ACheck {
    public CheckMCExists(InternalSession session) {
        super(session);
        ThreadStarter.start(this);
    }

    @Override
    public void runCheck(long occurrences) {
        if (!this.isInMinecraft()) {
            this.sendPacket(new PacketOutMCExists());
        }
    }

    private boolean isInMinecraft() {
        try {
            Class<?> cz = Class.forName("net.minecraft.client.Minecraft");
            Method method = cz.getDeclaredMethod("func_71410_x", new Class[0]);
            method.setAccessible(true);
            return true;
        }
        catch (Exception error) {
            return false;
        }
    }

    @Override
    public int getRepeatTime() {
        return 933;
    }
}
