public class Wall extends Obstacle {

    protected int height;

    public Wall(String name,int height) {
        super(name);
        this.height = height;
    }

    public int getHeigth(){
        return height;
    }

    @Override
    boolean action(Human human) {
        human.jump();
        if (getHeigth() <= human.getMaxJump()) {
            System.out.println("Человек прыгнул ");
            return true;
        } else {
            System.out.println("Человек не прыгнул");
            return false;
        }
    }

    @Override
    boolean action(Cat cat) {
        cat.jump();
        if (getHeigth() <= cat.getMaxJump()) {
            System.out.println("Кот прыгнул ");
            return true;
        } else {
            System.out.println("Кот не прыгнул");
            return false;
        }
    }

    @Override
    boolean action(Robot robot) {
        robot.jump();
        if (getHeigth() <= robot.getMaxJump()) {
            System.out.println("Робот прыгнул ");
            return true;
        } else {
            System.out.println("Робот не прыгнул");
            return false;
        }
    }
}
