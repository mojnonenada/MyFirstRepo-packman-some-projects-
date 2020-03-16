public class Main {
    public static void main(String[] args) {
        Cat[] cat = {new Cat("Barsik", 10), new Cat("Barsik1", 20),new  Cat("Barsik2", 80)};
        Plate plate = new Plate(100);
        //Plate plate11 = new Plate(10);
      //  plate.info();
        cat[0].eat(plate);
        cat[0].catInfo();
        cat[1].eat(plate);
        cat[1].catInfo();
      //  plate.addFood(10);
        cat[2].eat(plate);
        cat[2].catInfo();
        plate.info();
    }
}