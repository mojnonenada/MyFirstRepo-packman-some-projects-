class Cat extends Animal {

    public Cat(int runrange, int jumprange, int swimrange) {
        super(runrange, jumprange, swimrange);
    }

    @Override
    void run(int runrange) {
        if(runrange<=200) {
            System.out.println("run true");
        }
            else{
                System.out.println("run false");
            }
    }

    @Override
    void jump(int jumprange) {
        if (jumprange<=2) {
            System.out.println("jump true");
        } else{
            System.out.println("jump false");
        }
    }

    @Override
    void swim(int swimrange) {
        System.out.println("Кот не умеет плавать");
    }
}