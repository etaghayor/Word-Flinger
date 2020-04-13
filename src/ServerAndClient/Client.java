package ServerAndClient;

import GamePlay.Word;
import Mains.MainPanel;
import User.Author;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    Socket mSocket;
//    int port = 9090;
//    String serverAddress = "127.0.0.1";

    InputStream fromServerStream;
    OutputStream toServerStream;

    private ArrayList<String> authors, words, brains, boss, blackSplashes, wordPowerUps, hearts;
    private Author author;
    Scanner reader;
    PrintStream writer;

    public Client(String ip, int port, boolean isObserver) {

        authors = new ArrayList<>();
        words = new ArrayList<>();
        brains = new ArrayList<>();
        boss = new ArrayList<>();
        blackSplashes = new ArrayList<>();
        wordPowerUps = new ArrayList<>();
        hearts = new ArrayList<>();

        try {

            mSocket = new Socket(ip, port);

            System.out.println("connect to server ....");
            fromServerStream = mSocket.getInputStream();
            toServerStream = mSocket.getOutputStream();

            reader = new Scanner(fromServerStream);
            writer = new PrintStream(toServerStream, true);

            reader.nextLine();

//            System.out.println("Server :" + msg);
            Thread thread = new Thread(() -> {

                writer.println(author.getUsername());
                int id = reader.nextInt();
                reader.nextLine();
                while (true) {
                    writer.println("get");
                    int number;

                    number = reader.nextInt();
                    reader.nextLine();
                    words.clear();
                    for (int i = 0; i < number; i++)
                        words.add(reader.nextLine());
                    number = reader.nextInt();
                    reader.nextLine();
                    brains.clear();
                    for (int i = 0; i < number; i++)
                        brains.add(reader.nextLine());
                    number = reader.nextInt();
                    reader.nextLine();
                    boss.clear();
                    for (int i = 0; i < number; i++)
                        boss.add(reader.nextLine());
                    number = reader.nextInt();
                    reader.nextLine();
                    blackSplashes.clear();
                    for (int i = 0; i < number; i++)
                        blackSplashes.add(reader.nextLine());
                    number = reader.nextInt();
                    reader.nextLine();
                    wordPowerUps.clear();
                    for (int i = 0; i < number; i++)
                        wordPowerUps.add(reader.nextLine());
                    number = reader.nextInt();
                    reader.nextLine();
                    hearts.clear();
                    for (int i = 0; i < number; i++)
                        hearts.add(reader.nextLine());
                    MainPanel.getMainPanel().repaint();
                    MainPanel.getMainPanel().revalidate();

                }


            });
            thread.start();

//            Thread t=new Thread(new ServerMessagesManager(reader));
//            t.start();


//            menu();

        } catch (UnknownHostException e) {
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void menu() {


        while (true) {
        }
    }

    private void sendName(String name) {
        writer.println(name);
    }

    private void sendSingleCht(String to, String text) {
        writer.println("SCHT");
        writer.println(to);
        writer.println(text);
    }
}
