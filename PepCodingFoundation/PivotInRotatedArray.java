/*
    Name: Pivot In Sorted and Rotated Array
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/pivot-sorted-rotated-array-official/ojquestion
    Statement: You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point. You have to find the smallest
    element in O(logN) time-complexity
*/
import java.util.Scanner;
public class PivotInRotatedArray {
    public static int findPivot(int[] arr) {
        // write your code here
        int i = 0;
        int j = arr.length -1;
        if(arr[i]>arr[j])
        {
            i =j-1;
            while(arr[j]>arr[i])
            {
                i--;
            }
            i++;
        }
        return arr[i];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }
}
