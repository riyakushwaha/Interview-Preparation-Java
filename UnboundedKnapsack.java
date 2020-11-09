/*
    Name: Unbounded Knapsack (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/unbounded-knapsack-official/ojquestion
    Statement: You are given n numbers, representing the values of n items and another n numbers, representing the weights of n items.
    You are given a number "cap", which is the capacity of a bag you've. You are required to calculate and print the maximum value that can be created
    in the bag without overflowing it's capacity. Each item can be taken any number of times.
 */
import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String [] args)
    {
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
        int[] dp = new int[cap+1];

        int weigh, sum;
        for(int i = 0; i<weights.length; i++)
        {
            weigh = weights[i];
            for(int j=weigh; j<dp.length; j++)
            {
                sum = values[i]+dp[j-weigh];
                if(sum>dp[j])
                {
                    dp[j]= sum;
                }
            }
        }

        System.out.println("res: "+dp[cap]);
    }
}
