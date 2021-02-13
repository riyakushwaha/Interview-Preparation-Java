/*
    Name: Friends Pairing (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion
    Statement: You are given a number n, representing the number of friends. Each friend can stay single or pair up with any of it's friends. You are required to print the
    number of ways in which these friends can stay single or pair up. E.g. 3people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.
 */
import java.util.Scanner;

public class FriendsPairing {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] dp = new int[n+1];

        for(int i=1; i<=n ; i++)
        {
            if(i<3)
            {
                dp[i] = i;
            }
            else
            {
                dp[i] = dp[i-1] + (i-1)*dp[i-2];
            }
        }
        System.out.println(dp[n]);
    }
}
