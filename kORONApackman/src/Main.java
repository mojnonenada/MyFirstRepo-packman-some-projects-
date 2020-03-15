
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
class Main extends JFrame {
    final static int BLOCK_SIZE = 40;
    final static int FIELD_WIDTH = 27;
    final static int FIELD_HEIGHT = 17;
    final String TITLE_OF_PROGRAM = "PackMan";
    final int START_LOCATION = 10;
    final int FIELD_DX= 5;
    final int FIELD_DY= 26;
    final int LEFT = 37; // key codes
    final int UP = 38;
    final int RIGHT = 39;
    final int DOWN = 40;
    final int CHANGE_SKIN = 17;
    final static int SCORES =1;
    int i=BLOCK_SIZE;
    public static Audio a_mainmusic;
    final double SHOW_DELAY = 100.0/BLOCK_SIZE; // delay for animation
    //final float MOVE_DELAY = SHOW_DELAY/BLOCK_SIZE;
    JFrame frame;
    //int[][] field = new int[FIELD_HEIGHT][FIELD_WIDTH];
    Canvas canvas = new Canvas();
    Random random = new Random();
    boolean gameOver = false;
    final static String[] SKINS = {"skin1.png", "skin2.png"};
    final static int[][] FIELD_WALL = {
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};

    private static Image img;
    public static void main(String[] args) {
        Field.fieldWall();
        Field.fillIn();
        new Main().go();
    }
    void go() { // main loop of game
        while (!gameOver) {
            try {
                Thread.sleep(Math.round(SHOW_DELAY));
            } catch (Exception e) { e.printStackTrace(); }
            canvas.repaint();
            if (PackMan.isTouchConv()) {
                PackMan.stop();
                //packMan.leaveOnTheGround();
                //gameOver = .isCrossGround(); // Is there space for a new figure?
            }
            if(i==BLOCK_SIZE){
                i=0;
                img = new ImageIcon("mouthClose/"+PackMan.getRotate()+PackMan.getSkin()).getImage();
                setTitle(TITLE_OF_PROGRAM + " : " + PackMan.getGameScores());
                PackMan.step();
                PackMan.newVectorOfMooving();
            }else{
                PackMan.smallStep();
                if(i==Math.round(BLOCK_SIZE/2)) img = new ImageIcon("mouthOpen/"+PackMan.getRotate()+PackMan.getSkin()).getImage();
            }
            i++;

            //PackMan.step();
        }
    }
    static class Field {
        public static int[][] field = new int[FIELD_HEIGHT+2][FIELD_WIDTH+2];
        static void fieldWall(){
            for(int i=0;i<FIELD_HEIGHT;i++){
                for(int i1=0;i1<FIELD_WIDTH;i1++){
                    if(FIELD_WALL[i][i1]==-1) field[i][i1]=-1;
                }
            }
        }
        public static void paint(Graphics g, int color) {
            g.setColor(new Color(color));
            for(int i=0;i<FIELD_HEIGHT;i++){
                for(int i1=0;i1<FIELD_WIDTH;i1++){
                    if(field[i][i1]==-1) g.fillRect(i1*BLOCK_SIZE,i*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                    if(field[i][i1]==1) g.fillOval(i1*BLOCK_SIZE+Math.round(BLOCK_SIZE/2),i*BLOCK_SIZE+Math.round(BLOCK_SIZE/2),4,4);
                }
            }
            //WallForm wallForm = new PackManForm(x,y,Math.round(dxx),Math.round(dyy));
            //wallForm.paint(g, 0xf0f000);
        }
        public static void fillIn (){
            for(int i=0;i<FIELD_HEIGHT;i++){
                for(int i1=0;i1<FIELD_WIDTH;i1++){
                    if(field[i][i1]==0) field[i][i1]=1;
                }
            }
        }
    }

    static class PackMan {
        private static int x = 5;
        private static int y = 5;
        private static int dx = 0;
        private static int dy = 0;
        private static double dyy;
        private static double dxx;
        private static int dxp;
        private static int dyp;
        private static int gameScores;
        private static int activeSkin=1;
        private static String rotate = "right/";
        private static int iCS = 0;

        static void down(){
            dy=1;
            dx=0;
            rotate = "down/";
        }
        static void up(){
            dy=-1;
            dx=0;
            rotate = "up/";
        }
        static void left(){
            dy=0;
            dx=-1;
            rotate = "left/";
        }
        static void right(){
            dy=0;
            dx=1;
            rotate = "right/";
        }
        static void stop(){
            dy=0;
            dx=0;
        }

        static String getRotate(){
            return rotate;
        }

        static void newVectorOfMooving(){
            dxp=dx;
            dyp=dy;
        }

        static void smallStep(){
            dxx+=dxp;
            dyy+=dyp;
            //System.out.println(dxx+" "+dyy);
            //System.out.println(x+" "+y);
        }

