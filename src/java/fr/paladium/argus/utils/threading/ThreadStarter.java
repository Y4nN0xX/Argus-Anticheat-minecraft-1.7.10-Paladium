package fr.paladium.argus.utils.threading;

public class ThreadStarter {
    public static void start(Object o) {
        ((Thread)o).start();
    }
}
