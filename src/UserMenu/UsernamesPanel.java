package UserMenu;

import GamePlay.Game;
import Mains.MainFrame;
import Mains.MainPanel;
import User.Author;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UsernamesPanel extends JPanel {

    private static UsernamesPanel usernamesPanel;
    private ArrayList<AuthorLabel> usernamesLabels = new ArrayList<>();
    private ArrayList<Author> authors;
    private boolean oneUserSelected = false;
    private int id = 0;
    private int idFix;
    private String userNameFix;

    public static UsernamesPanel getUsernamesPanel() {
        if (usernamesPanel == null)
            usernamesPanel = new UsernamesPanel();
        return usernamesPanel;
    }

    public UsernamesPanel() {

        super();
        setBounds(700, 0, 1220, 1080);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setOpaque(false);
//        addUserLabels();
        init();
//        addUserLabels();

    }

    private AuthorLabel authorLabel;

    private void init() {

        setId(-getId() -1 );
        authors = Game.getGame().getAuthors().getAuthorsArray();
//        Game.getGame().getAuthors().getAuthorsArray().clear();
//        Game.getGame().getAuthors().writeFile();
//        Game.getGame().getAuthors().readFile();
        this.add(Box.createGlue());
        if (authors.size() > 0)
            for (Author author : authors) {
//            System.out.println(author.getUsername());
                setId(1);
                AuthorLabel labels = new AuthorLabel(author.getUsername(), getId());
                this.add(labels);
                usernamesLabels.add(labels);
                this.add(Box.createGlue());
            }

    }

    public void addAuthorLabelToArray(String username, int id) {
        authorLabel = new AuthorLabel(username, id);
        usernamesLabels.add(authorLabel);
    }

    private void clear() {
        removeAll();
        usernamesLabels.clear();
    }

    public void addUserLabels() {

        this.clear();
        setId(-getId() -1);
//        authors = Authors.getAuthors().getAuthorsArray();
        authors = Game.getGame().getAuthors().getAuthorsArray();
        this.add(Box.createGlue());
        for (Author author : authors) {
            System.out.println(author.getUsername());
            setId(1);
            AuthorLabel labels = new AuthorLabel(author.getUsername(), getId());
            this.add(labels);
            usernamesLabels.add(labels);
            this.add(Box.createGlue());
        }
    }

    public boolean isOneUserSelected() {
        return oneUserSelected;
    }

    public void setOneUserSelected(boolean oneUserSelected) {
        this.oneUserSelected = oneUserSelected;
    }

    public ArrayList<AuthorLabel> getUsernamesLabels() {
        return usernamesLabels;
    }

    public void setId(int idDelta) {
        this.id += idDelta;
    }

    public int getId() {
        return id;
    }

//    public void setIdFix(int idFix) {
//        this.idFix = idFix;
//    }
//
//    public int getIdFix() {
//        return idFix;
//    }


    public String getUserNameFix() {
        return userNameFix;
    }

    public void setUserNameFix(String userNameFix) {
        this.userNameFix = userNameFix;
    }
}



