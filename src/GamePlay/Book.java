package GamePlay;

import Items.Images;
import Mains.MainFrame;

public class Book extends Animatable {

    public Book(int authorX, int authorY) {

        this.xSpeed = ((float)MainFrame.getMainFrame().getWidth() / 2 - authorX) ;
        this.ySpeed = ((float)MainFrame.getMainFrame().getHeight() / 2 - authorY);
        this.x = authorX;
        this.y = authorY;
        this.image = Images.getBook();

    }

    @Override
    public void move(double time) {
        super.move(time);
    }
}




