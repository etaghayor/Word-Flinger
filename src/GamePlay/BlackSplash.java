package GamePlay;

import Items.Images;


public class BlackSplash extends Animatable {

    BlackSplash(double brainX, double brainY) {

        this.x = brainX + 50;
        this.y = brainY + 100;
        this.xSpeed = 0;
        this.ySpeed = 200;
        this.image = Images.getBlackSplash();

    }
}
