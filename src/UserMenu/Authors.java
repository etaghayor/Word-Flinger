package UserMenu;

import GamePlay.Game;
import User.Author;

import java.io.*;
import java.util.*;

public class Authors implements Serializable {


    private Author author;
    private ArrayList<Author> authorsArray = new ArrayList<>();
    private int lastID;

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private FileOutputStream fileOutputStream;

    public Authors() {

//        addAuthor("ian");
        try {

            readFile();
//            authorsArray.add(new Author("Elle", 1));
            writeFile();
        } catch (Exception e) {
            System.out.println("problem loading users");
            e.printStackTrace();
        }
//
    }

    public void addAuthor(String username) {
        authorsArray.add(new Author(username, this.lastID));
        System.out.println("LAst Id: " + lastID);
        setLastID(1);
        writeFile();
    }


    public void deleteAuthor(int id) {
        for (Author author : authorsArray)
            if (author.getUserID() == id) {
                authorsArray.remove(author);
                break;
            }
        writeFile();
    }


    public Author getAuthor() {
        author = getAuthorsArray().get(Game.getGame().getIdFix());
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ArrayList<Author> getAuthorsArray() {
        return authorsArray;
    }

    public void writeFile() {

        try {
            fileOutputStream = new FileOutputStream("src/GamePlay/GameData");
            output = new ObjectOutputStream(fileOutputStream);
//            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
//            for (Animatable animatable : Game.getGame().getItems())
//                if (animatable instanceof BossBrain || (animatable instanceof AnimatableForBrainGroups && ((AnimatableForBrainGroups) animatable).getBrains().size() != 0))
//                    output.writeObject(animatable);
            output.writeObject(authorsArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/GamePlay/GameData");
            input = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        authorsArray.clear();  /*test*/
//        while (true) {
//            try {
//                authorsArray.add((Author) input.readObject());
//
//            } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//                break;
//            }
//        }
//        ArrayList<Author> authorsArray = new ArrayList<>();
        try {
            authorsArray = ((ArrayList<Author>) input.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            input.close();
            if (output != null)
                output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLastID(int id) {
        lastID += id;
    }

    public int getLastId() {
        return lastID;
    }

}