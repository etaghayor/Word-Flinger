package GamePlay;

import Items.Fonts;
import Items.Images;
import Mains.MainFrame;
import Mains.MainPanel;
import User.Author;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {



    private int frameHeight = MainPanel.getMainPanel().getHeight();
    private Author author = Game.getGame().getAuthor();
    private Game game = Game.getGame();
    private static GamePanel gamePanel;

    static GamePanel getGamePanel() {
        if (gamePanel == null)
            gamePanel = new GamePanel();
        return gamePanel;
    }

    public GamePanel() {
        super();
        Dimension dimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimMax);
        setOpaque(false);
        this.setLayout(null);
        init();

    }

    private void init() {
        this.setFocusable(true);
//        System.out.println("init");
        MainFrame.getMainFrame().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 27) {
//                    System.out.println("key");
                    MainFrame.getMainFrame().getExitBox().setVisible(true);
                    Game.getGame().setInGame(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    author.write();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3)
                    author.writeBook();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    author.write();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                author.write();
                author.moveTo(e.getX() - 50, e.getY() - 80);
                repaint();
                revalidate();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                author.moveTo(e.getX() - 50, e.getY() - 80);
                repaint();
                revalidate();
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        game.paint(g2);
        if (author.isImmune())
            g2.drawImage(Images.getImmuneAura(), (int) author.getX() - 38, (int) author.getY() - 30, null);

//        author.paint(g2);
//        for (Animatable animatable : copyOfItems)
//            animatable.paint(g2);


        g2.setColor(Color.black);
        g2.fillRoundRect(700, 20, Game.getGame().getBossLife() * 4, 30, 20, 20);
//        g2.drawImage(Images.getLazorPowerUp(), 500, 0 , null);
        g2.setColor(new Color(241, 233, 152, 90));
//        g2.fillOval(10, MainPanel.getMainPanel().getHeight() - 80, 450, 80);
        g2.fillRoundRect(10, frameHeight - 90, 480, 80, 10, 10);
        g2.setColor(new Color(241, 233, 152));
        g2.drawRoundRect(10, frameHeight - 90, 480, 80, 10, 10);

        g2.setFont(Fonts.userItemsFont);
        g2.drawString(Integer.toString(author.getUserHappiness()), 20, 110);

        g2.drawImage(Images.getLife(), 15, frameHeight - 90, null);
        g2.drawString(Integer.toString(author.getUserLife()), 100, frameHeight - 40);
        g2.drawImage(Images.getBook(), 170, frameHeight - 85, null);
        g2.drawString(Integer.toString(author.getUserBook()), 270, frameHeight - 40);
        g2.drawImage(Images.getHeart(), 340, frameHeight - 75, null);
        g2.drawString(Integer.toString(author.getUserHearts()), 430, frameHeight - 40);

        g2.setColor(Color.ORANGE);
        g2.drawRoundRect(17, 17, 261, 56, 20, 20);
        g2.setFont(Fonts.userItemsFont);
        g2.setColor(new Color(241, 233, 152));
        Color fatigueColor = new Color(Math.abs(author.getFatigue() / 4), Math.abs(255 - (author.getFatigue() / 4)), 10);
        g2.setColor(fatigueColor);
        g2.fillRoundRect(20, 20, author.getFatigue() / 4, 50, 20, 20);
    }

    public void paintLevel1(Graphics2D g2) {

    }
}
