/*
    Name: Print all Permutations Recursively
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-permutations-official/ojquestion
*/

import java.util.Scanner;
public class StrPermutationII {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printPermutations(str, "");
    }

    public static void printPermutations(String str, String ans)
    {
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            String str1 = str.substring(0, i);
            String str2 = str.substring(i+1);
            String str3 = str1+str2;
            printPermutations(str3, ans+ch);
        }

    }

}
