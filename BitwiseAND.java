import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    Name: Bitwise AND
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/30-bitwise-and/problem

    Statement:  Given set S={1,2,.N}. Find two integers,A and B (where A<B), from set S such that the value of A&B
    in the maximum possible and also less than a given integer,K.In this case, & represents the bitwise AND operator.
*/

public class BitwiseAND {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int [] ans= new int [t];
        int index =-1;

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");
            int res =0;
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            for(int i=1; i<n; i++)
            {   for(int j=i+1; j<=n; j++)
                {   int a = (int) i&j;
                    if(a<k && res<a)
                    {
                        res = a;
                    }
                }
            }
            ans[++index]=res;
        }

        for(int i=0; i<t; i++){
            System.out.println(ans[i]);
        }

        scanner.close();
    }
}
