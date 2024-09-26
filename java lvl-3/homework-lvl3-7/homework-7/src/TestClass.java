import java.lang.reflect.Method;
import java.util.TreeMap;

public class TestClass {

    private static boolean isA_B_AnnotationsCorrect(Class<?> name) {
        int b = 0;
        int a = 0;
        for (Method m:name.getDeclaredMethods()) {
            if (m.getAnnotation(BeforeSuite.class) != null) b++;
            if (m.getAnnotation(AfterSuite.class) != null)  a++;
        }
        return (a<2) && (b<2);
    }

    private static void start (Class<?> name) {
         if (!isA_B_AnnotationsCorrect(name)){ throw new RuntimeException();}
         final int counter_MIN = 1;
         final int counter_MAX = 10;
         TreeMap<Integer, Method> map = new TreeMap<>();
         for (Method m : name.getDeclaredMethods()) {
             if (m.getAnnotation(BeforeSuite.class) != null) map.put(counter_MIN - 1, m);
             if (m.getAnnotation(AfterSuite.class) != null) map.put(counter_MAX + 1, m);
             if (m.getAnnotation(Test.class) != null) {
                 Test test = m.getAnnotation(Test.class);
                 map.put(test.priority(), m);
             }
         }

         try {
             Tests tests = new Tests();
             for (Integer key: map.keySet()) {map.get(key).invoke(tests);}
         } catch (Exception e){ e.printStackTrace();}
     }

    public static void main(String[] args) {
        start(Tests.class);
    }
}
