/*
    Name: Count Binary Strings (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-binary-strings-official/ojquestion
    Statement: You are required to print the number of binary strings of length n with no consecutive 0's.
 */
import java.util.Scanner;

public class CountBinaryStrings {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int endsWithZero = 1;
        int endsWithOne = 1;
        int newZero, newOne;

        for(int i=2; i<=n; i++)
        {
            newZero = endsWithOne;
            newOne = endsWithOne + endsWithZero;

            endsWithOne = newOne;
            endsWithZero = newZero;
        }

        System.out.println("res: "+(endsWithOne+endsWithZero));
    }
}
