public class Main {

    private final static Object mon = new Object();
    private static volatile char currentLetter = 'C';

    public static void main(String[] args) {
        PrintLetterT t1 = new PrintLetterT('C', 'A');
        PrintLetterT t2 = new PrintLetterT('A', 'B');
        PrintLetterT t3 = new PrintLetterT('B', 'C');

        t1.start();
        t2.start();
        t3.start();
    }

    private static class PrintLetterT extends Thread {
        private char first;
        private char second;

        private PrintLetterT(char first, char second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentLetter != first) {
                            mon.wait();
                        }
                        System.out.print(second);
                        currentLetter = second;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}