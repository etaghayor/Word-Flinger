package GamePlay;

import Items.Images;
import java.util.Random;

public class BossBrain extends Animatable {

    private double targetX, targetY;
    private int timeToMove = 0;
    private int life;
    private Random random = new Random();

    BossBrain() {
//        System.out.println("boss made");
        this.x = -1000;
        this.y = -500;
        this.life = ((Game.getGame().getAuthor().getUserLevel() / 5) + 1) * 50;
        this.image = Images.getBoss();
    }

    @Override
    public void move(double time) {
        super.move(time);
        if (Math.abs(x - targetX) < 10)
            xSpeed = 0;
        if (Math.abs(y - targetY) < 10)
            ySpeed = 0;
        timeToMove++;
        if (timeToMove > 500) {
            timeToMove = 0;
            getCloseTo(random.nextDouble() * 1000 + 200, random.nextDouble() * 300 + 200);
        }
        if (getLife() <= 0) {
            Game.getGame().removeFromItems(this);
        }
    }


    private void getCloseTo(double targetX, double targetY) {

        this.targetX = targetX;
        this.targetY = targetY;

        double distanceX = targetX - this.x;
        double distanceY = targetY - this.y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        this.xSpeed = distanceX / distance * 300;
        this.ySpeed = distanceY / distance * 300;

    }

    int getLife() {
        return life;
    }

    void updateLife(int life) {
        this.life += life;
    }
}
