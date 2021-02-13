/*
    Name: Target Sum Subsets (Recursion + BackTracking)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/target-sum-subsets-official/ojquestion
    Statement: You are given n numbers and a number "tar" which is the target. WAP to calculate and print all subsets of given elements, the contents
    of which sum to "tar".
 */

import java.util.Scanner;
public class TargetSumSubsets {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n ; i++)
        {
            arr[i] = scanner.nextInt();
        }
        int tar = scanner.nextInt();
        printTargetSumSubsets(arr, 0, "", 0, tar);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(sos == tar && arr.length == idx)
        {
            System.out.println(set+".");
            return;
        }
        if(sos>tar || arr.length == idx)
        {
            return;
        }

        printTargetSumSubsets(arr, idx +1,  set+arr[idx]+", ", sos+arr[idx], tar);

        printTargetSumSubsets(arr, idx +1,  set, sos, tar);
    }
}
