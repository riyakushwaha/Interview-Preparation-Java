import java.util.Scanner;
/*
    Name: Swastik Pattern
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/patterns/design-pattern-19-official/ojquestion
*/
public class SwastikPattern {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n; j++)
           {
               if((i==0 && j<=n/2) || j==n/2 || i==n/2 || (j==n-1 && i<n/2) || (j==0 && i>n/2) || (i==n-1 && j>n/2))
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

