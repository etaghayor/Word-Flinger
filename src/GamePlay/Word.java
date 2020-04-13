package GamePlay;

import Items.Images;
import User.Author;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Word extends Animatable {

    private int wordNumber;
    private int wordType;
    private boolean pizzaEaten = false;
    private int tiringDose, betweenTime;
    private Author author = Game.getGame().getAuthor();

    public Word(double authorsX, double authorsY, double degree) {

        init();
        this.x = authorsX + 60;
        this.y = authorsY + 60;
//        this.wordType = wordType;
//        this.xSpeed = 0;
//        this.ySpeed = -500;
        int n = author.getNumberOfPowerUp();
        if (n == 0) {
            this.image = Images.getWordType(1, wordNumber);
            author.setWordType(1);
        } else if (n == 3 || n == 1 || n == 2) {
            this.image = Images.getWordType(2, wordNumber);
            author.setWordType(2);
        } else if (n == 4 || n == 5 || n == 6) {
            this.image = Images.getWordType(3, wordNumber);
            author.setWordType(3);
        } else if (n == 7 || n == 8 || n == 9) {
            this.image = Images.getWordType(4, wordNumber);
            author.setWordType(4);
        } else if (n == 10 || n == 11 || n == 12) {
            this.image = Images.getWordType(author.getWordType(), wordNumber);
//            Game.getGame().getAuthor().setUserWordsAmount(1);
        } else {
            System.out.println("unicorn");
        }
        if (author.getWordType() == 1) {
            author.setWordPower(1);
            author.setTiringDose(150);
            author.setBetweenTime(200);
        }
        if (author.getWordType() == 2) {
            author.setWordPower(1);
            author.setTiringDose(120);
            author.setBetweenTime(200);
        }
        if (author.getWordType() == 3) {
            author.setWordPower(2);
            author.setTiringDose(100);
            author.setBetweenTime(150);
        }
        if (author.getWordType() == 4) {
            author.setWordPower(3);
            author.setTiringDose(80);
            author.setBetweenTime(100);
        }


        AffineTransform tx = new AffineTransform();
        double deg = Math.toRadians(degree);
        this.setXSpeed(Math.tan(deg) * 400);
        this.setYSpeed(-500);
        tx.rotate(deg, image.getWidth() / 2, image.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        image = op.filter(image, null);


    }


    private void init() {
        Random random = new Random(System.currentTimeMillis());
        this.wordNumber = Math.abs(random.nextInt()) % 6;
    }

    public int getWordType() {
        return wordType;
    }

    public void setWordType(int wordType) {
        this.wordType = wordType;
    }


}
