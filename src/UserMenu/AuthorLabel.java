package UserMenu;

import GamePlay.Game;
import Items.Colors;
import Items.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class AuthorLabel extends JLabel {

    private String username;
    private Boolean clicked = false;
    private int id;

    private boolean pressed = false;

    AuthorLabel(String username, int id) {
        super(username);
        this.username = username;
        this.id = id;

        this.setForeground(Colors.userButtonsColorMain);
        this.setFont(Fonts.usersFont);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!isClicked() & !UsernamesPanel.getUsernamesPanel().isOneUserSelected()) {
                    setClicked(true);
                    Game.getGame().setIdFix(id);
                    System.out.println("label id:" + Game.getGame().getIdFix());
                    System.out.println("label id user: " + Game.getGame().getAuthors().getAuthorsArray().get(Game.getGame().getIdFix()).getUsername());

                    UsernamesPanel.getUsernamesPanel().setUserNameFix(username);
                    UsernamesPanel.getUsernamesPanel().setOneUserSelected(true);
                    setForeground(Color.yellow);

//                } else if (!isClicked() & UsernamesPanel.getUsernamesPanel().isOneUserSelected()) {
//                    setClicked(true);
//                    setForeground(Color.yellow);
                } else if (isClicked() & UsernamesPanel.getUsernamesPanel().isOneUserSelected()) {
                    setClicked(false);
                    Game.getGame().setIdFix(-Game.getGame().getIdFix() - 1);
                    UsernamesPanel.getUsernamesPanel().setUserNameFix(null);
                    UsernamesPanel.getUsernamesPanel().setOneUserSelected(false);
                    setForeground(Colors.userButtonsColorMain);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!isClicked()) {

                    setForeground(Color.orange);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (!isClicked()) {

                    setForeground(Colors.userButtonsColorMain);
                }

            }
        });
        this.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    private boolean isClicked() {
        return clicked;
    }

    private boolean setClicked(boolean clicked) {
        this.clicked = clicked;
        return clicked;
    }
}

