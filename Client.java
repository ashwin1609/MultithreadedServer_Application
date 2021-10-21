import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static Socket cSocket;
    public static DataOutputStream output;
    public static DataInputStream input;

    public static void main(String[] args) {

        try {
            // Socket connection
            cSocket = new Socket("127.0.0.1", 9600);
            // Writing to server
            output = new DataOutputStream(cSocket.getOutputStream());
            output.writeUTF("Connection is established : ");
            output.flush();

            // Reading from server
            input = new DataInputStream(cSocket.getInputStream());

            // Scanner object to take input from user
            Scanner scan = new Scanner(System.in);

            int choice = 0;
            while (choice != -1) {
                System.out.println("Message from server : " + input.readUTF());
                System.out.println(input.readUTF());
                System.out.println(input.readUTF());
                System.out.println(input.readUTF());
                System.out.println(input.readUTF());
                System.out.println(input.readUTF());
                System.out.println(input.readUTF());
                System.out.println(input.readUTF());
                System.out.println("Enter your choice : ");
                choice = scan.nextInt();

                output.writeInt(choice);
                output.flush();

                if (choice == 1) {

                    System.out.println(input.readUTF());
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    output.writeDouble(a);
                    output.flush();
                    output.writeDouble(b);
                    output.flush();
                    System.out.println(input.readUTF());
                } else if (choice == 2) {

                    System.out.println(input.readUTF());
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    output.writeDouble(a);
                    output.flush();
                    output.writeDouble(b);
                    output.flush();
                    System.out.println(input.readUTF());

                } else if (choice == 3) {

                    System.out.println(input.readUTF());
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    output.writeDouble(a);
                    output.flush();
                    output.writeDouble(b);
                    output.flush();
                    System.out.println(input.readUTF());
                } else if (choice == 4) {

                    System.out.println(input.readUTF());
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    output.writeDouble(a);
                    output.flush();
                    output.writeDouble(b);
                    output.flush();
                    System.out.println(input.readUTF());
                } else if (choice == 5) {

                    System.out.println(input.readUTF());
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    output.writeDouble(a);
                    output.flush();
                    output.writeDouble(b);
                    output.flush();
                    System.out.println(input.readUTF());
                } else {
                    System.out.println("Invalid choice");
                }
            }
            scan.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}