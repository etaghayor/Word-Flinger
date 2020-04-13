package GamePlay;

import Items.Images;

import java.util.Random;

public class Brain extends Animatable {
    private int type, life = 2;
    private double targetX, targetY;
    private BlackSplash blackSplash;

    public Brain(int id, int type, double x, double y) {

        this.type = type;
        this.x = x;
        this.y = y;
        this.xSpeed = 0;
        this.ySpeed = 0;
        if (type == 0) {
            this.image = Images.getBrainBlack1();
            this.life = 2;
        } else if (type == 1) {
            this.image = Images.getBrainBlack2();
            this.life = 3;
        } else if (type == 2) {
            this.life = 5;
            this.image = Images.getBrainBlack3();
        } else {
            this.life = 8;
            this.image = Images.getBrainBlack4();
        }
    }


    @Override
    public void move(double time) {
        super.move(time);

        if (Math.abs(x - targetX) < 10)
            xSpeed = 0;
        if (Math.abs(y - targetY) < 10)
            ySpeed = 0;

        if (this.type == 0 || this.type == 1)
            throwBlackSplash5();
        if (this.type == 2)
            throwBlackSplash10();
        if (this.type == 3)
            throwBlackSplash20();


    }

    @Override
    public void kill(boolean boolean4) {
        this.dead = boolean4;
//        if (boolean4) {
            throwPowerUp();
            throwHeartInGame();
//        }
    }

    private void throwPowerUp() {
        Random random = new Random();
        if (random.nextDouble() <= 0.03f)
            Game.getGame().addToItems(new WordPowerUp(this.x, this.y));
    }

    private void throwHeartInGame() {
        Random random = new Random();
        if (random.nextDouble() <= 0.10f)
            Game.getGame().addToItems(new HeartInGame(this.x, this.y));
    }

    private void throwBlackSplash5() {
        Random random = new Random();
        if (random.nextDouble() <= 0.00025f)
            Game.getGame().addToItems(new BlackSplash(this.x, this.y));
//        System.out.println(random.nextInt(100));

    }

    private void throwBlackSplash10() {

        blackSplash = new BlackSplash(this.x, this.y);
        blackSplash.ySpeed = 400;
        Random random = new Random();
        if (random.nextDouble() <= 0.0005f)
            Game.getGame().addToItems(blackSplash);
//        System.out.println(random.nextInt(100));
    }

    private void throwBlackSplash20() {

        blackSplash = new BlackSplash(this.x, this.y);
        blackSplash.ySpeed = 400;
        Random random = new Random(/*System.currentTimeMillis()*/);
        if (random.nextDouble() <= 0.001f)
            Game.getGame().addToItems(blackSplash);
//        System.out.println(random.nextInt(100));
    }


    public void getCloseTo(double targetX, double targetY) {

        this.targetX = targetX;
        this.targetY = targetY;

        double distanceX = targetX - this.x;
        double distanceY = targetY - this.y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        this.xSpeed = distanceX / distance * 300;
        this.ySpeed = distanceY / distance * 300;

    }

    void woundBrain(int delta) {
        setLife(-delta);
        if (getLife() <= 0)
            kill(true);
    }


    int getLife() {
        return life;
    }

    void setLife(int life) {
        this.life += life;
    }
}
