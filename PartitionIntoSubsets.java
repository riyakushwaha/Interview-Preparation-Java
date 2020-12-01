/*
    Name: Partition Into Subsets
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/partition-into-subsets-official/ojquestion
    Statement: You are given a number n, representing the number of elements. You are given a number k, representing the number of subsets.
    You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets. Eg: For n = 4 and k = 3, total ways is 6.
 */
import java.util.Scanner;

public class PartitionIntoSubsets {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long [][] dp = new long[k+1][n+1];

        for(int i= 1; i<=k; i++)
        {
            for(int j=i ;j<=n; j++)
            {
                if(i==1 || i==j)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = dp[i][j-1] * i + dp[i-1][j-1];
                }
            }
        }

        System.out.println(dp[k][n]);

    }
}
