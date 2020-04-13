package Mains;


import Items.Images;
import UserMenu.UserMenuPanel;
import UserMenu.UsernamesPanel;
//import UserMenu.UsernamesPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private static MainPanel mainPanel;

    public static MainPanel getMainPanel() {
        if (mainPanel == null)
            mainPanel = new MainPanel();
        return mainPanel;
    }
    private int i = -1200;

    private MainPanel() {
        super();
        init();

        Dimension dimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimMax);

    }
    private void init() {

        this.setLayout(null);
        initForUsersMenu();
        initForUserNamesPanel();

    }

    private void initForUserNamesPanel() {
        this.add(UsernamesPanel.getUsernamesPanel());

    }

    private void initForUsersMenu() {

        this.add(UserMenuPanel.getUserMenuPanel());



    }


    public void setI(int delta) {
        this.i += delta;
        if (this.i >= 0)
            this.i = -2400;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(Images.getBackgroundImage(), 0, i,1920, 3600 , null);
    }

}
