package GamePlay;

import java.awt.*;
import java.util.ArrayList;

public abstract class AnimatableForBrainGroups extends Animatable {


    protected ArrayList<Brain> brains;
    protected Brain brain;

    public void removeBrain(Brain brain) {
        ArrayList<Brain> copy = (ArrayList<Brain>) brains.clone();
        copy.remove(brain);
        this.brains = copy;
    }

    void removeKilledBrains() {
        ArrayList<Brain> copy = (ArrayList<Brain>) brains.clone();
        for (Brain value : brains) {
            if (value.getLife() <= 0)
                copy.remove(value);
        }
        this.brains = copy;
    }

    ArrayList<Brain> getBrains() {
        return brains;
    }

    @Override
    public void paint(Graphics2D g2) {
        for (Brain brain : brains) {
            brain.paint(g2);
        }
    }

    void woundAllBrains1(int delta) {
        for (Brain brain : brains) {
            brain.woundBrain(-delta);
        }
    }
}
