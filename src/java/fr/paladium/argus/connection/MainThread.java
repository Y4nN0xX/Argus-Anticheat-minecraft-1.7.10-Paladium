package fr.paladium.argus.connection;

import fr.paladium.argus.connection.NettyClient;
import fr.paladium.argus.connection.login.InternalSession;
import fr.paladium.argus.utils.threading.ThreadStarter;

public class MainThread
extends Thread {
    public static Class<?> thisClass;

    public MainThread() {
        thisClass = this.getClass();
        ThreadStarter.start(this);
    }

    @Override
    public void run() {
        NettyClient nettyClient = new NettyClient();
        InternalSession session = new InternalSession(this, nettyClient);
        session.start();
    }
}
