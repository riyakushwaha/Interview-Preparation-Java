/*
    Name: Climb Stairs (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-official/ojquestion
    Statement: You are on the 0th step and are required to climb to the top. In one move, you are allowed to climb 1, 2 or 3 stairs.
    You are required to print the number of different paths via which you can climb to the top.
*/
import java.util.Scanner;

public class ClimbStairsDP {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] dp = new int[n+1];
        int res = climbStairs(n, dp);
        System.out.println(res);
    }
    // Tabulation-> dp stores number of paths from 0 to n stairs by taking 1,2 or 3 steps a time.
    private static int climbStairs(int n, int[] dp) {

        dp[0] = 1;
        for(int i=1; i<dp.length; i++)
        {
            if(i==1)
            {
                dp[i] = dp[i-1];
            }
            else if(i==2)
            {
                dp[i] = dp[i-1] + dp[i-2];
            }
            else
            {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        return dp[n];
    }

}
