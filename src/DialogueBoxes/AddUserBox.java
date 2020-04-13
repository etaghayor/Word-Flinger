package DialogueBoxes;

import GamePlay.Game;
import Items.Fonts;
import Items.Images;
import Mains.MainPanel;
import User.Author;
import UserMenu.UsernamesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

public class AddUserBox extends JFrame {

    private JTextField usernameTextfield;
    private String name;
    private int id = UsernamesPanel.getUsernamesPanel().getId() + 1;


    public AddUserBox() {
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


        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.drawImage(Images.getDialogueBox(), 0, 0, null);
            }
        };

        panel.setSize(680, 500);

        usernameTextfield = new JTextField("Username" + (id + 1));

        JLabel okButton = new JLabel("OK!");

        usernameTextfield.setFont(Fonts.gameItemsFont);
        okButton.setFont(Fonts.userItemsFont);
        okButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = usernameTextfield.getText();
                Game.getGame().getAuthors().getAuthorsArray().add(new Author(username, id));
                Game.getGame().getAuthors().writeFile();
                UsernamesPanel.getUsernamesPanel().addAuthorLabelToArray(username, id);
                UsernamesPanel.getUsernamesPanel().addUserLabels();
                MainPanel.getMainPanel().revalidate();
                MainPanel.getMainPanel().repaint();
                AddUserBox.super.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

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

        panel.setLayout(null);
        usernameTextfield.setBounds(120, 200, 120, 50);
        panel.add(usernameTextfield);
        okButton.setBounds(480, 190, 100, 100);
        panel.add(okButton);
        Shape shape = new RoundRectangle2D.Double(0, 0, 680, 500, 30, 30);
        this.setShape(shape);
        this.add(panel);
        this.setVisible(true);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
