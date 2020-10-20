/*
    Name: Monotonic Array
    Source: LeetCode
    Link: https://leetcode.com/problems/monotonic-array/
 */
import java.util.Scanner;

public class MonotonicArray {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n ; i++)
        {
            arr[i] = scanner.nextInt();
        }

        System.out.println(isMonotonic(arr));
    }

    public static boolean isMonotonic(int[] A) {

        int inc = 0, dec =0;

        for(int i=1; i<A.length; i++)
        {
            if(A[i-1]<A[i])
            {
                inc++;
            }
            else if(A[i-1]>A[i])
            {
                dec++;
            }

        }

        if(inc>0 && dec>0)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}
