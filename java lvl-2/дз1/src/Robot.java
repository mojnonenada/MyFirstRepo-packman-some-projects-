public class Robot implements Main.Essence {
    private String name;
    private int maxRun;
    private int maxJump;

    public Robot(String name, int maxRun , int maxJump){
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void run() {
      //  System.out.println("Робот "+name+ "  бежит");
    }

    @Override
    public void jump() {
       // System.out.println("Робот  "+name+ " прыгнул");
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



