/*
    Name: Paint House (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-official/ojquestion
    Statement: You are given a number n, representing the number of houses. In the next n rows, you are given 3 space separated numbers representing
    the cost of painting nth house with red or blue or green color. You are required to calculate and print the minimum cost of painting all houses
    without painting any consecutive house with same color.
 */
import java.util.Scanner;

public class PaintHouse {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] arr = new int[n][3];
        int [][] dp = new int[n][3];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<3; j++)
            {
                arr[i][j] = scanner.nextInt();
            }
        }

        dp[0][0]  = arr[0][0];
        dp[0][1]  = arr[0][1];
        dp[0][2]  = arr[0][2];

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(j==0)
                {
                    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]);
                }
                else if(j==1)
                {
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]);
                }
                else
                {
                    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]);
                }
                dp[i][j]+= arr[i][j];
            }
        }

        int min = dp[n-1][0];
        for(int i=0; i<3; i++)
        {
            if(min>dp[n-1][i])
            {
                min = dp[n-1][i];
            }
        }

        System.out.println(min);


    }
}
