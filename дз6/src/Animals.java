abstract class Animal {
    int runrange;
    int jumprange;
    int swimrange;

    public Animal(int runrange, int jumprange, int swimrange){
        this.runrange = runrange;
        this.jumprange = jumprange;
        this.swimrange = swimrange;
    }
    abstract void run(int runrange);
    abstract void jump(int jumprange);
    abstract void swim(int swimrange);
}
