package homeworkTest;

import homework.Method;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)

public class MainTest1 {
    @Parameterized.Parameters
    public static List<int[][]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 2, 4, 4, 2, 3, 4, 1, 7}, {1,7}},
                {{1,4,5,6,7,9,4},{}},
                {{1,4,5}, {5}},
        });
    }

    static Method method;

    private int[] input;
    private int[] output;

    public MainTest1(int[] input, int[] output){
        this.input = input;
        this.output = output;
    }

    @BeforeClass
    public static void globalInit() {
         method = new Method();
    }

        /*
    {1, 2, 4, 4, 2, 3, 4, 1, 7}, {1,7}
    {1,4,5,6,7,9,4}, {}
    {1,4,5}, {5}
         */

    @Test
    public void method1Test1() {
        Assert.assertArrayEquals(output, method.method1(input));
    }

  /*  @Test
    public void method1Test2() {
        Assert.assertArrayEquals(new int[]{}, method.method1(new int[]{1,4,5,6,7,9,4}));
    }

    @Test
    public void method1Test3() {
        Assert.assertArrayEquals(new int[]{5}, method.method1(new int[] {1,4,5}));
    }
   */
}
