package Items;

import Mains.MainFrame;
import com.sun.java.accessibility.util.GUIInitializedListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    private static BufferedImage author;
    private static BufferedImage wordsLightWhite, wordsFreeWhite, wordsGameWhite, wordsPrayerWhite, wordsDawnWhite, wordsHeroWhite;
    private static BufferedImage wordsLightPink, wordsFreePink, wordsGamePink, wordsPrayerPink, wordsDawnPink, wordsHeroPink;
    private static BufferedImage wordsLightGreen, wordsFreeGreen, wordsGameGreen, wordsPrayerGreen, wordsDawnGreen, wordsHeroGreen;
    private static BufferedImage wordsLightBlue, wordsFreeBlue, wordsGameBlue, wordsPrayerBlue, wordsDawnBlue, wordsHeroBlue;
    private static BufferedImage brainBlack, brainBlackType2, book, happiness, life, heart, heartInGame, bookOpen, blackSplash, immuneAura, boss;
    private static BufferedImage unicornPowerUp, whalePowerUp, cloverPowerUp, pinkFlowerPowerUp, lazorPowerUp, pizzaPowerUp;
    private static BufferedImage dialogueBox, backgroundImage, logo;
    private static Image boxScaledImage, logoScaledImage, happinessScaledImage, bookOpenedScaledImage, brainBlackScaledImage;
    private static BufferedImage brainBlackType4, brainBlackType3;

    public static Image getBackgroundImage() {
        if (backgroundImage == null)
            try {
                backgroundImage = ImageIO.read(new File("Images/Background.jpg"));
//                scaledImage = backgroundImage.getScaledInstance(MainFrame.getMainFrame().getWidth(), MainFrame.getMainFrame().getHeight(), Image.SCALE_SMOOTH);

            } catch (IOException e) {
                e.printStackTrace();
            }
        return backgroundImage;
    }


    public static BufferedImage getAuthor() {
        if (author == null)
            try {
                author = ImageIO.read(new File("Images/authorNormal.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return author;
    }


    public static BufferedImage getWordType(int type, int numberOfWord) {
        if (type == 1) {
            if (numberOfWord == 0)
                return getWordsDawnWhite();
            else if (numberOfWord == 1)
                return getWordsHeroWhite();
            else if (numberOfWord == 2)
                return getWordsGameWhite();
            else if (numberOfWord == 3)
                return getWordsLightWhite();
            else if (numberOfWord == 4)
                return getWordsFreeWhite();
            else if (numberOfWord == 5)
                return getWordsPrayerWhite();
            else
                return null;
        } else if (type == 2) {
            if (numberOfWord == 0)
                return getWordsDawnPink();
            else if (numberOfWord == 1)
                return getWordsHeroPink();
            else if (numberOfWord == 2)
                return getWordsGamePink();
            else if (numberOfWord == 3)
                return getWordsLightPink();
            else if (numberOfWord == 4)
                return getWordsFreePink();
            else if (numberOfWord == 5)
                return getWordsPrayerPink();
            else
                return null;
        }
        else if(type == 3){
            if (numberOfWord == 0)
                return getWordsDawnGreen();
            else if (numberOfWord == 1)
                return getWordsHeroGreen();
            else if (numberOfWord == 2)
                return getWordsGameGreen();
            else if (numberOfWord == 3)
                return getWordsLightGreen();
            else if (numberOfWord == 4)
                return getWordsFreeGreen();
            else if (numberOfWord == 5)
                return getWordsPrayerGreen();
            else
                return null;
        }
        else{
            if (numberOfWord == 0)
                return getWordsDawnBlue();
            else if (numberOfWord == 1)
                return getWordsHeroBlue();
            else if (numberOfWord == 2)
                return getWordsGameBlue();
            else if (numberOfWord == 3)
                return getWordsLightBlue();
            else if (numberOfWord == 4)
                return getWordsFreeBlue();
            else if (numberOfWord == 5)
                return getWordsPrayerBlue();
            else
                return null;
        }
    }

    public static BufferedImage getWordsLightBlue() {
        if (wordsLightBlue == null)
            try {
                wordsLightBlue = ImageIO.read(new File("Images/Words/Blue/blueLight.png"));
//                scaledImage = wordsLightBlue.getScaledInstance(20,10, Image.SCALE_SMOOTH);

            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsLightBlue;
    }


    public static BufferedImage getWordsFreeBlue() {
        if (wordsFreeBlue == null)
            try {
                wordsFreeBlue = ImageIO.read(new File("Images/Words/Blue/blueFree.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsFreeBlue;
    }


    public static BufferedImage getWordsGameBlue() {
        if (wordsGameBlue == null)
            try {
                wordsGameBlue = ImageIO.read(new File("Images/Words/Blue/blueGame.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsGameBlue;
    }


    public static BufferedImage getWordsPrayerBlue() {
        if (wordsPrayerBlue == null)
            try {
                wordsPrayerBlue = ImageIO.read(new File("Images/Words/Blue/bluePray.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsPrayerBlue;
    }

    public static BufferedImage getWordsDawnBlue() {
        if (wordsDawnBlue == null)
            try {
                wordsDawnBlue = ImageIO.read(new File("Images/Words/Blue/blueDawn.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsDawnBlue;
    }


    public static BufferedImage getWordsHeroBlue() {
        if (wordsHeroBlue == null)
            try {
                wordsHeroBlue = ImageIO.read(new File("Images/Words/Blue/blueHero.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsHeroBlue;
    }

    public static BufferedImage getWordsLightGreen() {
        if (wordsLightGreen == null)
            try {
                wordsLightGreen = ImageIO.read(new File("Images/Words/Green/greenLight.png"));
//                scaledImage = wordsLightGreen.getScaledInstance(20,10, Image.SCALE_SMOOTH);

            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsLightGreen;
    }


    public static BufferedImage getWordsFreeGreen() {
        if (wordsFreeGreen == null)
            try {
                wordsFreeGreen = ImageIO.read(new File("Images/Words/Green/greenFree.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsFreeGreen;
    }


    public static BufferedImage getWordsGameGreen() {
        if (wordsGameGreen == null)
            try {
                wordsGameGreen = ImageIO.read(new File("Images/Words/Green/greenGame.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsGameGreen;
    }


    public static BufferedImage getWordsPrayerGreen() {
        if (wordsPrayerGreen == null)
            try {
                wordsPrayerGreen = ImageIO.read(new File("Images/Words/Green/greenPray.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsPrayerGreen;
    }

    public static BufferedImage getWordsDawnGreen() {
        if (wordsDawnGreen == null)
            try {
                wordsDawnGreen = ImageIO.read(new File("Images/Words/Green/greenDawn.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsDawnGreen;
    }


    public static BufferedImage getWordsHeroGreen() {
        if (wordsHeroGreen == null)
            try {
                wordsHeroGreen = ImageIO.read(new File("Images/Words/Green/greenHero.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsHeroGreen;
    }

    public static BufferedImage getWordsLightPink() {
        if (wordsLightPink == null)
            try {
                wordsLightPink = ImageIO.read(new File("Images/Words/Pink/pinkLight.png"));
//                scaledImage = wordsLightPink.getScaledInstance(20,10, Image.SCALE_SMOOTH);

            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsLightPink;
    }


    public static BufferedImage getWordsFreePink() {
        if (wordsFreePink == null)
            try {
                wordsFreePink = ImageIO.read(new File("Images/Words/Pink/pinkFree.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsFreePink;
    }


    public static BufferedImage getWordsGamePink() {
        if (wordsGamePink == null)
            try {
                wordsGamePink = ImageIO.read(new File("Images/Words/Pink/pinkGame.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsGamePink;
    }


    public static BufferedImage getWordsPrayerPink() {
        if (wordsPrayerPink == null)
            try {
                wordsPrayerPink = ImageIO.read(new File("Images/Words/Pink/pinkPray.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsPrayerPink;
    }

    public static BufferedImage getWordsDawnPink() {
        if (wordsDawnPink == null)
            try {
                wordsDawnPink = ImageIO.read(new File("Images/Words/Pink/pinkDawn.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsDawnPink;
    }


    public static BufferedImage getWordsHeroPink() {
        if (wordsHeroPink == null)
            try {
                wordsHeroPink = ImageIO.read(new File("Images/Words/Pink/pinkHero.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsHeroPink;
    }

    public static BufferedImage getWordsLightWhite() {
        if (wordsLightWhite == null)
            try {
                wordsLightWhite = ImageIO.read(new File("Images/Words/White/whiteLight.png"));
//                scaledImage = wordsLightWhite.getScaledInstance(20,10, Image.SCALE_SMOOTH);

            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsLightWhite;
    }


    public static BufferedImage getWordsFreeWhite() {
        if (wordsFreeWhite == null)
            try {
                wordsFreeWhite = ImageIO.read(new File("Images/Words/White/whiteFree.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsFreeWhite;
    }


    public static BufferedImage getWordsGameWhite() {
        if (wordsGameWhite == null)
            try {
                wordsGameWhite = ImageIO.read(new File("Images/Words/White/whiteGame.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsGameWhite;
    }


    public static BufferedImage getWordsPrayerWhite() {
        if (wordsPrayerWhite == null)
            try {
                wordsPrayerWhite = ImageIO.read(new File("Images/Words/White/whitePray.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsPrayerWhite;
    }

    public static BufferedImage getWordsDawnWhite() {
        if (wordsDawnWhite == null)
            try {
                wordsDawnWhite = ImageIO.read(new File("Images/Words/White/whiteDawn.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsDawnWhite;
    }


    public static BufferedImage getWordsHeroWhite() {
        if (wordsHeroWhite == null)
            try {
                wordsHeroWhite = ImageIO.read(new File("Images/Words/White/whiteHero.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return wordsHeroWhite;
    }

    public static BufferedImage getBrainBlack1() {
        if (brainBlack == null)
            try {
                brainBlack = ImageIO.read(new File("Images/BrainImages/Type1/Black/Black Brain.png"));
//                brainBlackScaledImage = brainBlack.getScaledInstance(60,40,Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return brainBlack;
    }

    public static BufferedImage getBrainBlack2() {
        if (brainBlackType2 == null)
            try {
                brainBlackType2 = ImageIO.read(new File("Images/BrainImages/Type2/BrainType2.png"));
//                brainBlackScaledImage = brainBlack.getScaledInstance(60,40,Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return brainBlackType2;
    }

    public static BufferedImage getBrainBlack3() {
        if (brainBlackType3 == null)
            try {
                brainBlackType3 = ImageIO.read(new File("Images/BrainImages/Type3/Black Brain with Helmet.png"));
//                brainBlackScaledImage = brainBlack.getScaledInstance(60,40,Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return brainBlackType3;
    }

    public static BufferedImage getBrainBlack4() {
        if (brainBlackType4 == null)
            try {
                brainBlackType4 = ImageIO.read(new File("Images/BrainImages/Type4/BlackBrainType4.png"));
//                brainBlackScaledImage = brainBlack.getScaledInstance(60,40,Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return brainBlackType4;
    }


    public static BufferedImage getBook() {
        if (book == null) {
            try {
                book = ImageIO.read(new File("Images/book.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    public static Image getHappiness() {
        if (happiness == null) {
            try {
                happiness = ImageIO.read(new File("Images/happiness.png"));
                happinessScaledImage = happiness.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return happinessScaledImage;
    }


    public static BufferedImage getLife() {
        if (life == null) {
            try {
                life = ImageIO.read(new File("Images/life.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return life;
    }

    public static BufferedImage getHeart() {
        if (heart == null) {
            try {
                heart = ImageIO.read(new File("Images/heart.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return heart;
    }

    public static BufferedImage getHeartInGame() {
        if (heartInGame == null) {
            try {
                heartInGame = ImageIO.read(new File("Images/heartInGame.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return heartInGame;
    }


    public static Image getDialogueBox() {
        if (dialogueBox == null) {
            try {
                dialogueBox = ImageIO.read(new File("Images/dialogueBox.jpg"));
                boxScaledImage = dialogueBox.getScaledInstance(680, 500, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return boxScaledImage;
    }

    public static Image getLogo() {
        if (logo == null) {
            try {
                logo = ImageIO.read(new File("Images/Logo.png"));
                logoScaledImage = logo.getScaledInstance(450, 350, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logoScaledImage;
    }

    public static BufferedImage getPowerUp(int numberOfPowerUp) {
        switch (numberOfPowerUp) {
            case 1:
            case 3:
            case 2:
                return getPinkFlowerPowerUp();
            case 4:
            case 6:
            case 5:
                return getCloverPowerUp();
            case 7:
            case 8:
            case 9:
                return getWhalePowerUp();
            case 10:
            case 11:
            case 12:
                return getPizzaPowerUp();
            case 13:
                return getUnicornPowerUp();
        }
        return null;
    }

    public static BufferedImage getPinkFlowerPowerUp() {
        if (pinkFlowerPowerUp == null) {
            try {
                pinkFlowerPowerUp = ImageIO.read(new File("Images/PowerUps/pinkFlower.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pinkFlowerPowerUp;
    }

    public static BufferedImage getUnicornPowerUp() {
        if (unicornPowerUp == null) {
            try {
                unicornPowerUp = ImageIO.read(new File("Images/PowerUps/unicornMain.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return unicornPowerUp;
    }

    public static BufferedImage getWhalePowerUp() {
        if (whalePowerUp == null) {
            try {
                whalePowerUp = ImageIO.read(new File("Images/PowerUps/whale.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return whalePowerUp;
    }

    public static BufferedImage getCloverPowerUp() {
        if (cloverPowerUp == null) {
            try {
                cloverPowerUp = ImageIO.read(new File("Images/PowerUps/clover.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cloverPowerUp;
    }

    public static BufferedImage getLazorPowerUp() {
        if (lazorPowerUp == null) {
            try {
                lazorPowerUp = ImageIO.read(new File("Images/PowerUps/lazor.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lazorPowerUp;
    }

//    public static BufferedImage getSeaPowerUp() {
//        if(seaPowerUp == null){
//            try {
//                seaPowerUp = ImageIO.read(new File("Images/sea1.jpg"));
////                seaScaledImage = seaPowerUp.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return seaPowerUp;
//    }

    public static Image getBookOpen() {
        if (bookOpen == null) {
            try {
                bookOpen = ImageIO.read(new File("Images/bookOpen.png"));
                bookOpenedScaledImage = bookOpen.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bookOpenedScaledImage;
    }

    public static BufferedImage getBlackSplash() {
        if (blackSplash == null) {
            try {
                blackSplash = ImageIO.read(new File("Images/blackSplash.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return blackSplash;
    }

    public static BufferedImage getImmuneAura() {
        if (immuneAura == null) {
            try {
                immuneAura = ImageIO.read(new File("Images/aura1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return immuneAura;
    }

    public static BufferedImage getBoss() {
        if (boss == null) {
            try {
                boss = ImageIO.read(new File("Images/boss.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return boss;
    }

    public static BufferedImage getPizzaPowerUp() {
        if (pizzaPowerUp == null) {
            try {
                pizzaPowerUp = ImageIO.read(new File("Images/PowerUps/pizza.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pizzaPowerUp;
    }
}

