package fr.paladium.argus.utils.reflections;

import fr.paladium.argus.utils.reflections.ClassExistsCheck2;

public class ClassExistsCheck {
    public static boolean exists(Object a) throws Exception {
        return ClassExistsCheck2.exists((String)a);
    }
}
