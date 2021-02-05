/*
    Name: Largest Area Histogram
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/lah-official/ojquestion
    Statement:  You are given a number n, representing the size of array a. You are given n numbers, representing the height of bars in a bar chart.
    You are required to find and print the area of largest rectangle in the histogram.
 */
import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = scanner.nextInt();
        }

        int [] nse = new int[n];
        Stack<Integer> stk1 = new Stack<>();
        for(int i =a.length-1; i>=0; i--)
        {
            while(!stk1.isEmpty() && a[i]< a[stk1.peek()])
            {
                stk1.pop();
            }

            if(stk1.isEmpty())
            {
                nse[i] = a.length;
            }
            else
            {
                nse[i] = stk1.peek();
            }

            stk1.push(i);
        }

        int [] pse = new int[n];
        Stack<Integer> stk2 = new Stack<>();
        for(int i =0; i<a.length; i++)
        {
            while(!stk2.isEmpty() && a[i]<= a[stk2.peek()])
            {
                stk2.pop();
            }

            if(stk2.isEmpty())
            {
                pse[i] = -1;
            }
            else
            {
                pse[i] = stk2.peek();
            }
            stk2.push(i);
        }

        for(int i: nse)
        {
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i: pse)
        {
            System.out.print(i+"\t");
        }
        System.out.println();

        int maxArea =0;
        for(int i=0; i<a.length; i++)
        {
           int area = (nse[i]-pse[i]-1) * a[i];
           if(area > maxArea)
           {
               maxArea = area;
           }
        }

        System.out.println(maxArea);

    }
}
