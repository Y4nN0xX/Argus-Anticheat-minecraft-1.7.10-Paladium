package fr.paladium.argus.utils.reflections;

import fr.paladium.argus.utils.reflections.InvokeMethod2;

public class InvokeMethod {
    public static Object invk(Object meth, Object a, Object ... b) throws Exception {
        return InvokeMethod2.invk(meth, a, b);
    }
}
