package ru.alibek;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class ChatServer {
    ArrayList clientOutputStreams;
    private ServerSocket serverSocket;
    public Map<String, User> userHashMap;


    public ChatServer() {
        try {
            this.serverSocket = new ServerSocket(5000);
            userHashMap = new HashMap<String, User>();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void go() {
        clientOutputStreams = new ArrayList();
        try {
            while (true) {
                Socket  clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.setChat(this);
                Thread t = new Thread(clientHandler);
                t.start();
                System.out.println("got a connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addUserToMap(User user, PrintWriter writer) {
        userHashMap.put(user.getName(), user);

    }



    public void tellEveryone(String message, PrintWriter writer) {
        for ( Map.Entry<String, User> entry : userHashMap.entrySet()) {
            //writer.println("Asdfadf");
            //writer.flush();
            String name = entry.getKey();
            User user = entry.getValue();
            if(!user.isMe(name)) {
                writer.println(message);
                writer.flush();
            }
            else continue;
        }

    }








    public static void main(String[] args) {
        new ChatServer().go();
    }

}












