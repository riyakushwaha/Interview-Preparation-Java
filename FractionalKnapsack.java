/*
    Name: Fractional Knapsack (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/fractional-knapsack-official/ojquestion
    Statement: You are given n numbers, representing the values of n items and another n numbers, representing the weights of n items. You are given
    a number "cap", which is the capacity of a bag you've. You are required to calculate and print the maximum value that can be created in the bag
    without overflowing it's capacity. Items can be added to the bag even partially. But you are not allowed to put same items again and again to the bag.
----------------------try again--------------------------
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    public static class Items{
        int value;
        int weight;
        float ratio;

        Items(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.ratio = (float) value/weight;
        }
    }

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

        List<Items> item = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            item.add(new Items(values[i], weights[i]));
        }

        Comparator<Items> com = new Comparator<Items>()
        {
            public int compare(Items i1, Items i2)
            {
                if(i1.ratio >i2.ratio)
                {
                    return -1;
                }
                else if(i1.ratio < i2.ratio)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        };

        Collections.sort(item, com);

        float profit = 0;
        for(int i=0; i<n ; i++)
        {
            if(cap >= item.get(i).weight)
            {
                profit+= item.get(i).value;
                cap-= item.get(i).weight;
            }
            else
            {
                profit+= (float) cap * item.get(i).value /item.get(i).weight;
                break;
            }
        }

       System.out.println(profit);
    }
}
