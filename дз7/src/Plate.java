class Plate {
    private int food;
    Plate(int food) {
        this.food = food;
    }

    boolean decreaseFood(int n) {
        if (food < n) {
            System.out.println("Не хватет еды в миске, нужно добавить ");
            return false;
        } else
            food -= n;
        return true;
    }

    public void addFood( int n ){
        food+= n;
    }

    void info() {
        System.out.println("plate: " + food);
    }
}