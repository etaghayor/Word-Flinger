package UserMenu;

import DialogueBoxes.AddUserBox;
import GamePlay.Game;
import Items.*;
//import Items.JLabel;
import Mains.MainPanel;
import StartingMenu.StartingMenuPanel;
import User.Author;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class UserMenuPanel extends JPanel {

    private static UserMenuPanel userMenuPanel;

    public static UserMenuPanel getUserMenuPanel() {
        if (userMenuPanel == null)
            userMenuPanel = new UserMenuPanel();
        return userMenuPanel;
    }

    private StartingMenuPanel startingMenuPanel;
    private JLabel addUserButton, removeUserButton, selectUserButton;
    private boolean addUserEntered = false, removeUserEntered = false, selectUSerEntered = false;
    private boolean addUserPressed = false, removeUserPressed = false, selectUSerPressed = false;
    public AddUserBox addUserBox;
    private JLabel button;
    private int usernameNumber = 0;

    public UserMenuPanel() {
        super();
        init();
        setBounds(0, 0, 700, 1080);
        setLayout(null);
//        Game.getGame().start();
        setOpaque(false);
    }

    private void init() {


        addUserButton = new JLabel("Add User", SwingConstants.CENTER);
        removeUserButton = new JLabel(" Remove User", SwingConstants.CENTER);
        selectUserButton = new JLabel("Select User", SwingConstants.CENTER);

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                repaint();
                revalidate();
            }
        });
        addUserButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addUserPressed = true;
                addUserBox = new AddUserBox();
                addUserBox.setVisible(true);
                selectUSerEntered = false;
                repaint();
                revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addUserEntered = true;
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addUserEntered = false;
                repaint();
                revalidate();
            }
        });
        removeUserButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UsernamesPanel.getUsernamesPanel().getUsernamesLabels().remove(Game.getGame().getIdFix());
//                Game.getGame().getAuthors().deleteAuthor(Game.getGame().getIdFix());
                Game.getGame().getAuthors().getAuthorsArray().remove(Game.getGame().getIdFix());
                Game.getGame().getAuthors().writeFile();
                UsernamesPanel.getUsernamesPanel().addUserLabels();
                UsernamesPanel.getUsernamesPanel().setOneUserSelected(false);
                for(Author author : Game.getGame().getAuthors().getAuthorsArray()){
                    System.out.println(author.getUsername());
                }
                removeUserPressed = true;
                selectUSerPressed = false;
                selectUSerEntered = false;
                repaint();
                revalidate();
                MainPanel.getMainPanel().repaint();
                MainPanel.getMainPanel().revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                repaint();
                revalidate();
                removeUserEntered = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                removeUserEntered = false;
                repaint();
                revalidate();
            }
        });
        selectUserButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Game.getGame().getIdFix()>=0) {
                    selectUSerPressed = true;
                    startingMenuPanel = new StartingMenuPanel();
                    MainPanel.getMainPanel().removeAll();
                    MainPanel.getMainPanel().revalidate();
                    MainPanel.getMainPanel().repaint();
                    startingMenuPanel.setUsername(Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername());
//                    System.out.println((Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername()));
//                    System.out.println(" * " + startingMenuPanel.getUsername());
                    MainPanel.getMainPanel().add(startingMenuPanel);
                    selectUSerEntered = false;
                    repaint();
                    revalidate();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                selectUSerEntered = true;
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectUSerEntered = false;
                repaint();
                revalidate();
            }
        });

        addUserButton.setFont(Fonts.buttonsFont);
        removeUserButton.setFont(Fonts.buttonsFont);
        selectUserButton.setFont(Fonts.buttonsFont);



        add(addUserButton);
        add(removeUserButton);
        add(selectUserButton);
    }

    @Override
    public void paintComponent(Graphics g) {
//        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Colors.buttonBorderColor);
        float thickness = 7;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));

        if (!addUserEntered) {
            addUserButton.setBounds(300, 170, 250, 110);
            g2.drawRoundRect(300, 170, 250, 110, 20, 20);
            addUserButton.setForeground(Color.BLACK);
        } else {
            addUserButton.setBounds(305, 175, 250, 110);
            g2.drawRoundRect(305, 175, 250, 110, 20, 20);
            addUserButton.setForeground(Colors.userButtonsColorMain);
        }
        if (!removeUserEntered) {
            removeUserButton.setBounds(300, 370, 250, 110);
            g2.drawRoundRect(300, 370, 250, 110, 20, 20);
            removeUserButton.setForeground(Color.BLACK);
        } else {
            removeUserButton.setBounds(305, 375, 250, 110);
            g2.drawRoundRect(305, 375, 250, 110, 20, 20);
            removeUserButton.setForeground(Colors.userButtonsColorMain);
        }
        if (!selectUSerEntered) {
            selectUserButton.setBounds(300, 570, 250, 110);
            g2.drawRoundRect(300, 570, 250, 110, 20, 20);
            selectUserButton.setForeground(Color.BLACK);
        } else {
            selectUserButton.setBounds(305, 575, 250, 110);
            g2.drawRoundRect(305, 575, 250, 110, 20, 20);
            selectUserButton.setForeground(Colors.userButtonsColorMain);
        }
        g2.setStroke(oldStroke);

        g2.setColor(Colors.buttonMainColor);
        g2.fillRoundRect(300, 170, 255, 115, 20, 20);
        g2.fillRoundRect(300, 370, 255, 115, 20, 20);
        g2.fillRoundRect(300, 570, 255, 115, 20, 20);

    }

}
