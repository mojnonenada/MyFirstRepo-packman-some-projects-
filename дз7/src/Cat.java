class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = true;
    }

    void eat(Plate p) {
        if (satiety &&  p.decreaseFood(appetite)) {

            satiety = false;
        }
    }

    void catInfo() {
        if (satiety) {
            System.out.println(name + " кот голоден");
        } else
            System.out.println(name + " кот сыт ");
    }

}