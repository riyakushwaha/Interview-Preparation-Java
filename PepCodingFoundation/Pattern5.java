//1 <= n <= 10
//Also, n is odd.
/*
    Name: Arrow Pattern
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/patterns/design-pattern-17-official/ojquestion
*/
import java.util.Scanner;

public class Pattern5 {

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int star=1;

        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n/2; j++)
            {
                if(i==n/2)
                {
                   System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
            }

            for(int j =0; j<star; j++)
            {
                System.out.print("*\t");
            }

            if(i>=n/2)
            {
                star--;
            }
            else
            {
                star++;
            }

            System.out.println("");
        }
    }
}
