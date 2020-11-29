/*
    Name: Print Subsequence (Using Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-subsequence-official/ojquestion
    Statement: WAP to calculate and print all subsequences of str.
*/

import java.util.Scanner;

public class StrSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printSS(str, "");

    }

    public static void printSS(String str, String ans) {

        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);

        printSS(rest, ans+ch);
        printSS(rest, ans);

    }
}
