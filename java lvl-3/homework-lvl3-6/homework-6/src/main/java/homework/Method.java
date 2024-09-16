package homework;


import java.util.Arrays;

public class Method {


    public static int[] method1(int[] mas) {
        int pos = -1;
              for (int i = 0; i < mas.length ; i++) {
                  if (mas[i] == 4 ) { pos = i;}
        }
              if (pos ==-1 ){ throw new RuntimeException() ;}
        return Arrays.copyOfRange(mas,pos +1, mas.length);
    }

    public static boolean method2 (int[] mas){
        for (int ma : mas) {
            if (ma == 1 || ma == 4) {
                return true;
            }
        }
        return false;
    }

}
