import java.util.Scanner;
/*
    Name: W Pattern
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/patterns/design-pattern-20-official/ojquestion
*/
public class WPattern {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i =0; i<n/2; i++)
        {
           for(int j =0; j<n; j++)
           {
               if(j==0 || j==n-1 )
               {
                   System.out.print("*\t");
               }
               else
               {
                   System.out.print("\t");
               }
           }
            System.out.println("");
        }

        for(int i =n/2; i<n; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(j==0 || j==n-1 || i==j || (i+j ==n-1))
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }

    }
}
