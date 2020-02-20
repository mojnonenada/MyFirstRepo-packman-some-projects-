import java.net.SocketTimeoutException;

public class Main {

    public static void main(String[] args)
    {
        byte p = 1;
        short s = 2;
        int i = 10;
        long l = 1000000;
        float f = 700.53f;
        double du = 123.222;
        char ch = '@';
        boolean bool = false;
        //вывод методов
        System.out.println(task3(1,1,1,1));
        System.out.println(task4(5,7));
        task5(16);
        System.out.println(task6(-100));
        task7("Артур");
        task8(2020);
    }

    public static int task3(int a, int b, int c, int d)
    {
        return a * (b + (c / d));
    }

    public static boolean task4(int a1, int a2)
    {
        if ((a1 + a2 >= 10) && (a1 + a2 <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void task5(int x)
    {
        if (x >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean task6(int x1) {

        if (x1 < 0) {
            return true;
        }
        return false;
    }

    public static void task7 (String name )
    {
            System.out.println("Привет, " + name);
    }

    public static void task8 (int year)
    {
        if ((year % 400 ==0) || ((year % 4 == 0) && (year % 100 !=0 ))) {
            System.out.println("Год високосный");} else
                {
                    System.out.println("Год невисокосный");

                }
    }

}




