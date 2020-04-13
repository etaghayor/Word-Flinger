package Mains;

//import GamePlay.GamePanel;


import DialogueBoxes.ExitBox;
import UserMenu.Authors;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ExitBox exitBox = new ExitBox();

    public static MainFrame getMainFrame() {
        if (mainFrame == null)
            mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        return mainFrame;
    }

    private static MainFrame mainFrame;
    private MainFrame() {
        super();
        init();

    }

    private void init() {


        setTitle("Word Flinger");

        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(DimMax);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(MainPanel.getMainPanel());
    }


    public ExitBox getExitBox() {
        return exitBox;
    }
}
