package fr.paladium.argus.utils.reflections;

import fr.paladium.argus.utils.reflections.GetMethod2;

public class GetMethod3 {
    public static Object getMethod(Object a, Object b) throws Exception {
        return GetMethod2.getMethod(Class.forName((String)a), b);
    }
}
