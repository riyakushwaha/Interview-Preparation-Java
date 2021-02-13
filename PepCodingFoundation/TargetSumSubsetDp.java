/*
    Name: Target Sum Subsets - Dp
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target-sum-subsets-dp-official/ojquestion
    Statement: You are given n numbers. You are given a number "tar". You are required to calculate and print true or false, if there is a subset
     the elements of which add up to "tar" or not.
 */
import java.util.Scanner;

public class TargetSumSubsetDp {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }

        int tar = scanner.nextInt();
        boolean [][] dp = new boolean[n+1][tar+1];

        for(int i =0; i<dp.length; i++)
        {
            for(int j =0; j <dp[0].length; j++)
            {
                if(j==0)
                {
                    dp[i][j] = true;
                }
                else if(i==0)
                {
                    dp[i][j] = false;
                }
                else if(dp[i-1][j] || (j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]]))
                {
                        dp[i][j] = true;
                }
                else
                    {
                        dp[i][j] = false;
                    }

            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);


    }
}
