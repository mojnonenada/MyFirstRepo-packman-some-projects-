import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
            byte count = 0;
            int ch = random.nextInt(10);
            while (count < 3) {
                System.out.println("Введи число ");
                int chUser = sc.nextInt();
                if (chUser == ch) {
                    System.out.println("Победа");
                    break;
                } else if (chUser < ch) {
                    System.out.println("Больше");
                    count++;
                } else if (chUser > ch) {
                    System.out.println("Меньше");
                    count++;
                }
                if (count == 3) {
                    System.out.println("Проигрыш ");
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            System.out.println("Загаданное число было " + ch);
        } while (sc.nextByte() != 0);
        sc.close();
    }
}








