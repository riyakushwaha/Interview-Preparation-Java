/*
    Name: Buy And Sell Stocks - K Transactions Allowed
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-kta---official/ojquestion
    Statement: You are given a number n, representing the number of days. You are given n numbers, where ith number represents price of stock on ith day.
    You are given a number k, representing the number of transactions allowed. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
    Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 */
import java.util.Scanner;

public class BuySellStocksCase6 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int [][] dp = new int[k+1][n];

        for(int i =1; i<=k; i++)
        {
            for(int j=1; j<n; j++)
            {
                dp[i][j] = dp[i][j-1];

                for(int lastRow =0; lastRow<j; lastRow++)
                {
                    if(dp[i-1][lastRow] + (arr[j] - arr[lastRow]) > dp[i][j])
                    {
                        dp[i][j] = dp[i-1][lastRow] + (arr[j] - arr[lastRow]);
                    }
                }
            }
        }

        System.out.println(dp[k][n-1]);
    }
}
