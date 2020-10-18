import java.util.*;
        import java.io.*;
import java.util.ArrayList;

/*
    Name: Shrink The Array
    Source: PrepBytes
    Link: https://mycode.prepbytes.com/contest/MARATHONSEP20/problems/ARRSRN

    Statement: You are given an array of positive integers A[]of length L. If Ai and Ai+1 both are equal
     replace them by one element with value. Find out the minimum possible length of the array after performing
     such operation any number of times.

   ---------------------------- Incomplete. Need to try again-----------------------
*/

public class ArrayShrink {
    public static void main(String args[]) throws IOException {

        //write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();
        String a[] = scanner.nextLine().split(" ");

        List<Integer> array = new java.util.ArrayList<Integer>();
        for (int i = 0; i < n; i++)
        {
            array.add(Integer.parseInt(a[i]));
        }

        int i=0;
        while(i<n-1)
        {
            if(array.get(i)==array.get(i+1))
            {
                array.remove(i);
                n--;
                array.set(i,array.get(i)+1);
                i=0;
            }
            else
            {
                i++;
            }
        }

        System.out.print(array.size());

    }
}