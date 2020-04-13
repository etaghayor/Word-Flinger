package ServerAndClient;

import User.Author;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ClientManager extends Thread {
    Socket clientHolder;
    Server serverHolder;
    InputStream fromClientStream;
    OutputStream toClientStream;

    Scanner reader;
    PrintWriter writer;
    String name;
    Author author;

    public ClientManager(Server server, Socket client) {
        serverHolder = server;
        clientHolder = client;

    }

    public void run() {
        try {
            fromClientStream = clientHolder.getInputStream();

            toClientStream = clientHolder.getOutputStream();

            reader = new Scanner(fromClientStream);
            writer = new PrintWriter(toClientStream, true);

            author = new Author(reader.next(), Integer.valueOf(reader.next()));
            reader.nextLine();

//            serverHolder.addClientManager(name, this);

            while (true) {

                String command = reader.next();



            }
        } catch (Exception e) {
        }
    }


    private void sendTextToAnotherClient(String to, String text) {
        ClientManager anotherClient = serverHolder.findClientManager(to);
        if (anotherClient == null)
            return;
        anotherClient.sendText(name, text);
    }

    private void sendText(String from, String text) {
        writer.println("CHT");
        writer.println(from);
        writer.println(text);
    }
}
