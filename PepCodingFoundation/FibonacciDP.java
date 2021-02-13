/*
    Name: Fibonacci Series (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/fibonacci-dp-official/ojquestion
*/
import java.util.Scanner;

public class FibonacciDP {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] dp = new int[n+1];
        int res = fibMemoized(n, dp);
        System.out.println(res);
    }

    public static int fibMemoized(int n, int [] dp)
    {
        if(n==0 || n==1)
        {
            return n;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        int n1 = fibMemoized(n-1, dp);
        int n2 = fibMemoized(n-2, dp);
        int n3 = n1 + n2;
        dp[n] = n3;

        return n3;
    }
}
