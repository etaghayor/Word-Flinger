package GamePlay;

import Items.Images;

import java.awt.image.BufferedImage;
import java.util.Random;

public class WordPowerUp extends Animatable {

    private int numberOfPowerUp;
    private int power;

    WordPowerUp(double brainX, double brainY) {

        init();
        this.image = Images.getPowerUp(numberOfPowerUp);
        this.xSpeed = 0;
        this.ySpeed = 300;
        this.x = brainX + 50;
        this.y = brainY + 100;

    }

    private void init() {
        Random random = new Random(System.currentTimeMillis());
        this.numberOfPowerUp = Math.abs(random.nextInt()) % 13 + 1;
    }

    int getPowerUpNumber() {
        return numberOfPowerUp;
    }

}
