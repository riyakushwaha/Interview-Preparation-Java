/*
    Name: Climb Stairs With Variable Jumps (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion
    Statement: You are given a number n, representing the number of stairs in a staircase. You are on the 0th step and are required to climb to the top.
    You are given n numbers, where ith element's value represents - till how far from the step you could jump to in a single move. You can jump fewer number
    of steps in the move. You are required to print the number of different paths via which you can climb to the top.
 */
import java.util.Scanner;

public class ClimbStairsVarJumps {
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
    // Tabulation-> dp stores number of path from n to 10th stair.
    private static int climbStairs(int [] arr) {

        int [] dp = new int[arr.length+1];
        dp[arr.length] = 1;

        for(int i= arr.length-1; i>=0 ; i--)
        {
            for(int j= i+1; j<dp.length && j<= i+arr[i]; j++)
            {
                dp[i] = dp[i] + dp[j];
            }
        }

        return dp[0];
    }
}
