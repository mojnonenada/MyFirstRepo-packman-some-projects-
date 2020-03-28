public abstract class Obstacle {
    private String name;

    public Obstacle(String name ){
        this.name = name;
    }

    abstract boolean action (Human human);
    abstract boolean action (Cat cat);
    abstract boolean action (Robot robot);
}
