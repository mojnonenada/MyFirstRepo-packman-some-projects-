public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        System.out.println("В ячейке [ " + (i+1) + " , " + (j+1) + " ] лежат неверные данные" );
    }
}
