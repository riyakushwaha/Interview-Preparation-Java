/*
    Name: Tiling With M * 1 Tiles
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling2-official/ojquestion
    Statement:  You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor. You've an infinite supply of m * 1 tiles.
    You are required to calculate and print the number of ways floor can be tiled using tiles.
 */
import java.util.Scanner;

public class TilingMAnd1 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] dp = new int[n+1];

        for(int i=1; i<=m && i<=n; i++)
        {
            if(i==m)
            {
                dp[i] = 2;
            }
            else
            {
                dp[i] = 1;
            }
        }

        for(int i=m+1; i<=n; i++)
        {
            dp[i] = dp[i-1] +  dp[i-m];
        }

        System.out.println(dp[n]);
    }
}
