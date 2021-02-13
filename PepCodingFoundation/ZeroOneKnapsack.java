/*
    Name: Zero One Knapsack (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/zero-one-knapsack-official/ojquestion
    Statement: You are given n numbers, representing the values of n items and another n numbers, representing the weights of n items.
    You are given a number "cap", which is the capacity of a bag you've. You are required to calculate and print the maximum value that can be created
    in the bag without overflowing it's capacity.
 */
import java.util.Scanner;

public class ZeroOneKnapsack {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int cap = scanner.nextInt();
        int[][] dp = new int[n][cap+1];

        for (int i = 0; i < dp.length; i++)
        {
            int weigh = weights[i];
            for (int j = 1; j < dp[0].length; j++)
            {
                if(i==0)
                {
                    if(j-weigh>=0)
                    {
                        dp[i][j] = values[i];
                    }
                }
                else
                {
                    if(j-weigh>=0 && j-weigh< values.length)
                    {
                        dp[i][j] = Math.max(values[i]+ dp[i-1][j-weigh], dp[i - 1][j]);
                    }
                    else
                    {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-1][cap]);

    }
}
