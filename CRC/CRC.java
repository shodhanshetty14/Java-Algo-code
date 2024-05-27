package CRC;
import java.util.*;

public class CRC {
    static Scanner S = new Scanner(System.in);
    static int n;
    static final String g = "10001000000100001";

    public static void main(String args[]) {
        String data, code, rec, crc, zero = "0000000000000000";
        System.out.print("Enter The Data Word : ");
        data = S.nextLine();
        n = data.length();
        crc = divide(data + zero);
        code = data + crc;
        System.out.println("CRC Generated : " + crc);
        System.out.println("Code Generated : " + code);
        System.out.print("Enter The Recieved CodeWord : ");
        rec = S.nextLine();
        if (zero.equals(divide(rec)))
            System.out.println("Not Corrupted!");
        else
            System.out.println("Corrupted!");
    }

    static String divide(String k) {
        int i, j;
        char x = '0';
        for (i = 0; i < n; i++) {
            if (k.charAt(i) == '1') {
                for (j = 0; j < 17; j++) {
                    if (g.charAt(j) == k.charAt(i + j))
                        x = '0';
                    else
                        x = '1';
                    k = k.substring(0, i + j) + x + k.substring(i + j + 1);
                }
            }
        }
        return k.substring(n);
    }
}