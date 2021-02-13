/*
     Name: Longest Consecutive Sequence Of Elements
     Source: PepCoding
     Link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/lcqs-official/ojquestion
     Statement: You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).
     Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point
     of which occurs first in the array.
 */

import java.util.HashMap;
import java.util.Scanner;

public class LongConsecutiveSeq {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for(int i =0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> hmap = new HashMap<>();
        for(int i: arr)
        {
            hmap.put(i, true);
        }

        for(int i : hmap.keySet())
        {
            if(hmap.containsKey(i-1))
            {
                hmap.put(i, false);
            }
        }

        int mctr = 1;
        int start =0;
        for(int i: hmap.keySet())
        {
            int ctr= 1;
            if(hmap.get(i))
            {

                while(hmap.containsKey(i+ctr))
                {
                    ctr++;
                }

                if(mctr <ctr)
                {
                    mctr = ctr;
                    start = i;
                }
            }

        }

        for(int i= 0; i<mctr; i++)
        {
            System.out.println(start+i);
        }

    }
}
