/*
    Name: Sliding Window Maximum
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/sliding-window=maximum-official/ojquestion
    Statement:  You are given a number n, representing the size of array a. You are given n numbers, representing the elements of array a.
    You are given a number k, representing the size of window. You are required to find and print the maximum element in every window of size k.
 */
import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMax {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int [] nge = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=a.length-1; i>=0; i--)
        {
            while(!stk.isEmpty() && a[i]> a[stk.peek()])
            {
                stk.pop();
            }
            if(stk.isEmpty())
            {
                nge[i] = a.length;
            }
            else
            {
                nge[i] = stk.peek();
            }

            stk.push(i);
        }

        int [] array = new int[a.length-k+1];
        int j=0;
        for(int i=0; i<=a.length-k; i++)
        {
            if(j<i)
            {
                 j=i;
            }
            while(nge[j]<i+k)
            {
                j = nge[j];
            }
            array[i] = a[j];
        }

        for(int i: array)
        {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
}
