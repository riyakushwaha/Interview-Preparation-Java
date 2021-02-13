/*
    Name: Buy And Sell Stocks - Two Transactions Allowed
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-tta-official/ojquestion
    Statement: You are given a number n, representing the number of days. You are given n numbers, where ith number represents price of stock on ith day.
    You are required to print the maximum profit you can make if you are allowed two transactions at-most. Note - There can be no overlapping transaction.
    One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 */
import java.util.Scanner;

public class BuySellStocksCase5 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        int [] dpLeft = new int[n];
        int [] dpRight = new int[n];

        int minSoFar = arr[0];
        for(int i=1; i<n ; i++)
        {
            if(minSoFar > arr[i])
            {
                minSoFar = arr[i];
            }

            if(arr[i] - minSoFar > dpLeft[i-1])
            {
                dpLeft[i] = arr[i] - minSoFar;
            }
            else
            {
                dpLeft[i] = dpLeft[i-1];
            }
        }

        int maxSoFar = arr[arr.length-1];
        for(int i= arr.length-2; i>=0; i--)
        {
            if(maxSoFar < arr[i])
            {
                maxSoFar = arr[i];
            }

            if(maxSoFar - arr[i]  > dpRight[i+1])
            {
                dpRight[i] = maxSoFar - arr[i];
            }
            else
            {
                dpRight[i] = dpRight[i+1];
            }
        }

        int profit = 0;
        for(int i=0; i<n; i++)
        {
            if(dpLeft[i] + dpRight[i]> profit)
            {
                profit = dpLeft[i] + dpRight[i];
            }
        }

        System.out.println(profit);
    }
}
