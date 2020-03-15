public class Main {
    public interface Essence {
        void run();
        void jump();
         int getMaxRun();
         int getMaxJump();
    }

    public static void main(String[] args) {
        Essence[] essences = new Essence[3];
        Obstacle[] obstacles = new Obstacle[2];
        essences[0] = new Human("Аnton",1000, 2);
        essences[1] = new Cat("Vaska",300,4);
        essences[2] = new Robot("robot-1",5000,6);
        obstacles[0] = new Wall("Стена",3);
        obstacles[1] = new Treadmill("Беговая дорожка",900);

        for (int i = 0; i <essences.length ; i++) {
            boolean res = true;
            for (int j = 0; j <obstacles.length ; j++) {
                if (Human.class == essences[i].getClass()) {
                    res = obstacles[j].action((Human) essences[i]);
                    if (res == false) {
                        break;
                    }
                }
                if (Cat.class == essences[i].getClass()) {
                    res = obstacles[j].action((Cat) essences[i]);
                    if (res == false) {
                        break;
                    }
                }
                if (Robot.class == essences[i].getClass()) {
                    res = obstacles[j].action((Robot) essences[i]);
                    if (res == false) {
                        break;
                    }
                }
            }
            }
            }
        }

