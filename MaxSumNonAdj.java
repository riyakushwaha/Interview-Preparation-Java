/*
    Name: Maximum Sum Non Adjacent Elements (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/maximum-sum-non-adjacent-elements-official/ojquestion
    Statement: You are given n numbers, representing n elements. You are required to find the maximum sum of a subsequence with no adjacent elements.
 */
import java.util.Scanner;

public class MaxSumNonAdj {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scanner.nextInt();
        }

        int oldInc = arr[0];
        int oldExc = 0;
        int newInc =0;
        int newExc =0;

        for(int i=1; i< arr.length; i++)
        {
            newInc =  oldExc + arr[i];
            newExc = Math.max(oldExc, oldInc);
            oldExc = newExc;
            oldInc = newInc;
        }

        System.out.println(Math.max(oldExc, oldInc));
    }
}
