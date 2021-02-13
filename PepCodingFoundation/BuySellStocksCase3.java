/*
    Name: Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-transaction-fee-ita-official/ojquestion
    Statement: You are given a number n, representing the number of days. You are given n numbers, where ith number represents price of stock on ith day.
    You are give a number fee, representing the transaction fee for every transaction. You are required to print the maximum profit you can make if you are allowed infinite
    transactions, but has to pay "fee" for every closed transaction. Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell)
    before opening another transaction (another buy).
 */
import java.util.Scanner;

public class BuySellStocksCase3 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        int fee = scanner.nextInt();
        int oldBuyStockProfit = -arr[0];
        int oldSellStockProfit = 0;
        int newBuyStockProfit;
        int newSellStockProfit;

        for(int i =1; i<n; i++)
        {
            if(oldSellStockProfit - arr[i] > oldBuyStockProfit)
            {
                newBuyStockProfit = oldSellStockProfit - arr[i];
            }
            else
            {
                newBuyStockProfit = oldBuyStockProfit;
            }

            if(oldBuyStockProfit + arr[i] - fee > oldSellStockProfit)
            {
                newSellStockProfit = oldBuyStockProfit + arr[i] - fee;
            }
            else
            {
                newSellStockProfit = oldSellStockProfit;
            }

            oldBuyStockProfit = newBuyStockProfit;
            oldSellStockProfit = newSellStockProfit;
        }
        System.out.println(oldSellStockProfit);

    }
}
