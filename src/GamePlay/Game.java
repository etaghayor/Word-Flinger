
package GamePlay;

import BrainGroups.Circle;
import BrainGroups.Rotation;
import BrainGroups.Square;
import BrainGroups.Suicide;
import Mains.MainFrame;
import Mains.MainPanel;
import User.Author;
import UserMenu.Authors;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Game {

    private int timeBetweenWaves;
    private int maxLevel;
    private Authors authors = new Authors();
    private Author author;
    private int bossLife;
    private ArrayList<Animatable> items = new ArrayList<>();
    private boolean inGame = true, bossInGame = false;

    private static Game game;


    private File file;
    private int idFix = 0;
    private boolean bookOpened = false;
    private double i;


    public static Game getGame() {
        if (game == null)
            game = new Game();
        return game;
    }


    void paint(Graphics2D g2) {

        author.paint(g2);

//        synchronized (items) {
        for (Animatable word : copyOfItems())
            word.paint(g2);
//        }
    }


    private Game() {
        if (idFix >= 0) {
            author = new Author(getAuthors().getAuthorsArray().get(this.idFix).getUsername(),
                    getAuthors().getAuthorsArray().get(this.idFix).getUserID());
            setAuthor(author);
            System.out.println("author in Game: " + getAuthors().getAuthorsArray().get(this.idFix));
            System.out.println("username in Game: " + getAuthors().getAuthorsArray().get(getIdFix()).getUsername());
            System.out.println("idfix in Game: " + getAuthors().getAuthorsArray().get(getIdFix()).getUserID());
            addToItems(author);
            initAnimationThread();
        }

    }

    private Thread thread;

    synchronized private void initAnimationThread() {
        thread = new Thread(() -> {
            while (true) {
//                System.out.println(inGame + " inGame");
                if (inGame) {
                    synchronized (copyOfItems()) {
//                    update:
                        for (Animatable anim : copyOfItems()) {
                            anim.move(0.007);
                            checkHit(anim);
                        }

                    }
                    MainPanel.getMainPanel().setI(1);
                    MainPanel.getMainPanel().repaint();
                    MainPanel.getMainPanel().revalidate();
                    GamePanel.getGamePanel().repaint();
                    GamePanel.getGamePanel().revalidate();

                    try {
                        Thread.sleep(7);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    boolean activeBrains = false;
                    for (Animatable animatable : copyOfItems()) {
                        if (animatable instanceof BossBrain)
                            activeBrains = true;
                        if (animatable instanceof AnimatableForBrainGroups && ((AnimatableForBrainGroups) animatable).brains.size() != 0) {
                            activeBrains = true;
                        }

                    }
                    if (!activeBrains)
                        setNextRound();
                }
            }
        });

    }

    public void start() {
        thread.start();
    }

    private void checkHit(Animatable anim) {
        for (Animatable animatable : copyOfItems()) {
            if (anim instanceof Author && !anim.isDead()) {
//                System.out.println(author);
                if (animatable instanceof BossBrain) {
                    if (doesHit(anim, animatable)) {
                        author.kill(true);
                        author.setUserLife(-1);
                        ((BossBrain) animatable).updateLife(-30);
                        break;
                    }
                }
                if (animatable instanceof BlackSplash) {
                    if (doesHit(anim, animatable) && !author.isImmune()) {
                        author.kill(true);
                        author.setUserLife(-1);
                        removeFromItems(animatable);
//                        System.out.println("author hit black splash");
                        break;
                    }
                }
                if (animatable instanceof AnimatableForBrainGroups) {
//                    System.out.println("brain");
                    for (int i = 0; i < ((AnimatableForBrainGroups) animatable).getBrains().size(); i++) {
                        Brain brain = ((AnimatableForBrainGroups) animatable).getBrains().get(i);
                        if (doesHit(anim, brain) && !author.isImmune()) {
                            author.kill(true);
                            brain.kill(true);
                            author.setUserLife(-1);
                            ((AnimatableForBrainGroups) animatable).removeBrain(brain);
//                            System.out.println("author hit Brain");
                            break;
                        }
                    }
                }
                if (animatable instanceof WordPowerUp) {
                    if (doesHit(anim, animatable)) {
                        removeFromItems(animatable);
                        ((Author) anim).setNumberOfPowerUp(((WordPowerUp) animatable).getPowerUpNumber());
                        int n = ((WordPowerUp) animatable).getPowerUpNumber();
                        if (n == 10 || n == 11 || n == 12) {
                            author.setUserWordsAmount(1);

                        }
                        break;
                        //code
//                        author.setUserWordsPower(((WordPowerUp) animatable).getPowerUpNumber());
                    }
                }
                if (animatable instanceof HeartInGame) {
                    if (doesHit(anim, animatable)) {
//                        removeFromItems(anim);
                        removeFromItems(animatable);
                        author.setUserHearts(1);
                        break;
                    }
                }
            }
            if (anim instanceof Word) {
                if (animatable instanceof BossBrain)
                    if (doesHit(anim, animatable)) {
                        removeFromItems(anim);
                        ((BossBrain) animatable).updateLife(-(((Word) anim).getWordType()));
                        setBossLife(-(((Word) anim).getWordType()));
//                        System.out.println(getBossLife() + " game boss life");
//                        System.out.println(((BossBrain) animatable).getLife() + " boss life");
                        if (((BossBrain) animatable).getLife() <= 0) {
                            removeFromItems(animatable);
                            setBossInGame(false);
                            break;
                        }
                    }

                if (animatable instanceof AnimatableForBrainGroups) {
                    for (int i = 0; i < ((AnimatableForBrainGroups) animatable).getBrains().size(); i++) {
                        Brain brain = ((AnimatableForBrainGroups) animatable).getBrains().get(i);
                        if (doesHit(anim, brain)) {
                            removeFromItems(anim);
                            brain.setLife(-author.getWordPower());
                            if (brain.getLife() <= 0) {
                                brain.kill(true);
                                ((AnimatableForBrainGroups) animatable).removeBrain(brain);
                            }
                            break;
                        }
                    }
                }

                if (animatable instanceof HeartInGame) {
                    if (doesHit(anim, animatable)) {
                        System.out.println("heart hit");
                        removeFromItems(anim);
                        removeFromItems(animatable);
                        break;
                    }
                }
            }


            if (anim instanceof Book) {
                if (Math.abs(anim.x + 10 - (double) MainFrame.getMainFrame().getWidth() / 2) < 50 && Math.abs(anim.y + 10 - (double) MainFrame.getMainFrame().getHeight() / 2) < 50 && animatable instanceof AnimatableForBrainGroups) {
                    removeFromItems(anim);
                    ((AnimatableForBrainGroups) animatable).woundAllBrains1(2);
                    ((AnimatableForBrainGroups) animatable).removeKilledBrains();

//                    if (animatable instanceof AnimatableForBrainGroups /*&& animatable.getX() > 0*/)
//                        ((AnimatableForBrainGroups) animatable).woundAllBrains1();

                    removeFromItems(animatable);
                    break;
//                    if(animatable instanceof Brain)
//                        removeFromItems(animatable);
                }
            }
            if (Math.abs(anim.x + 10 - (double) MainFrame.getMainFrame().getWidth() / 2) < 50 && Math.abs(anim.y + 10 - (double) MainFrame.getMainFrame().getHeight() / 2) < 50 && animatable instanceof BossBrain) {
                removeFromItems(anim);
                ((BossBrain) animatable).updateLife(-30);
                break;
            }
        }

        if ((anim instanceof Word && anim.getY() < 0) || (anim instanceof BlackSplash && anim.getY() > 1000) || (anim instanceof WordPowerUp && anim.getY() > 1000))
            removeFromItems(anim);

    }

    private boolean doesHit(Animatable animatable1, Animatable animatable2) {
        double x1 = animatable1.getX();
        double x2 = animatable2.getX();
        double y1 = animatable1.getY();
        double y2 = animatable2.getY();
        double width1 = animatable1.getWidth();
        double width2 = animatable2.getWidth();
        double height1 = animatable1.getHeight();
        double height2 = animatable2.getHeight();

        boolean xconflict = !(x2 > x1 + width1 || x1 > x2 + width2);
        boolean yconflict = !(y2 > y1 + height1 || y1 > y2 + height2);
        return xconflict && yconflict;

    }


    public ArrayList<Animatable> getItems() {
        return items;
    }

    public void addToItems(Animatable animatable) {

        ArrayList<Animatable> copy = (ArrayList<Animatable>) items.clone();
        copy.add(animatable);
        this.items = copy;

    }

    void removeFromItems(Animatable animatable) {

        ArrayList<Animatable> copy = (ArrayList<Animatable>) items.clone();
        copy.remove(animatable);
        this.items = copy;
    }

    private ArrayList<Animatable> copyOfItems() {
        ArrayList<Animatable> copy = (ArrayList<Animatable>) items.clone();
        return copy;
    }

    private void setNextRound() {
        //code
        Game.getGame().getAuthors().writeFile();
        if (author.getUserLevel() >= maxLevel) {
//            code
        }
        int type = author.getUserLevel() / 4;
        if (author.getUserLevel() % 4 == 0 && author.getUserLevel() != 0) {
            BossBrain bossBrain = new BossBrain();
            setBossInGame(true);
            bossLife = bossBrain.getLife();
            System.out.println("boss made");
            System.out.println(author.getUserLevel() + " level");
            addToItems(bossBrain);
        } else {

            System.out.println(type + " type");
            Random random = new Random();
            int brainGroupType = random.nextInt(4);
            switch (brainGroupType) {
                case 0:
                    Square square = new Square(40, type);
                    addToItems(square);
                    break;
                case 1:
                    Circle circle = new Circle(75, 32, type);
                    addToItems(circle);
                    break;
                case 2:
                    Rotation rotation = new Rotation(30, type);
                    addToItems(rotation);
                    break;
                case 3:
                    Suicide suicide = new Suicide(15, type);
                    addToItems(suicide);
                    break;
            }
        }
        author.setUserLevel(1);
        author.setUserHappiness(author.getUserHearts() * 10);
        author.setUserHearts(-author.getUserHearts());
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public void setIdFix(int idFix) {
        this.idFix = idFix;
    }

    public int getIdFix() {
        return idFix;
    }

    public void setBookOpened(boolean bookOpened) {
        this.bookOpened = bookOpened;
    }

    public boolean isBookOpened() {
        return bookOpened;
    }

    private void setIForLAzor(double delta) {
        this.i += delta;
        if (this.i >= 0)
            this.i = -2400;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    int getBossLife() {
        return bossLife;
    }

    private void setBossLife(int bossLife) {
        this.bossLife += bossLife;
    }

    public boolean isBossInGame() {
        return bossInGame;
    }

    private void setBossInGame(boolean bossInGame) {
        this.bossInGame = bossInGame;
    }
}
