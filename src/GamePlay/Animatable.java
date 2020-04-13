package GamePlay;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Animatable {

    protected double x, y, xSpeed, ySpeed;
    public BufferedImage image;
    boolean dead = false;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        if (this.image == null) {
            System.out.println(this.getClass().toString() + " image is null");
            return -1;
        } else
            return this.image.getWidth();
    }

    public double getHeight() {
        if (this.image == null) {
            System.out.println("image is null");
            return -1;
        } else
            return this.image.getHeight();
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void move(double time) {

        this.x += xSpeed * time;
        this.y += ySpeed * time;

    }

    public void paint(Graphics2D g2) {

        g2.drawImage(image, (int) this.x, (int) this.y, null);
    }

    protected boolean isDead() {
        return dead;
    }

    public void kill(boolean boolean1) {
        this.dead = boolean1;
//        if (boolean1) {
//        Game.getGame().removeFromItems(this);
//        }
    }


}
