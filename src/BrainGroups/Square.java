package BrainGroups;

import GamePlay.AnimatableForBrainGroups;
import GamePlay.Brain;

import java.util.ArrayList;

public class Square extends AnimatableForBrainGroups {

    private boolean moveRight = true;

    public Square(int n, int type) {

        this.x = -1000;
        this.y = 150;
        brains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            brain = new Brain(i, type, 0, 0);
            brains.add(brain);
        }
    }


    @Override
    public void move(double time) {

        super.move(time);

        if (isMoveRight())
            this.setXSpeed(100);
        else
            this.setXSpeed(-100);

        if (this.x + (getAmountInLine()) * 150 > 1800)
            setMoveRight(false);
        if (this.x < 20)
            setMoveRight(true);

        for (int i = 0; i < brains.size(); i++) {
            brains.get(i).getCloseTo(x + (i % getAmountInLine()) * (brain.getWidth() + 13), y + (i / getAmountInLine()) * (brain.getHeight() + 13));
            brains.get(i).move(time);
        }
    }

    private boolean isMoveRight() {
        return moveRight;
    }

    private void setMoveRight(boolean moveRight) {
        moveRight = moveRight;
    }

    private int getAmountInLine() {

        if (brains.size() > 50)
            return 10;
        if (brains.size() >= 40)
            return 9;
        if (brains.size() >= 30)
            return 8;

        return 7;

    }
}
