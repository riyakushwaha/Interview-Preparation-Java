/*
    Name: Paint Fence
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-fence-official/ojquestion
    Statement:  You are given a number n and a number k in separate lines, representing the number of fences and number of colors. You are required to calculate and print the
    number of ways in which the fences could be painted so that not more than two fences have same colors.
 */
import java.util.Scanner;

public class PaintFence {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int fence = scanner.nextInt();
        int color = scanner.nextInt();
        int same = color;
        int diff = color*(color-1);
        int newSame, newDiff;

        for(int i=3; i<=fence; i++)
        {
            newSame = diff;
            newDiff = (color-1)*(diff + same);
            same = newSame;
            diff = newDiff;
        }

        System.out.println(same+diff);
    }
}
