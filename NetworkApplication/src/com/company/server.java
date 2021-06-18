package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(2020);  // opening a new port
        System.out.println("Port 2020 has been opened.");

        Socket socket = serverSocket.accept();  // accept incoming connection
        System.out.println("Client "+ socket.getInetAddress() +" has connected...");

        // I/O buffers
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        out_socket.println("Welcome to the server...");  // send welcome message to the client
        String client_response = in_socket.readLine();
        System.out.println("[Client]: "+ client_response +"\n-----------------------------------\n");

        socket.close();  // close the socket
        System.out.println("Socket is closed");

    }

    public static void main(String[] args) {


        try{
            new server();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
