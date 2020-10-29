/*
    Name: Count Encodings (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-encodings-official/ojquestion
    Statement: You are required to calculate and print the count of encodings for the string str. Example 123 has 3 which are abc, lc, aw.
 */
import java.util.Scanner;

public class CountEncoding {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int [] dp = new int[str.length()];
        dp[0]=1;

        for(int i=1; i<str.length(); i++)
        {
            char ch1 = str.charAt(i-1);
            char ch2 = str.charAt(i);
            int range = Integer.parseInt(str.substring(i-1, i+1));

            if(ch1=='0' && ch2=='0')
            {
                dp[i] = 0;
            }
            else if(ch1=='0' && ch2!='0')
            {
                dp[i] = dp[i-1];
            }
            else if(ch1!='0' && ch2=='0')
            {
                if(range<=26)
                {
                    dp[i] = dp[i-2];
                }
                else
                {
                    dp[i] = 0;
                }

            }
            else
            {
                dp[i] = dp[i-1];
                if(range<=26)
                {
                    dp[i]+= (i==1? 1: dp[i-2]);
                }
            }

        }

        System.out.println(dp[dp.length-1]);
    }
}
