package BrainGroups;

import GamePlay.AnimatableForBrainGroups;
import GamePlay.Brain;
import GamePlay.Game;

import java.util.ArrayList;
import java.util.Random;

public class Suicide extends AnimatableForBrainGroups {

    private int timeToAttack = 0;
    private int timeToMove = 0;
    private Random random = new Random();

    public Suicide(int n, int type) {

        brains = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            brain = new Brain(i, type, random.nextDouble() * 1600 + 150, random.nextDouble() * 700 + 100);
            brain.setX(800);
            brain.setY(-100);
            brains.add(brain);

        }
    }

    @Override
    public void move(double time) {

        timeToAttack++;
        timeToMove++;
        if (timeToMove > 500) {
            timeToMove = 0;
            for (int i = 0; i < brains.size(); i++)
                brains.get(i).getCloseTo(random.nextDouble() * 1600 + 150, random.nextDouble() * 700 + 100);

        }

        if (timeToAttack > 500) {
            timeToAttack = 0;
            int index = (int) Math.ceil(random.nextDouble() * (brains.size() - 1));
            if (index > 0) {
                brains.get(index).getCloseTo(Game.getGame().getAuthor().getX(), Game.getGame().getAuthor().getY());
               brains.get(index).setXSpeed(brains.get(index).getXSpeed()*2);
               brains.get(index).setYSpeed(brains.get(index).getYSpeed()*2);
                brains.get(index).move(time);
            }
        }
        for (int i = 0; i < brains.size(); i++)
            brains.get(i).move(time);
    }
}
