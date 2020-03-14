
public  class Dog extends Animal {

    public Dog(int runrange, int jumprange, int swimrange) {

        super(runrange, jumprange, swimrange);
    }

    @Override
    void run(int runrange) {
        if (runrange <= 500)
        System.out.println("run true");
        else
            System.out.println("run false");
    }

    @Override
    void jump(int jumprange) {
        if (jumprange <= 0.5)
        System.out.println("jump true");
        else
            System.out.println("jump false");
    }

    @Override
    void swim(int swimrange) {
        if (swimrange<= 10)
        System.out.println("swim true");
        else
            System.out.println("swim false");
    }
}

