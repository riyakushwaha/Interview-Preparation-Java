/*
    Name: Sort 0s, 1s and 2s
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/sort-012-official/ojquestion
*/
import java.util.Scanner;
public class Sort012 {
    public static void sort012(int[] arr){
        //write your code here
        int i=0, j=0;
        int k = arr.length-1;
        int pivot =1;
        while(i<=k)
        {
           // System.out.println("i: "+i+" j: "+j+" k: "+k);
            if(arr[i]<pivot)
            {
                swap(arr, i, j);
                j++;
                i++;
            }
            else if(arr[i]>pivot)
            {
                swap(arr, i, k);
                k--;
            }
            else
            {
              i++;
            }
        }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
    }
}

