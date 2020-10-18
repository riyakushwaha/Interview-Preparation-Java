import java.util.Scanner;
/*
    Name: Find Power of a Number
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/introduction-to-recursion/power-linear-official/ojquestion
    Statement: You are required to calculate x raised to the power n.
*/
public class PowerByRecursion {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        //O(n) time complexity
        System.out.println(power(x,n));

        //O(log n) time complexity
        System.out.println(logTimePower(x,n));
    }


    public static int power(int x, int n){

        if(n==0)
        {
            return 1;
        }
        else if(n==1 )
        {
            return x;
        }

        int num = power(x, n-1);
        num = num *  x;
        return num;
    }


    public static int logTimePower(int x, int n)
    {
        if(n==0)
        {
            return 1;
        }
        else if(n==1 )
        {
            return x;
        }

        int num = power(x, n/2);
        num = num *  num;
        if(n%2!=0)
        {
            num = num* x;
        }
        return num;
    }
}
