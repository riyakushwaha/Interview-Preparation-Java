/*
    Name: Count Sort
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/count-sort-official/ojquestion
    It is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values (kind of hashing).
*/
import java.util.Scanner;
public class CountingSort {
    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int range = max -min +1;
        int [] freq = new int [range];

        for(int i=0; i<arr.length; i++)
        {
            freq[arr[i]- min]++;
        }
        for(int i=1; i< freq.length; i++)
        {
            freq[i] = freq[i] + freq[i-1];
        }

        int [] ans = new int[arr.length];
        for(int i = arr.length-1 ; i>=0; i--)
        {
            int val = arr[i];
            int index = freq[val-min];
            ans[index-1] = val;
            freq[val-min]--;
        }

        for(int i =0 ; i<arr.length; i++)
        {
            arr[i] = ans[i];
        }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr,min,max);
        print(arr);
    }
}
