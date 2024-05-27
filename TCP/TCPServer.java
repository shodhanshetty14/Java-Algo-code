import java.util.*;
import java.net.*;
import java.io.*;

class TCPServer {
    public static void main(String args[]) {
        try {
            ServerSocket s = new ServerSocket(4321);
            System.out.println("Server Ready : Waiting Mode");
            Socket s1 = s.accept();
            DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
            DataInputStream dis = new DataInputStream(s1.getInputStream());
            System.out.println(dis.readUTF());
            dos.writeUTF("Connected To Server");
            String path = dis.readUTF();
            System.out.println("Request Recieved & Processing");
            try {
                File myfile = new File(path);
                Scanner sc = new Scanner(myfile);
                String st = "Content of file is : \n";
                st += sc.nextLine();
                
                while (sc.hasNextLine())
                    st = st + "\n" + sc.nextLine();
                
                sc.close();
                dos.writeUTF(st);
                dos.close();
                s1.close();
                s.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error : File not found");
                dos.writeUTF("Error : File not found");
            }
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } finally {
            System.out.println("Connection Terminated!");
        }
    }
}