package BrainGroups;

import GamePlay.AnimatableForBrainGroups;
import GamePlay.BlackSplash;
import GamePlay.Brain;
import GamePlay.Game;

import java.util.ArrayList;
import java.util.Random;

public class Circle extends AnimatableForBrainGroups {

    private boolean isMoveRight = true;
    private Random random = new Random();
    private double teta;
    private double omega;
    private double targetX, targetY;
    private double omegaSpeedX, omegaSpeedY, omegaSpeed;
    private double radius;
    private int timeToMove = 0, n;
    private ArrayList<Brain>[] circlesWithBrains;

    public Circle(double radius, int n , int type) {

        omega = random.nextInt(50) / 100 * Math.PI;

        this.x = 500;
        this.y = 300;
        this.n = n;
        this.radius = radius;
        circlesWithBrains = new ArrayList[getNumberOfCircles()];
        for (int i = 0; i < getNumberOfCircles(); i++)
            circlesWithBrains[i] = new ArrayList<>();
        brains = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0)
                brain = new Brain(i, type , 0 , -10);
            else
                brain = new Brain(i, type, 2000 , -10);
            brains.add(brain);

            if (i <= 8)
                circlesWithBrains[0].add(brain);
            else if (i <= 20)
                circlesWithBrains[1].add(brain);
            else if (i <= 34)
                circlesWithBrains[2].add(brain);
            else
                circlesWithBrains[3].add(brain);

        }

    }

    @Override
    public void move(double time) {
        super.move(time);
        if(Math.abs(x - targetX) < 2)
            xSpeed = 0;
        if(Math.abs(y - targetY) < 2)
            ySpeed = 0;

        timeToMove++;
        if (timeToMove > 1000) {


//            System.out.println("targetX : " + random.nextDouble() * 1000 );
//            System.out.println("taergetY : " + random.nextDouble() *300 + 400);
            this.getCloseToRandomCenter(random.nextDouble() * 1000 + 200, random.nextDouble() *300 + 200);
            timeToMove = 0;
        }
        omega += 0.001 * Math.PI;

        if (isMoveRight)
            this.setXSpeed(100);
        else
            this.setXSpeed(-100);

        if (this.getX() > 1400)
            setMoveRight(false);

        if (this.getX() < 500)
            setMoveRight(true);

        for (int j = 0; j < getNumberOfCircles(); j++) {
            for (int i = 0; i < this.circlesWithBrains[j].size(); i++) {
                this.teta = (2 * Math.PI) / circlesWithBrains[j].size();
                double rad = radius + j * 100 + 50;
                circlesWithBrains[j].get(i).getCloseTo(this.x + (rad * Math.cos((omega) + teta * i)), rad * Math.sin((omega) + teta * i) + this.y);
                circlesWithBrains[j].get(i).move(time);
            }
        }
    }

    private boolean isMoveRight() {
        return isMoveRight;
    }

    private int getNumberOfCircles() {
        if (n <= 7)
            return 1;
        if (n <= 18)
            return 2;
        if (n <= 38)
            return 3;
        return 4;
    }

    private void setMoveRight(boolean moveRight) {
        isMoveRight = moveRight;
    }


    @Override
    public void removeBrain(Brain brain) {
        super.removeBrain(brain);
        for(int i=0; i<getNumberOfCircles(); i++)
            if(circlesWithBrains[i].contains(brain))
                circlesWithBrains[i].remove(brain);
    }
    private void getCloseToRandomCenter(double targetX, double targetY) {

        this.targetX = targetX;
        this.targetY = targetY;

        double distanceX = targetX - this.x;
        double distanceY = targetY - this.y;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        this.xSpeed = distanceX / distance * 300;
        this.ySpeed = distanceY / distance * 300;

    }
}
