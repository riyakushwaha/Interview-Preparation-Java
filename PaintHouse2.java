/*
    Name: Paint House - Many Colors (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-many-colors-official/ojquestion
    Statement:  You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
    In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
    You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
 */
import java.util.Scanner;

public class PaintHouse2 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int [][] arr = new int[n][c];
        int [][] dp = new int[n][c];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<c; j++)
            {
                arr[i][j] = scanner.nextInt();
            }
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int j=0; j<c; j++)
        {
            dp[0][j] = arr[0][j];
            if(min1>dp[0][j])
            {
                min2 =min1;
                min1 = dp[0][j];
            }
            else if(min2>dp[0][j])
            {
                min2 = dp[0][j];
            }
        }

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(dp[i-1][j]!=min1)
                {
                    dp[i][j] = min1;
                }
                else
                {
                    dp[i][j] = min2;
                }
                dp[i][j]+= arr[i][j];
            }

            min1 = min2 = Integer.MAX_VALUE;
            for(int j=0; j<c; j++)
            {
                if(min1>dp[i][j])
                {
                    min2 =min1;
                    min1 = dp[i][j];
                }
                else if(min2>dp[i][j])
                {
                    min2 = dp[i][j];
                }
            }
        }

        System.out.println(min1);
    }
}
