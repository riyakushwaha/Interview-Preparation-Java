/*
    Name: Climb Stairs With Minimum Moves (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion
    Statement:  You are given a number n, representing the number of stairs in a staircase. You are on the 0th step and are required to climb to the top.
    You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move.  You can move fewer number of steps in the move.
    You are required to print the number of minimum moves in which you can reach the top of staircase. If there is no path through the staircase print null.
 */

import java.util.Scanner;

public class ClimbStairsMinMoves {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scanner.nextInt();
        }

        int res = climbStairs(arr);
        System.out.println(res);
    }

    // Tabulation-> dp stores min+1 jumps to reach 10th stair.
    private static int climbStairs(int [] arr) {
        int [] dp = new int[arr.length+1];
        dp[arr.length] = 1;
        int min=0;
        for(int i= arr.length-1; i>=0 ; i--)
        {
            if(arr[i]!=0)
            {
                int val = arr[i] + i;
                min = dp[i+1];
                if(val>=dp.length)
                {
                    val = dp.length-1;
                }

                for(int j=i+2; j<dp.length && j<=val; j++)
                {
                    if(dp[j]!=0 && min> dp[j])
                    {
                        min = dp[j];
                    }
                    else if (min==0 && dp[j]>0)
                    {
                        min = dp[j];
                    }
                }
            }
            dp[i] = min>0? min +1 : 0;
        }
        return dp[0]-1;
    }
}

