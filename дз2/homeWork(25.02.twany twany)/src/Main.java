import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] balanceMas = {1, 2, 2, 2, 1, 2, 2, 10, 2};
        int[] perestanovkaMas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = -3;
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
        System.out.println();
        task5();
        System.out.println();
        System.out.println(task6(balanceMas));
        System.out.println();
        task7(perestanovkaMas, n);
    }

    public static void task1() {
        int[] mas = {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0};
        for (int i = 0; i < mas.length; i++) {
            switch (mas[i]) {
                case 0:
                    mas[i] = 1;
                    break;
                case 1:
                    mas[i] = 0;
                    break;
            }
            System.out.print(mas[i]);
        }
    }

    public static void task2() {
        int[] mas = new int[8];
        int j = 0;
        for (int i = 0; i < mas.length; i++, j = j + 3) {
            mas[i] = j;
            System.out.print(mas[i] + " ");
        }
    }

    public static void task3() {
        int[] mas2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mas2.length; i++) {
            if (mas2[i] < 6) {
                mas2[i] = mas2[i] * 2;
            }
            System.out.print(mas2[i] + " ");
        }
    }

    public static void task4() {
        final Random random = new Random();
        int tabl[][] = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    tabl[i][j] = 1;
                } else {
                    tabl[i][j] = random.nextInt(10);
                }
                System.out.print(tabl[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void task5() {
        int mas[] = {1, 2, 3, 4, 45, 56, 5, 4, 64, 23, 4, 23, 532, 623, 523, 545, 754, 745, 74, 7};
        int max = mas[0], min = mas[mas.length - 1];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
            }
            if (mas[i] < min) {
                min = mas[i];
            }
        }
        System.out.println("Максимальный эл-т массива: " + max);
        System.out.println("Минимальный эл-т массива: " + min);
    }

    public static boolean task6(int[] mas) {
        int s1, s2, x;
        for (int i = 0; i < mas.length; i++) {
            s1 = 0;
            s2 = 0;
            for (int j = 0; j < i; j++) {
                s1 = s1 + mas[j];
            }
            for (int j = i; j < mas.length; j++) {
                s2 = s2 + mas[j];
            }
            if (s1 == s2) {
                return true;
            }
        }
        return false;
    }

    public static void task7(int[] mas, int n) {
        if (n > 0) {
            for (int j = 0; j < n; j++)
            {
                int b = mas[mas.length - 1];
                System.arraycopy(mas, 0, mas, 1, mas.length - 1);
                mas[0] = b;
            }
            for (int i = 0; i < mas.length; i++)
            {
                System.out.print(mas[i]);
            }
        } else
            {
            for (int j = 0; j > n; j--)
            {
                int b = mas[0];
                System.arraycopy(mas, 1, mas, 0, mas.length - 1);
                mas[mas.length-1] =b;
            }
            for (int i = 0; i < mas.length; i++) {
                System.out.print(mas[i]);
            }
        }
    }
}
