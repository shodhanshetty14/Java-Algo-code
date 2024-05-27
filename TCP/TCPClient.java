
import java.util.*;
import java.net.*;
import java.io.*;

class TCPClient {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 4321);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Connected to 127.0.0.1 \n");
            System.out.println(dis.readUTF());
            System.out.print("Enter The Path Of The File : ");
            String path = sc.nextLine();
            dos.writeUTF(path);
            System.out.println(new String(dis.readUTF()));
            dis.close();
            dos.close();
            sc.close();
            s.close();
        } catch (IOException e) {
            System.out.println("IO : " + e.getMessage());
        }
    }
}