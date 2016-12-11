package ru.alibek;

import java.io.*;
import java.net.Socket;
import java.util.*;


public class ClientHandler implements Runnable {
    Socket sock;
    private BufferedReader reader;
    private PrintWriter writer;
    private ArrayList clientOutputStreams;
    private ChatServer chat;





    public ClientHandler(Socket clientSocket) {
        try {
            sock = clientSocket;
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            writer = new PrintWriter(sock.getOutputStream());
            writer.flush();
        }
        catch (Exception e) {e.printStackTrace();}
    }

    public void setChat(ChatServer chat) {
        this.chat = chat;
    }

    public void run() {
        writer.println("Hi User, enter your name");
        writer.flush();

        addUser();

        String message;
        try {
            while ((message = waitMessage()) != null) {
                System.out.println("read " + message);
                chat.tellEveryone(message, writer);
                writer.flush();
            }
        }catch (Exception e) {e.printStackTrace();}
    }

    private void addUser() {
        try {
            String message = waitMessage();
            User user = new User(message);
            chat.addUserToMap(user, writer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private String waitMessage() throws IOException {
        return reader.readLine();
    }









}












