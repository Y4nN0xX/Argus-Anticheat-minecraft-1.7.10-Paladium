package fr.paladium.argus.checks.jvm;

import fr.paladium.argus.checks.ACheck;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.connection.packets.out.PacketOutCheckDLL;
import fr.paladium.argus.utils.reflections.GetClassFromName;
import fr.paladium.argus.utils.reflections.GetMethod;
import fr.paladium.argus.utils.reflections.InvokeMethod;
import fr.paladium.argus.utils.threading.ThreadStarter;
import java.nio.charset.StandardCharsets;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class CheckDynamicLibs
extends ACheck {
    public CheckDynamicLibs(InternalSession session) {
        super(session);
        ThreadStarter.start(this);
    }

    @Override
    public void runCheck(long occurrences) {
        try {
            this.sendPacket(new PacketOutCheckDLL(this.a()));
        }
        catch (Exception error) {
            error.printStackTrace();
        }
    }

    @Override
    public int getRepeatTime() {
        return 391;
    }

    public byte[] a() {
        try {
            String c = "javax.management.ObjectName";
            Object _a = GetClassFromName.fromName(c);
            ObjectName diagnosticsCommandName = (ObjectName)((Class)_a).getConstructor(String.class).newInstance("com.sun.management:type=DiagnosticCommand");
            String operationName = "vmDynlibs";
            Object managementFactoryClass = GetClassFromName.fromName("java.lang.management.ManagementFactory");
            Object mth = GetMethod.getMethod(managementFactoryClass, "getPlatformMBeanServer");
            Object mbnServer = InvokeMethod.invk(mth, null, new Object[0]);
            return ((String)((MBeanServer)mbnServer).invoke(diagnosticsCommandName, operationName, null, null)).getBytes(StandardCharsets.UTF_8);
        }
        catch (Exception exception) {
            return null;
        }
    }
}
