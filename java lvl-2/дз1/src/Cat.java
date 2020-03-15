public class Cat implements Main.Essence {
    private String name;
    private int maxRun;
    private int maxJump;

    public Cat(String name, int maxRun , int maxJump){
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run() {

    }

    @Override
    public void jump() {

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

