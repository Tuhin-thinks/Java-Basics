package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public client() throws Exception{
        Socket clientSocket = new Socket("localhost", 2020);
        System.out.println("Connected to the server....");
        BufferedReader in_socket = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

        String message = in_socket.readLine();
        System.out.println("[Server]: "+ message +"");

        out_socket.println("Bye!");

        clientSocket.close();
        System.out.println("Socket closed...");
    }

    public static void main(String[] args) {
        try{
            new client();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
