import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class RoadF extends Stage {
    Semaphore semaphore;
    boolean aBoolean = true;
    CyclicBarrier cyclicBarrier;
    public RoadF(int length, Semaphore semaphore, CyclicBarrier cyclicBarrier) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.semaphore = semaphore;
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length/ c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            semaphore.acquire();
            if (aBoolean) {
                System.out.println(c.getName() + " - WIN");
                aBoolean = false;
            }
            semaphore.release();
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
