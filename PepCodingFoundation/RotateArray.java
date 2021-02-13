import java.util.Scanner;
/*
    Name: Rotate Array
    Source: LeetCode
    Link: https://leetcode.com/problems/rotate-array/
    Statement: Given an array, rotate the array to the right by k steps, where k is non-negative.
*/
public class RotateArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] a = new int [n];

        for(int i =0; i<n; i++)
        {
            a[i]= scanner.nextInt();
        }

        int k = scanner.nextInt();
        k = k%n;
        if(k<0)
        {
            k = n+k;
        }

        reverse(a, n-k, n);
        reverse(a, 0, n-k);
        reverse(a, 0, n);
    }

    public static void reverse(int [] a, int l, int h)
    {
        int temp;
        int n = (h+l)/2;
        for(int i =l; i<n; i++)
        {
            temp = a[i];
            a[i] = a[--h];
            a[h] = temp;
        }
    }
}
