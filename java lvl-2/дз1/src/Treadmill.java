public class Treadmill extends Obstacle {

    protected int distance;

    public Treadmill(String name, int distance) {
        super(name);
        this.distance = distance;
    }

    public int getDistance(){
        return distance;
    }

    @Override
    boolean action(Human human) {
        human.run();
        if (getDistance() <= human.getMaxRun()) {
            System.out.println("Человек  побежал ");
            return true;
        } else {
            System.out.println("Человек  не побежал");
            return false;
        }
    }

    @Override
    boolean action(Cat cat) {
        cat.run();
        if (getDistance() <= cat.getMaxRun()) {
            System.out.println("Кот побежал ");
            return true;
        } else {
            System.out.println("Кот не побежал");
            return false;
        }
    }

    @Override
    boolean action(Robot robot) {
        robot.run();
        if (getDistance() <= robot.getMaxRun()) {
            System.out.println("Ротбот побежал ");
            return true;
        } else {
            System.out.println("Ротбот не побежал");
            return false;
        }
    }
}
