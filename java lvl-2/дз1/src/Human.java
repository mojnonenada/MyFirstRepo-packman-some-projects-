public class Human implements Main.Essence {

    private String name;
    private int maxRun;
    private int maxJump;

    public Human(String name, int maxRun , int maxJump){
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run() {
    //    System.out.println("Человек "+name+ " бежит");
    }

    @Override
    public void jump() {
     //   System.out.println("Человек "+name+ " прыгнул");
    }
    @Override
    public int getMaxRun() {
        return maxRun;
    }
    @Override
    public int getMaxJump(){
        return maxJump;
    }
}

