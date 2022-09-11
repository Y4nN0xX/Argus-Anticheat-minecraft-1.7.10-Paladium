package fr.paladium.argus.utils.reflections;

public class ClassExistsCheck2 {
    public static boolean exists(String a) throws Exception {
        try {
            Class.forName(a);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
