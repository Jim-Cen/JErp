package jim.pers.jerp.utils;

import java.lang.reflect.Method;
import java.util.Map;

public  final class PojoToMap {
     public static void Convert(Object obj,Map hashMap){
         try {
             Class c = obj.getClass();
             Method m[] = c.getDeclaredMethods();
             for (int i = 0; i < m.length; i++) {
                 if (m[i].getName().startsWith("get")) {
                     String name = m[i].getName();
                     hashMap.put(name.substring(3,4).toLowerCase()+name.substring(4), m[i].invoke(obj, new Object[0]));
                 }
             }
         } catch (Throwable e) {
         }
     }
}
