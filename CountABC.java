/*
    Name: Count A+b+c+ Subsequences (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-a+b+c+subsequences-official/ojquestion
    Statement: You are required to calculate and print the count of subsequences of the nature (regex) a+b+c+. For abbc -> there are 3 subsequences. abc, abc, abbc
    For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
 */

import java.util.Scanner;

public class CountABC {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int a = 0;
        int ab = 0;
        int abc = 0;

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch=='a')
            {
                a = 2*a + 1;
            }
            else if(ch=='b')
            {
                ab = 2*ab + a;
            }
            else
            {
                abc = 2*abc + ab;
            }
        }

        System.out.println(abc);
    }
}
