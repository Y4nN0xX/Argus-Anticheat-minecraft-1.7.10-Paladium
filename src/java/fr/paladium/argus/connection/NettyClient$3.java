package fr.paladium.argus.connection;

import java.util.TimerTask;

class NettyClient$3
extends TimerTask {
    NettyClient$3() {
    }

    @Override
    public void run() {
        try {
            NettyClient.this.connect();
        }
        catch (Exception error) {
            error.printStackTrace();
        }
    }
}
