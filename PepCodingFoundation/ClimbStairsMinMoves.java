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
        int n = arr.length;
        Integer [] dp = new Integer[n+1];
        dp[n] = 0;

        for(int i=n-1; i>=0; i--)
        {
            if(arr[i]>0)
            {
                int min = Integer.MAX_VALUE;
                for(int j=1; j<=arr[i] && i+j <dp.length; j++)
                {
                    if(dp[i+j]!=null){
                        min = Math.min(min, dp[i+j]);
                    }
                }

                if(min != Integer.MAX_VALUE){
                    dp[i] =  min +1;
                }
            }
        }

        return dp[0];
    }

    //Approach2 Time= 0(n)
    public static int climbStairs2(int [] arr){
        int n = arr.length;
        int ladder = arr[0];
        int stair = arr[0];
        int jump = 1;

        if(ladder == 0)
        {
            return -1;
        }

        for(int i =1; i<n; i++){
            if(i == n-1)
            {
                return jump;
            }

            if(i + arr[i] > ladder)
            {
                ladder = i + arr[i];
            }
            stair--;

            if(stair == 0)
            {
                jump++;
                stair = ladder - i;
            }
            if(stair<=0)
            {
                return -1;
            }
        }

        return jump;
    }
}

