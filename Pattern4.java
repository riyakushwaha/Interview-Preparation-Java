import java.util.Scanner;
/*
    Name: Pattern for n =4
    1     1
    12   21
    123 321
    1234321
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/patterns/design-pattern-16-official/ojquestion
*/
public class Pattern4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sp = 2*n-3;

        for(int i =1;i<=n; i++)
        {
            for(int j=1; j<=i; j++ )
            {
                System.out.print(j);
            }

            for(int j=1; j<=sp; j++ )
            {
                System.out.print(" ");
            }


            for(int j=i; j>0; j--)
            {
                if(j==n)
                {
                    continue;
                }
                System.out.print(j);
            }

            sp-=2;
            System.out.println("");

        }


    }
}

