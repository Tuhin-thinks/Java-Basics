package SimpleTCP2;

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

        int secret_number= (int) (Math.random()*10 + 1);  // get a number between 1 and 10
        String message;
        int clients_integer;
        do {
            out_socket.println("Guess the number [from 1 to 10]: ");
            message = in_socket.readLine();
            clients_integer = Integer.parseInt(message);
            if (secret_number == clients_integer){
                out_socket.println("Wow, you guessed it right!");
                out_socket.println("\nBye!");
            }
            else if (secret_number < clients_integer){
                out_socket.println("You need to make your guess number lower!");
            }
            else {
                out_socket.println("You need to make your guess number higher!");
            }
        }while (secret_number != clients_integer);


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
