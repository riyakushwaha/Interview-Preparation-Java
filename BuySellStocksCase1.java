/*
    Name: Buy And Sell Stocks - One Transaction Allowed
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ota-official/ojquestion
    Statement: You are given a number n, representing the number of days. You are given n numbers, where ith number represents price of stock on ith day.
    You are required to print the maximum profit you can make if you are allowed a single transaction.
 */
import java.util.Scanner;

public class BuySellStocksCase1 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        int profit =0;
        int min = arr[0];
        int max = arr[0];

        for(int i=1; i<n ;i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
            }

            if(profit < max - min)
            {
                profit = max - min;
            }

            if(min > arr[i])
            {
                min = arr[i];
                max = arr[i];
            }
        }

        System.out.println(profit);
    }
}
