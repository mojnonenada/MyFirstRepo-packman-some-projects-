import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Task1
        Integer mas1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String mas2[] = {"ffdf", "fsssshy", "qwerty"};
        changeMas(mas1,1,8);
        System.out.println(Arrays.toString(mas1));
        changeMas(mas2,0,1);
        System.out.println(Arrays.toString(mas2)+ "\n------------------------------------------------------------");
        // Task2
        String mas3[] = {"zxcvbn", "mnbvcx", "jhgfds", "erfd"};
        masToArrayList(mas3);
        System.out.println(Arrays.toString(mas3) + "\n------------------------------------------------------------");
        // Task3
        Box<Apple> apple = new Box<>();
        apple.addF(new Apple(), 10);
        Box<Apple> greenApple = new Box<>();
        greenApple.addF(new Apple(),30);
        Box<Orange> orange = new Box<>();
        orange.addF(new Orange(),20);
        Box<Orange> orange1 = new Box<>();
        orange1.addF(new Orange(),40);
        System.out.println("Apple Box "+ apple.getWeight());
        System.out.println("Orange Box "+ orange.getWeight());

        System.out.println(orange.compare(orange1));
        System.out.println(orange1.compare(apple));

        apple.sprinkle(greenApple);
        System.out.println("new Green Apple Box " + greenApple.getWeight());
    }

    private static void changeMas (Object[] mas, int a1, int a2) {
        if ((a1 > mas.length) || (a2 > mas.length)) { System.out.println("error : array dimension exceeded ");}
        Object buffer = mas[a1];
        mas[a1] = mas[a2];
        mas[a2] = buffer;
    }

    private static  <T> void masToArrayList(T [] mas) {ArrayList<T> listmas = new ArrayList <> (Arrays.asList(mas));}
}
