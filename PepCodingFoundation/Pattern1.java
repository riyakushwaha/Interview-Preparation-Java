import java.io.*;
import java.util.*;
/*
    Name: Pattern
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/patterns/design-pattern-18-official/ojquestion
*/
public class Pattern1 {

    public static  void main(String []args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
    System.out.println(n/2);
        int values, spaces;

        for(int i =0; i<n ; i++)
        {
            if(i>=n/2)
            {
                spaces = n-1-i;
            }
            else
            {
                spaces = i;
            }

            values = n-(2*spaces);

            int j = spaces;
            while(j>0)
            {
                System.out.print(" ");
                j--;
            }

            if(i==0 || i>n/2)
            {
                while(values>0)
                {
                    System.out.print("*");
                    values--;
                }
            }
            else
            {
                for(j = values; j>0; j--)
                {
                    if(j==1 || j==values)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }

                }
            }

            System.out.println("");
        }

    }

}
