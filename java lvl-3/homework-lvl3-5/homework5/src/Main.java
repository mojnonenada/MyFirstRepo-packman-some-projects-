
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,  new Start());
        Semaphore semaphore = new Semaphore(2);
        Car[] cars = new Car[CARS_COUNT];
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(4,  new Finish());
        Semaphore semaphore1 = new Semaphore(1);

        Race race = new Race(new Road(60), new Tunnel(semaphore), new RoadF (40,semaphore1,cyclicBarrier1));

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(cyclicBarrier, race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) { new Thread(car).start();}

    }
}

