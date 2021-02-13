/*
    Name: Coin Change Permutation (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-permutations-official/ojquestion
    Statement: You are given n numbers, representing the denominations of n coins. You are given a number "amt". You are required to calculate
    and print the number of permutations of the n coins using which the amount "amt" can be paid.
 */
import java.util.Scanner;

public class CoinChangePermutationDP {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }

        int amt = scanner.nextInt();
        int [] dp = new int[amt+1];
        dp[0]  =1;

        for(int i=1; i<dp.length; i++)
        {
            for(int coins =0; coins<arr.length; coins++)
            {
                if(arr[coins]<=i)
                {
                    dp[i]+= dp[i- arr[coins]];
                }
            }
        }
        System.out.println("res: "+dp[dp.length-1]);
    }
}