        static void step(){
            if(Field.field[y][x]==1){
                gameScores+=SCORES;
                Field.field[y][x]=0;
            }
            x+=dx;
            y+=dy;
            dxx=-BLOCK_SIZE*dx;
            dyy=-BLOCK_SIZE*dy;
        }

        static void psevdoChangeSkin (){
            if(iCS<SKINS.length-1) iCS++; else iCS=0;
            changeSkin(iCS);
        }

        static void changeSkin(int skin){
            activeSkin = skin;
        }
        static String getSkin(){
            return SKINS[activeSkin];
        }
        static int getGameScores(){
            return gameScores;
        }
        static boolean isTouchConv(){
            return (Field.field[y+dy][x+dx]==-1);
        }
        static void paint(Graphics g) {
            PackManForm packManForm = new PackManForm(x,y,Math.round(dxx),Math.round(dyy));
            packManForm.paint(g, 0xf0f000);
        }
    }

    static class PackManForm { // building element for Figure
        private int x, y;
        private long dx, dy;

        public PackManForm(int x, int y, long dx, long dy) {
            setX(x);
            setY(y);
            setDx(dx);
            setDy(dy);
        }

        void setDx(long dx) { this.dx = dx; }
        void setDy(long dy) { this.dy = dy; }
        void setX(int x) { this.x = x; }
        void setY(int y) { this.y = y; }
        int getX() { return x; }
        int getY() { return y; }

        void paint(Graphics g, int color) {
            g.setColor(new Color(color));
            //g.drawRoundRect(x*BLOCK_SIZE+1, y*BLOCK_SIZE+1, BLOCK_SIZE-2, BLOCK_SIZE-2, ARC_RADIUS, ARC_RADIUS);
            //System.out.println(dx+" "+dy);
            //System.out.println(dx+" "+dy);
            //g.fillOval( Math.round(x*BLOCK_SIZE+dx+BLOCK_SIZE), Math.round(y*BLOCK_SIZE+dy+BLOCK_SIZE),Math.round(BLOCK_SIZE),Math.round(BLOCK_SIZE));
            g.drawImage(img,Math.round(x*BLOCK_SIZE+dx), Math.round(y*BLOCK_SIZE+dy),BLOCK_SIZE,BLOCK_SIZE,null);
            //g.fillOval( Math.round(x*BLOCK_SIZE+dx), Math.round(y*BLOCK_SIZE+dy),Math.round(BLOCK_SIZE),Math.round(BLOCK_SIZE));
        }
    }

    Main() {
        a_mainmusic = new Audio("res/ost.wav", 0.6);
        a_mainmusic.sound();
        a_mainmusic.setVolume();
        a_mainmusic.repeat(1);
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, FIELD_WIDTH * BLOCK_SIZE + FIELD_DX, FIELD_HEIGHT * BLOCK_SIZE + FIELD_DY);
        setResizable(false);

        canvas.setBackground(Color.black); // define the background color
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    if (e.getKeyCode() == DOWN) PackMan.down();
                    if (e.getKeyCode() == UP) PackMan.up();
                    if (e.getKeyCode() == LEFT) PackMan.left();
                    if (e.getKeyCode() == RIGHT) PackMan.right();
                    if (e.getKeyCode() == CHANGE_SKIN) PackMan.psevdoChangeSkin();
                }
                canvas.repaint();
            }
        });
        add(BorderLayout.CENTER, canvas);
        setVisible(true);
        //Arrays.fill(field[FIELD_HEIGHT+1], 1); // create a conv for PM
        //Arrays.fill(field[FIELD_HEIGHT-1], 1);
        //Arrays.fill(field[FIELD_WIDTH+1], 1);
        //Arrays.fill(field[FIELD_WIDTH-1], 1);
    }
    class Canvas extends JPanel { // my canvas for painting
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int x = 0; x < FIELD_WIDTH; x++)
                for (int y = 0; y < FIELD_HEIGHT; y++) {
                    if (Field.field[y][x] > 0) {
                        g.setColor(new Color(Field.field[y][x]));
                        g.fill3DRect(x*BLOCK_SIZE+1, y*BLOCK_SIZE+1, BLOCK_SIZE-1, BLOCK_SIZE-1, true);
                    }
                }
            /*{if (gameOver) {
                g.setColor(Color.white);
                for (int y = 0; y < GAME_OVER_MSG.length; y++)
                    for (int x = 0; x < GAME_OVER_MSG[y].length; x++)
                        if (GAME_OVER_MSG[y][x] == 1) g.fill3DRect(x*11+18, y*11+160, 10, 10, true);
            } else*/
            Field.paint(g, 0x0000f0);
            PackMan.paint(g);
        }
    }
}