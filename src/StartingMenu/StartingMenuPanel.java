package StartingMenu;

import DialogueBoxes.ExitBox;
import GamePlay.Game;
//import GamePlay.GameLoop;
//import GamePlay.GameLoop;
import GamePlay.GamePanel;
import Items.Colors;
import Items.Fonts;
import Items.Images;
import Mains.MainFrame;
import Mains.MainPanel;
import UserMenu.Authors;
import UserMenu.UserMenuPanel;
import UserMenu.UsernamesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartingMenuPanel extends JPanel {

//    private static StartingMenuPanel startingMenuPanel;
//
//    public static StartingMenuPanel getStartingMenuPanel() {
//        if (startingMenuPanel == null)
//            startingMenuPanel = new StartingMenuPanel();
//        return startingMenuPanel;
//    }

    private JLabel newGameButton, loadGameButton, backButton, nobelPrizesButton, exitButton;
    private JLabel halfLogo;
    private boolean newGameEntered = false, loadGameEntered = false, backEntered = false, nobelPrizesEntered = false, exitEntered = false;
    private boolean newGamePressed = false, loadGamePressed = false, backPressed = false, nobelPrizesPressed = false, exitPressed = false;
    private String username;
//    private ExitBox exitBox;

    public StartingMenuPanel() {

        super();
        init();
        setBounds(0, 0, 1920, 1080);

        this.setOpaque(false);
    }


    private void init() {


        newGameButton = new JLabel("New Game", SwingConstants.CENTER);
        loadGameButton = new JLabel("Load Game", SwingConstants.CENTER);
        backButton = new JLabel("Back", SwingConstants.CENTER);
        nobelPrizesButton = new JLabel("Nobel Prizes", SwingConstants.CENTER);
        exitButton = new JLabel("Exit", SwingConstants.CENTER);
//        System.out.println("username: " + getUsername());
//        System.out.println((Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername()));
//        setUsername((Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername()));
        halfLogo = new JLabel("Save The Brains, " + (Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername()) + "!", SwingConstants.CENTER);
//        Game.getGame().setAuthor(Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()));
        newGameButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newGamePressed = true;
                MainPanel.getMainPanel().removeAll();
                MainPanel.getMainPanel().revalidate();
                MainPanel.getMainPanel().repaint();

                GamePanel gamePanel = new GamePanel();
                MainPanel.getMainPanel().add(gamePanel);
                System.out.println("author in Game: " + Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()));
                System.out.println("username in Game: " + Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername());
                System.out.println("userFix Id in Game: " + Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUserID());
                System.out.println("idfix in Game2: " + Game.getGame().getIdFix());
                Game.getGame().getAuthor().initForNewGame();
                Game.getGame().start();


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                newGameEntered = true;
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newGameEntered = false;
                repaint();
                revalidate();
            }
        });
        loadGameButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadGamePressed = true;
                MainPanel.getMainPanel().removeAll();
                MainPanel.getMainPanel().revalidate();
                MainPanel.getMainPanel().repaint();

                GamePanel gamePanel = new GamePanel();
                MainPanel.getMainPanel().add(gamePanel);
                Game.getGame().start();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                loadGameEntered = true;
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loadGameEntered = false;
                repaint();
                revalidate();
            }
        });
        backButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backPressed = true;
                MainPanel.getMainPanel().removeAll();
                MainPanel.getMainPanel().revalidate();
                MainPanel.getMainPanel().repaint();
                Game.getGame().setIdFix(-Game.getGame().getIdFix() - 1);
                MainPanel.getMainPanel().add(UserMenuPanel.getUserMenuPanel());
                MainPanel.getMainPanel().add(UsernamesPanel.getUsernamesPanel());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                backEntered = true;
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backEntered = false;
                repaint();
                revalidate();
            }
        });
        nobelPrizesButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nobelPrizesPressed = true;
                MainPanel.getMainPanel().removeAll();
                MainPanel.getMainPanel().revalidate();
                MainPanel.getMainPanel().repaint();
                NobelPrizes nobelPrizes = new NobelPrizes();
                MainPanel.getMainPanel().add(nobelPrizes);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                nobelPrizesEntered = true;
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                nobelPrizesEntered = false;
                repaint();
                revalidate();
            }
        });
        exitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exitPressed = true;
                MainFrame.getMainFrame().getExitBox().setVisible(true);
