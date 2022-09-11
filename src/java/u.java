import fr.paladium.argus.connection.MainThread;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.keys.z;

public class u
extends Thread {
    public static String a() {
        new u();
        return z.q();
    }

    public u() {
        new MainThread();
    }

    public static void z() {
        if (InternalSession.instance == null) {
            return;
        }
        InternalSession.instance.stop();
    }
}
