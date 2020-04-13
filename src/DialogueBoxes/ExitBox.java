package DialogueBoxes;

import GamePlay.Game;
import Items.Colors;
import Items.Fonts;
import Items.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExitBox extends JFrame {

    private JLabel yesButton;
    private JLabel noButton;
    private boolean yesEntered = false, noEntered = false;

    public ExitBox() {
        super();

        init();

    }

    private void init() {
        this.setSize(680, 500);
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.setUndecorated(true);
        this.setOpacity((float) 0.8);
        this.setAlwaysOnTop(true);

        JLabel exitAskText = new JLabel("Are you sure you want to exit?", SwingConstants.CENTER);
        yesButton = new JLabel("YES", SwingConstants.CENTER);
        noButton = new JLabel("NO", SwingConstants.CENTER);

        exitAskText.setFont(Fonts.buttonsFont);
        yesButton.setFont(Fonts.buttonsFont);
        noButton.setFont(Fonts.buttonsFont);

        exitAskText.setBounds(50, 130, 580, 80);
        exitAskText.setForeground(Color.black);
        yesButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("click");
                yesEntered = true;

            }

            @Override
            public void mouseExited(MouseEvent e) {
                yesEntered = false;
            }
        });
        noButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ExitBox.super.dispose();
                Game.getGame().setInGame(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                ExitBox.super.dispose();
                Game.getGame().setInGame(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                noEntered = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                noEntered = false;
            }
        });
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(Images.getDialogueBox(), 0, 0, null);

                g2.setColor(Colors.buttonBorderColor);
                float thickness = 7;
                Stroke oldStroke = g2.getStroke();
                g2.setStroke(new BasicStroke(thickness));


                if (!yesEntered) {
                    yesButton.setBounds(50, 300, 200, 100);
                    g2.drawRoundRect(50, 300, 200, 100, 20, 20);
                    System.out.println("not pressed");
                    yesButton.setForeground(Color.BLACK);
                } else {
                    yesButton.setBounds(55, 305, 200, 100);
                    g2.drawRoundRect(55, 305, 200, 100, 20, 20);
                    System.out.println("press");
                    yesButton.setForeground(Colors.userButtonsColorMain);
                }
                if (!noEntered) {
                    noButton.setBounds(430, 300, 200, 100);
                    g2.drawRoundRect(430, 300, 200, 100, 20, 20);
                    noButton.setForeground(Color.BLACK);
                } else {
                    noButton.setBounds(435, 305, 200, 100);
                    g2.drawRoundRect(435, 305, 200, 100, 20, 20);
                    noButton.setForeground(Colors.userButtonsColorMain);
                }
                g2.setStroke(oldStroke);
                g2.setColor(Colors.buttonMainColor);

                g2.fillRoundRect(50, 300, 205, 105, 20, 20);
                g2.fillRoundRect(430, 300, 205, 105, 20, 20);
            }

        };

        panel.setSize(680, 500);


        panel.setLayout(null);
        panel.add(exitAskText);
        panel.add(yesButton);
        panel.add(noButton);

        this.add(panel);
    }
}
