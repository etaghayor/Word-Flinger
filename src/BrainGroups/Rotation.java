package BrainGroups;

import GamePlay.AnimatableForBrainGroups;
import GamePlay.Brain;

import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class Rotation extends AnimatableForBrainGroups {

    private int n;
    private ArrayList<Brain>[] circlesWithBrains;
    private Random random = new Random();
    private double teta, alpha = 0;
    private double omega = 0;
    private int r;

    public Rotation(int n, int type) {

        this.n = n;
        this.x = 900;
        this.y = 600;
        circlesWithBrains = new ArrayList[getNumberOfCircles()];
        for (int i = 0; i < getNumberOfCircles(); i++)
            circlesWithBrains[i] = new ArrayList<>();
        brains = new ArrayList<>();

        r = 1500;

//        for (int j = 0; j < getNumberOfCircles(); j++) {
        for (int i = 0; i < n; i++) {

            double rad;
            if (i < 8) {
                rad = r + 0 * 250 + 50;
                brain = new Brain(i, type, this.x + (rad * Math.cos(omega + teta * i)), this.y + (rad * Math.sin(omega + teta * i)));
                circlesWithBrains[0].add(brain);
                this.teta = (360 / Math.min(8, n)) * i;
            } else if (i < 20) {
                rad = r + 1 * 250 + 50;
                brain = new Brain(i, type, this.x + (rad * Math.cos(omega + teta * i)), this.y + (rad * Math.sin(omega + teta * i)));
                circlesWithBrains[1].add(brain);
                this.teta = (360 / Math.min(12, n - 8)) * (i - 8);

            } else if (i < 34) {
                rad = r + 2 * 250 + 50;
                brain = new Brain(i, type, this.x + (rad * Math.cos(omega + teta * i)), this.y + (rad * Math.sin(omega + teta * i)));
                circlesWithBrains[2].add(brain);
                this.teta = (360 / Math.min(16, n - 20)) * (i - 20);

            } else {
                rad = r + 3 * 250 + 50;
                brain = new Brain(i, type, this.x + (rad * Math.cos(omega + teta * i)), this.y + (rad * Math.sin(omega + teta * i)));
                circlesWithBrains[3].add(brain);
                this.teta = (360 / (n - 36)) * (i - 36);
            }


            brains.add(brain);
//            System.out.println("brain added to brains");
//                System.out.println("brain added to circle " + j);
//                circlesWithBrains[j].add(brain);

        }
    }


    @Override
    public void move(double time) {
        alpha += time * 40;
        if (alpha > 360)
            alpha -= 360;
        if (r <= 250)
            omega += 0.001 * Math.PI;
        if (r > 250)
            r--;
        for (int j = 0; j < getNumberOfCircles(); j++) {
            for (int i = 0; i < this.circlesWithBrains[j].size(); i++) {
                this.teta = (2 * Math.PI) / circlesWithBrains[j].size();
//                System.out.println(circlesWithBrains[j].size());
                double rad = r + j * 100 + 50;
//                System.out.println("radius : " + rad);
//                System.out.println("this. x " + this.x + "    omega: " + omega + "     teta " + teta + "   rad " + rad + "  i " + i + "  j " + j + "  this.y   " + this.y);

                circlesWithBrains[j].get(i).getCloseTo(this.x + (rad * Math.cos((omega) + teta * i)), rad * Math.sin((omega) + teta * i) + this.y);

                circlesWithBrains[j].get(i).move(time);
            }
//            }
        }

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

    @Override
    public void removeBrain(Brain brain) {
        super.removeBrain(brain);
        for (int i = 0; i < getNumberOfCircles(); i++)
            if (circlesWithBrains[i].contains(brain))
                circlesWithBrains[i].remove(brain);
    }
}
