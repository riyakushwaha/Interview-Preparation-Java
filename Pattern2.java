import java.io.*;
import java.util.*;

public class Pattern2 {

    public static  void main(String []args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n
        int start=10;
        int end = n*(n+1)*10;// 120
        int values, spaces, ctr;

        for(int i =0; i<n; i++)
        {
            values = 2*n -(2*i); //
            spaces = 2*n-values;
            ctr = values/2;

            while(spaces>0)
            {
                System.out.print("*");
                spaces--;
            }

            int j =ctr;

            while(j>0)
            {
                System.out.print(start);
                j--;
                start+=10;
            }

            j =ctr;
           end = end - ((j-1)*10);

            while(j>1)
            {
                System.out.print(end);
                j--;
                end+=10;
            }
            System.out.print(end/10);

            end = end - (ctr*10);

            System.out.println(" ");
        }



    }

}
