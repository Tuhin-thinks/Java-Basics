package SimpleTCP2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public client() throws Exception{
        Socket clientSocket = new Socket("localhost", 2020);
        System.out.println("Connected to the server....");
        BufferedReader in_socket = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

        Scanner keyboard = new Scanner(System.in);
        String user_number, server_response;

        while ((in_socket.readLine().startsWith("Guess"))){
            System.out.print("[Server] Guess a number from 1-10: ");
            user_number = keyboard.nextLine();
            out_socket.println(user_number);
            server_response = in_socket.readLine();
            System.out.println("\t[comment]: "+ server_response +"\n");
        }

        System.out.println("Guess complete...");

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
