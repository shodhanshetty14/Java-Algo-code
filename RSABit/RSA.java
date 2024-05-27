import java.util.*;
import java.math.*;
public class RSA
{
 static Scanner S=new Scanner(System.in);
 static Random R=new Random();
 static final int bitLength=256;
 static BigInteger p,q,n,z,e,d;
 public static void main(String args[])
 {
p=BigInteger.probablePrime(bitLength,R);
q=BigInteger.probablePrime(bitLength,R);
n=p.multiply(q);
z=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
e=BigInteger.probablePrime(bitLength/2,R);
while(e.gcd(z).compareTo(BigInteger.ONE)!=0 && e.compareTo(z)<0)
 e.add(BigInteger.ONE);
d=e.modInverse(z);
String msg;
System.out.print("Enter MSG : ");
msg=S.nextLine();
byte ms[]=msg.getBytes();
System.out.println("MSG Byte Array : "+display(ms));
byte en[]=encrypt(ms);
System.out.println("Encrypted MSG Byte Array : "+display(en));
byte de[]=decrypt(en);
System.out.println("Decrypted MSG Byte Array : "+display(de));
System.out.println("Decrypted MSG : "+new String(de));
 }
 static byte[] encrypt(byte a[])
 {
return new BigInteger(a).modPow(e,n).toByteArray();
 }
 static byte[] decrypt(byte a[])
 {
return new BigInteger(a).modPow(d,n).toByteArray();
 }
 static String display(byte a[])
 {
int i;
String s="";
for(i=0;i<a.length;i++)
 s+=Byte.toString(a[i]);
return s;
 }
}