/*
    Name: Quick Select Algorithm
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/quick-select-official/ojquestion
    Application: It is a selection algorithm to find the k-th smallest element in an unordered list. It is related to the quick sort sorting algorithm.
 */
import java.util.Scanner;

public class QuickSelectAlgo {
    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        //write your code here
        int pos = partition(arr, arr[hi], lo, hi);
        if(pos>k)
        {
            return quickSelect(arr,  lo, pos-1, k);
        }
        else if(pos<k)
        {
            return quickSelect(arr,pos+1, hi, k);
        }
        return arr[pos];
    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println("Result: "+quickSelect(arr,0,arr.length - 1,k - 1));
    }
}
