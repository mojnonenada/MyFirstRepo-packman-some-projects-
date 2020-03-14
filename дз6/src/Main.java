public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog(150,10,1);
        Cat cat = new Cat(30,43,10);

        dog.jump(10);
        dog.run(10);
        dog.swim(1);
        cat.swim(10);
        cat.run(30);
        cat.jump(43);
    }
}