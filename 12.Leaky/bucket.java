// package 12.Leaky;
import java.util.Scanner;


class bucket extends Thread {
    
    public static void main(String ar[]) throws Exception
    {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Bucket");
        int size = sc.nextInt();
        q.insert(size);
        q.delete();
        sc.close();
    }
}

class Queue
{
    int q[], r = 0, f = 0;
    
    void insert(int n)
    {
        q = new int[10];
        int ele;
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+ i + " Elemnt: ");
            ele = in.nextInt();
            if(r + 1 > 10)
            {
                System.out.println("The lost Element is: "+ ele);
                break;
            }
            else{
                r++;
                q[i] = ele;
            }
        }
        in.close();
    }
    
    void delete()
    {
        Thread t = new Thread();
        if (r == 0)
        {
            System.out.println("Queue is Empty!");
        }
        for(int i = f; i < r;i++)
        {
            try{
                t.sleep(1000);
            }
            catch(Exception e)
            {

            }
            System.out.println("Leaked Packet: "+q[i]);
            f++;
        }
    }

}
