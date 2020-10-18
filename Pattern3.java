import java.io.*;
import java.util.*;
/*
    Name: Pattern (Square - diamond)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/patterns/design-pattern-11-official/ojquestion
*/
public class Pattern3 {

    public static  void main(String []args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n

        int spaces, values, temp;

        for(int i=0; i<n; i++)
        {
            values= n-i;
            spaces = 2*i;
            temp = values;


            while(temp>0)
            {
                System.out.print("*");
                temp--;
            }
            while(spaces>0)
            {
                System.out.print(" ");
                spaces--;
            }

            while(values>0)
            {
                System.out.print("*");
                values--;
            }

            System.out.println("");
        }

        for(int i=0; i<n; i++)
        {
            values= i+1;
            spaces = 2*(n-values);
            temp = values;


            while(temp>0)
            {
                System.out.print("*");
                temp--;
            }
            while(spaces>0)
            {
                System.out.print(" ");
                spaces--;
            }

            while(values>0)
            {
                System.out.print("*");
                values--;
            }

            System.out.println("");
        }



    }

}
