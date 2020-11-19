/*
    Name: Target Sum Pair 0(n*logn)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/target-sum-pair-1-official/ojquestion
    Statement: You have to print all the pairs having their sum equal to the target.
*/

import java.util.Scanner;
public class TargetSumPair {
    public static void targetSumPair(int[] arr, int target){
        //write your code here
        int [] array = mergeSort(arr, 0, arr.length-1);
        int i = 0;
        int j= array.length-1;

        for(int k: array)
        {
            System.out.print(k+" ");
        }
        System.out.println();
        while(i<j)
        {
            if(array[i] + array[j]<target)
            {
                i++;
            }
            else if(array[i] + array[j]>target)
            {
                j--;
            }
            else
            {
                System.out.println(array[i]+", "+array[j]);
                i++;
                j--;
            }
        }

    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {
        //write your code here
        if(lo==hi)
        {
            int [] a = new int[1];
            a[0] = arr[lo];
            return a;
        }

        int mid = (lo + hi)/2;
        int [] a = mergeSort(arr, lo, mid);
        int [] b =mergeSort(arr, mid + 1, hi);
        return mergeTwoSortedArrays(a, b);


    }

    //used for merging two sorted arrays
    public static int[] mergeTwoSortedArrays(int[] a, int[] b){

        int i = 0, j =0, k = 0;
        int[] ans = new int[a.length + b.length];
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                ans[k] = a[i];
                i++;
            }else{
                ans[k] = b[j];
                j++;
            }
            k++;
        }

        while(i < a.length){
            ans[k] = a[i];
            k++;
            i++;
        }

        while(j < b.length){
            ans[k] = b[j];
            k++;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr,target);
    }
}
