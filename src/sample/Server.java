package sample;

import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private ServerSocket serverSocket;
    public HashMap<String, NetworkUtil> clientMap;

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws Exception {
        NetworkUtil nc = new NetworkUtil(clientSocket);
        String clientName = (String) nc.read();
        System.out.println(clientName);
        clientMap.put(clientName, nc);
        new ReadThread(clientName,clientMap);

    }

    public static void main(String[] args) {
        Server server = new Server();
    }

}
