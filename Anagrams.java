import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    Name: Sherlock And Anagrams
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
    Statement: Two strings are anagrams of each other if the letters of one string
    can be rearranged to form the other string. Given a string, find the number of
    pairs of substrings of the string that are anagrams of each other.

*/

public class Anagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int ctr =0;
        char [] substr;
        char [] str= s.toCharArray();
        int l1 = s.length();
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

        for(int i =1; i<l1; i++)
        {
            for(int j =0;j<l1-i+1; j++)
            {
                String val = "";
                int a = i+j-1;
                for(int k =j; k<=a; k++)
                { val += str[k]; }

                if(val.length()>1)
                {
                    substr = val.toCharArray();
                    Arrays.sort(substr);
                    val = new String(substr);
                }


                Boolean value = ht.containsKey(val);
                int newVal = (value == false) ? 1 : (ht.get(val) + 1);
                ht.put(val, newVal);
            }
        }

        Enumeration e = ht.elements();
        while (e.hasMoreElements())
             {
                    int n =(int) e.nextElement();
                    if(n>1) {ctr += n * (n - 1) / 2; }
             }

        return ctr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();
        scanner.close();
        int result = sherlockAndAnagrams(s);
        System.out.println(result);
    }
}




