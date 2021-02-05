import java.util.*;
import java.io.*;
/*
    Name: ICPC Problem
    Source: PrepBytes
    Link: https://mycode.prepbytes.com/contest/MARATHONSEP20/problems/ICPCPROB

    ---------------------------- Incomplete. Need to try again-----------------------
*/

public class ICPCProb {
    public static void main(String args[]) throws IOException {

        //write your code here

        Scanner scanner = new Scanner(System.in);
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int test = scanner.nextInt();
        long [] ans = new long[test];
        int index = 0;

        while(index<test)
        {

            long sum =1;
            String num1, num2, num3;
            int value;

            String s = scanner.next();
            int len = s.length();

            sum*= Integer.parseInt(s);

            int i=0;
            for(int j =1; j<len; j++)
            {
                num1 = s.substring(i,j);
                num2 = s.substring(j, len);
                //System.out.println(num1+" "+num2);

                value = Integer.parseInt(num1)* Integer.parseInt(num2);
                sum*=value;
            }

            for(i=0; i<len; i++)
            {
                num3= s.substring(i,i+1);
                value = Integer.parseInt(num3);
                sum*=value;
            }
           // System.out.print(sum);
            ans[index++]=sum;

        }

        for(int i=0; i<test; i++)
        {
            System.out.println(ans[i]);
        }


    }
}