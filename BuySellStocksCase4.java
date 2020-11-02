/*
    Name: Buy And Sell Stocks With CoolDown - Infinite Transaction Allowed
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-cooldown-ita-official/ojquestion
    Statement: You are given a number n, representing the number of days. You are given n numbers, where ith number represents price of stock on ith day.
    You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cool-down for 1 day after 1 transaction
    i.e. you cannot buy on the next day after you sell, you have to cool-down for a day at-least before buying again.
    Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 */
import java.util.Scanner;

public class BuySellStocksCase4 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scanner.nextInt();
        }

        int oldBuyStockProfit = -arr[0];
        int oldSellStockProfit = 0;
        int oldCoolDown = 0;
        int newBuyStockProfit;
        int newSellStockProfit;
        int newCoolDown;

        for(int i =1; i<n; i++)
        {
            if(oldCoolDown - arr[i] > oldBuyStockProfit)
            {
                newBuyStockProfit = oldCoolDown - arr[i];
            }
            else
            {
                newBuyStockProfit = oldBuyStockProfit;
            }

            if(oldBuyStockProfit + arr[i] > oldSellStockProfit)
            {
                newSellStockProfit = oldBuyStockProfit + arr[i] ;
            }
            else
            {
                newSellStockProfit = oldSellStockProfit;
            }

            if(oldCoolDown < oldSellStockProfit)
            {
                newCoolDown = oldSellStockProfit;
            }
            else
            {
                newCoolDown = oldCoolDown;
            }

            oldBuyStockProfit = newBuyStockProfit;
            oldSellStockProfit = newSellStockProfit;
            oldCoolDown = newCoolDown;
        }
        System.out.println(oldSellStockProfit);
    }
}
