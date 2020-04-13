package GamePlay;

import Items.Images;

class HeartInGame extends Animatable {

    HeartInGame(double brainX, double brainY) {

        this.x = brainX + 50;
        this.y = brainY + 100;
        this.xSpeed = 0;
        this.ySpeed = 350;
        this.image = Images.getHeartInGame();
    }
}
