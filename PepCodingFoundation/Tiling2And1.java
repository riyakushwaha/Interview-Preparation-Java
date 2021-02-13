/*
    Name: Tiling With 2 * 1 Tiles
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling1-official/ojquestion
    Statement:  You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board. You've an infinite supply of 2 * 1 tiles.
    You are required to calculate and print the number of ways floor can be tiled using tiles.
 */
import java.util.Scanner;

public class Tiling2And1 {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 1;
        int b = 2;
        int c = 0 ;
        for(int i=3; i<=n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
