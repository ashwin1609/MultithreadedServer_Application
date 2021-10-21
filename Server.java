import java.io.*;
import java.net.*;
import java.lang.Math;

public class Server {
    public static ServerSocket sSocket;
    public static Socket cSocket;
    public static DataOutputStream output;
    public static DataInputStream input;

    public static double Add(double a, double b) {
        return a + b;
    }

    public static double Subtract(double a, double b) {
        return a - b;
    }

    public static double Multiply(double a, double b) {
        return a * b;
    }

    public static double Divide(double a, double b) {
        return a / b;
    }

    public static double exponent(double a, double b) {
        return Math.pow(a, b);
    }

    public static void main(String[] args) throws Exception {
        new Server();
    }

    public Server() throws Exception {

        // connection
        sSocket = new ServerSocket(9600);
        // System.out.println(" connection made");
        sSocket.setReuseAddress(true);

        while (true) {
            int count = 0;
            // Accepting client socket
            Socket cSocket = sSocket.accept();
            System.out.println("Client" + (++count) + "Connected " + cSocket.getInetAddress().getHostAddress());
            count++;
            // creating a thread object
            ClientHandler clientSock = new ClientHandler(cSocket);
            new Thread(clientSock).start();

        }

    }

    public static class ClientHandler implements Runnable {
        public final Socket clientSocket;

        // constructor
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                input = new DataInputStream(clientSocket.getInputStream());
                output = new DataOutputStream(clientSocket.getOutputStream());

                System.out.println("Message from Client : " + input.readUTF());

                int choice = 0;
                // choices for the client
                while (choice != -1) {
                    output.writeUTF("** Welcome to Client-Server based Calculator **");
                    output.flush();
                    output.writeUTF("Select one of the operation from the following choices : ");
                    output.flush();
                    output.writeUTF("Enter 1 to perform add operation : ");
                    output.flush();
                    output.writeUTF("Enter 2 to perform subtract operation : ");
                    output.flush();
                    output.writeUTF("Enter 3 to perform multiply operation : ");
                    output.flush();
                    output.writeUTF("Enter 4 to perform division operation : ");
                    output.flush();
                    output.writeUTF("Enter 5 to perform exponent operation : ");
                    output.flush();
                    output.writeUTF("Enter -1 to close the application : ");
                    output.flush();
                    choice = input.readInt();

                    // choice
                    if (choice == 1) {
                        output.writeUTF("Enter 2 numbers : ");
                        output.flush();
                        double a = input.readDouble();
                        double b = input.readDouble();
                        double result = Add(a, b);
                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Sending the answer to client");
                        output.writeUTF("Result is : " + result + "\n");
                        output.flush();

                    } else if (choice == 2) {
                        output.writeUTF("Enter 2 numbers : ");
                        output.flush();
                        double a = input.readDouble();
                        double b = input.readDouble();
                        double result = Subtract(a, b);
                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Sending the answer to client");
                        output.writeUTF("Result is : " + result + "\n");
                        output.flush();

                    } else if (choice == 3) {
                        output.writeUTF("Enter 2 numbers : ");
                        output.flush();
                        double a = input.readDouble();
                        double b = input.readDouble();
                        double result = Multiply(a, b);
                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Sending the answer to client");
                        output.writeUTF("Result is : " + result + "\n");
                        output.flush();

                    } else if (choice == 4) {
                        output.writeUTF("Enter 2 numbers : ");
                        output.flush();
                        double a = input.readDouble();
                        double b = input.readDouble();
                        double result = Divide(a, b);
                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Sending the answer to client");
                        output.writeUTF("Result is : " + result + "\n");
                        output.flush();

                    } else if (choice == 5) {
                        output.writeUTF("Enter 2 numbers : ");
                        output.flush();
                        double a = input.readDouble();
                        double b = input.readDouble();
                        double result = Divide(a, b);
                        System.out.println("The inputs I got are: " + a + " and " + b);
                        System.out.println("Sending the answer to client");
                        output.writeUTF("Result is : " + result + "\n");
                        output.flush();

                    } else {
                        output.writeUTF("Invalid choice: ");
                        output.flush();

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}