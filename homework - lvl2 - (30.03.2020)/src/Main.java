
public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] mas = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "c", "11", "12"},
                {"-10", "-6", "-4", "-1"}};

            if (mas.length != 4) {
                throw new  MyArraySizeException();
            }
            int rez = sum(mas);
        System.out.println("Результат расчета: " + rez);
        }

    private static int sum(String[][] mas ) throws MyArrayDataException {
        int result=0;
        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas.length ; j++) {
                    try{
                        result = result + Integer.parseInt(mas[i][j]);
                    } catch (RuntimeException e) {
                        throw new  MyArrayDataException(i,j);
                    }
            }
        }
            return result;
    }
}