//                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exitEntered = true;
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitEntered = false;
                repaint();
                revalidate();
            }
        });

        halfLogo.setBounds(700, 340, 450, 30);
        System.out.println("halfLogo middle");
        halfLogo.setFont(Fonts.logoFont);
        newGameButton.setFont(Fonts.buttonsFont);
        loadGameButton.setFont(Fonts.buttonsFont);
        backButton.setFont(Fonts.buttonsFont);
        nobelPrizesButton.setFont(Fonts.buttonsFont);
        exitButton.setFont(Fonts.buttonsFont);

//        this.add(halfLogo);
        this.add(newGameButton);
        this.add(loadGameButton);
        this.add(backButton);
        this.add(nobelPrizesButton);
        this.add(exitButton);

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(Images.getLogo(), 700, 20, null);
        g2.setFont(Fonts.logoFont);
        g2.setColor(Colors.userButtonsColorMain);
        g2.drawString("Save The Brains, " + (Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername()) + "!", 750, 365);
        float thickness = 7;
        g2.setColor(Colors.buttonBorderColor);
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        g2.setFont(Fonts.buttonsFont);


        if (!newGameEntered) {
            newGameButton.setBounds(800, 400, 250, 80);
            g2.drawRoundRect(800, 400, 250, 80, 20, 20);
            newGameButton.setForeground(Color.black);
        } else {
            newGameButton.setBounds(805, 405, 250, 80);
            g2.drawRoundRect(805, 405, 250, 80, 20, 20);
            newGameButton.setForeground(Colors.userButtonsColorMain);
        }
        if (!loadGameEntered) {
            loadGameButton.setBounds(800, 550, 250, 80);
            g2.drawRoundRect(800, 550, 250, 80, 20, 20);
            loadGameButton.setForeground(Color.black);
        } else {
            loadGameButton.setBounds(805, 555, 250, 80);
            g2.drawRoundRect(805, 555, 250, 80, 20, 20);
            loadGameButton.setForeground(Colors.userButtonsColorMain);
        }
        if (!nobelPrizesEntered) {
            nobelPrizesButton.setBounds(800, 700, 250, 80);
            g2.drawRoundRect(800, 700, 250, 80, 20, 20);
            nobelPrizesButton.setForeground(Color.black);
        } else {
            nobelPrizesButton.setBounds(805, 705, 250, 80);
            g2.drawRoundRect(805, 705, 250, 80, 20, 20);
            nobelPrizesButton.setForeground(Colors.userButtonsColorMain);
        }
        if (!backEntered) {
            backButton.setBounds(800, 850, 250, 80);
            g2.drawRoundRect(800, 850, 250, 80, 20, 20);
            backButton.setForeground(Color.black);
        } else {
            backButton.setBounds(805, 855, 250, 80);
            g2.drawRoundRect(805, 855, 250, 80, 20, 20);
            backButton.setForeground(Colors.userButtonsColorMain);
        }
        if (!exitEntered) {
            exitButton.setBounds(200, 850, 250, 80);
            g2.drawRoundRect(200, 850, 250, 80, 20, 20);
            exitButton.setForeground(Color.black);
        } else {
            exitButton.setBounds(205, 855, 250, 80);
            g2.drawRoundRect(205, 855, 250, 80, 20, 20);
            exitButton.setForeground(Colors.userButtonsColorMain);
        }

        g2.setStroke(oldStroke);
        g2.setColor(Colors.buttonMainColor);

        g2.fillRoundRect(800, 400, 255, 85, 20, 20);
        g2.fillRoundRect(800, 550, 255, 85, 20, 20);
        g2.fillRoundRect(800, 700, 255, 85, 20, 20);
        g2.fillRoundRect(800, 850, 255, 85, 20, 20);
        g2.fillRoundRect(200, 850, 255, 85, 20, 20);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
