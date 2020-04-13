package StartingMenu;

import GamePlay.Game;
import User.Author;

import javax.swing.*;
import java.util.ArrayList;

public class NobelPrizes extends JPanel {

    private ArrayList<JLabel> nobelists = new ArrayList<>();

    public NobelPrizes() {

        super();
        init();

        setBounds(0, 0, 1920, 1080);
        this.setOpaque(false);

    }

    private void init() {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(Box.createGlue());

        ArrayList<Author> array = Game.getGame().getAuthors().getAuthorsArray();
        for (int i = 0; i < array.size(); i++) {
            JLabel nobelistLabel = new JLabel(array.get(i).getUsername(), SwingConstants.CENTER);
            this.add(nobelistLabel);
            this.add(Box.createGlue());
        }


    }

}
