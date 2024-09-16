package homeworkTest;

import homework.Method;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest2 {

    private static Method method;

    @BeforeClass
    public static void globalInit() {
        method = new Method();
    }

    @Test
    public void method1Test1() {
        Assert.assertTrue(method.method2(new int[]{1,2,3,4,5,6,8}));
    }

    @Test
    public void method1Test2() {
        Assert.assertFalse(method.method2(new int[]{0,2,3,0,5,6,8}));
    }

    @Test
    public void method1Test3() {
        Assert.assertFalse(method.method2(new int[]{2,2,3,0,5,6,8}));
    }
}
