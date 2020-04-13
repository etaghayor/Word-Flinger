package User;

import DialogueBoxes.AddUserBox;
import GamePlay.Animatable;
import GamePlay.Book;
import GamePlay.Game;
import GamePlay.Word;
import Items.Images;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.Serializable;

public class Author extends Animatable implements Serializable {

    private String username;
    private int userID, userLife, userWordsAmount, userWordTiring, userLevel, userHappiness, userHearts, userBook;
    private int fatigue = 0;
    private int tiringDose, betweenTime;
    private int numberOfPowerUp, wordType, wordPower;
    private boolean isImmune = false;
    private int resurrection = 700;
    private int immune = 1200;
    private long before = 0;
    private boolean exhausted = false;


    public Author(String username, int userId) {
        this.x = 820;
        this.y = 400;
        this.image = Images.getAuthor();
        this.username = username;
        this.userID = userId;
//        initForNewGame();
    }

    @Override
    public void move(double time) {
        this.setFatigue(-3);

    }

    @Override
    public void paint(Graphics2D g2) {

        if (!isDead()) {
            if (isImmune())
                immune--;
            if (immune < 0) {
                setImmune(false);
                immune = 1200;
            }

            g2.drawImage(image, (int) this.x, (int) this.y, null);
            resurrection = 700;
        } else {
            resurrection--;
            if (resurrection < 0) {
                kill(false);
                setImmune(true);
            }
        }

    }


    public void initForNewGame() {
        this.userLevel = 0;
        this.userLife = 5;
//        this.userWordsPower = 0;
        this.userHappiness = 0;
        this.userHearts = 0;
        this.userBook = 5;
        this.userWordsAmount = 1;

    }

    public void write() {
        long now = System.currentTimeMillis();
        if (this.getFatigue() == 0 && isExhausted())
            setExhausted(false);
        if (now - before > getBetweenTime() && !isExhausted() && !isDead()) {
            before = now;
            this.setFatigue(getTiringDose());
            if (this.getFatigue() < 1000) {
                if (getUserWordsAmount() == 1) {
                    Word word = new Word(this.getX() + 5, this.getY() - 5, 0);
                    Game.getGame().addToItems(word);
                } else if (getUserWordsAmount() == 2) {
                    Game.getGame().addToItems(new Word(this.getX() + 15, this.getY() - 5, 0));
                    Game.getGame().addToItems(new Word(this.getX() - 15, this.getY() - 5, 0));
                } else if (getUserWordsAmount() == 3) {
                    Game.getGame().addToItems(new Word(this.getX() + 5, this.getY() - 5, 0));
                    Game.getGame().addToItems(new Word(this.getX() + 15, this.getY() - 5, 5));
                    Game.getGame().addToItems(new Word(this.getX() - 15, this.getY() - 5, -5));
                } else if (getUserWordsAmount() == 4) {
                    Game.getGame().addToItems(new Word(this.getX() + 15, this.getY() - 5, 0));
                    Game.getGame().addToItems(new Word(this.getX() - 15, this.getY() - 5, 0));
                    Game.getGame().addToItems(new Word(this.getX() + 25, this.getY() - 5, 10));
                    Game.getGame().addToItems(new Word(this.getX() - 25, this.getY() - 5, -10));
                } else {
                    setWordPower(getWordType() * 5 / 4);
                }
            } else {
                setExhausted(true);
                this.setFatigue(-this.getFatigue() + 1000);
            }

        }
    }

    public void writeBook() {

        if (getUserBook() > 0 && !isDead()) {
            Book book = new Book((int) getX(), (int) getY());
            setUserBook(getUserBook() - 1);
            Game.getGame().getAuthors().writeFile();
            Game.getGame().addToItems(book);
        }

    }

    public void moveTo(int x, int y) {
        if (Game.getGame().isInGame()) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public void kill(boolean boolean1) {
        super.kill(boolean1);
        setUserWordsAmount(-getUserWordsAmount() + 1);
    }

    public int getFatigue() {
        return fatigue;
    }

    private void setFatigue(int tiredom) {

        this.fatigue += tiredom;
        this.fatigue = Math.max(0, this.fatigue);

    }

    private boolean isExhausted() {
        return exhausted;
    }

    private void setExhausted(boolean exhausted) {
        this.exhausted = exhausted;
    }

    public double getWidth() {
        return this.image.getWidth();
    }

    public double getHeight() {
        return this.image.getHeight();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserLife() {
        return userLife;
    }

    public void setUserLife(int userLife) {
        this.userLife += userLife;
    }


    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel += userLevel;
    }

    public int getUserHappiness() {
        return userHappiness;
    }

    public void setUserHappiness(int userHappiness) {
        this.userHappiness += userHappiness;
    }

    public int getUserHearts() {
        return userHearts;
    }

    public void setUserHearts(int userHearts) {
        this.userHearts += userHearts;
    }

    public int getUserBook() {
        return userBook;
    }

    private void setUserBook(int userBook) {
        this.userBook = userBook;
    }

    public boolean isImmune() {
        return isImmune;
    }

    private void setImmune(boolean immune) {
        isImmune = immune;
    }

    private int getUserWordsAmount() {
        return userWordsAmount;
    }

    public void setUserWordsAmount(int userWordsDose) {
        this.userWordsAmount += userWordsDose;
    }


    private int getTiringDose() {
        return tiringDose;
    }

    private int getBetweenTime() {
        return betweenTime;
    }

    public void setTiringDose(int tiringDose) {
        this.tiringDose = tiringDose;
    }

    public void setBetweenTime(int betweenTime) {
        this.betweenTime = betweenTime;
    }

    public int getNumberOfPowerUp() {
        return numberOfPowerUp;
    }

    public void setNumberOfPowerUp(int numberOfPowerUp) {
        this.numberOfPowerUp = numberOfPowerUp;
    }

    public int getWordType() {
        return wordType;
    }

    public void setWordType(int wordType) {
        this.wordType = wordType;
    }

    public int getWordPower() {
        return wordPower;
    }

    public void setWordPower(int wordPower) {
        this.wordPower = wordPower;
    }


}
