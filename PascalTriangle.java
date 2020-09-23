import java.io.*;
import java.util.*;

public class PascalTriangle {

    public static int fact(int n)
    {
        if(n==0)
        {
            return 1;
        }
        else
        {
            int a = n*fact(n-1);
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for(int i =0; i<n; i++)
        {
            int space= n-i-1;
            while(space>0)
            {
                System.out.print(" ");
                space--;
            }

            int num= 2*i+1;
            int index=1;

            for(int j= num; j>0; j--)
            {
              if(j==1 || j==num)
              {
                  System.out.print(1);
              }
              else if(j%2==0)
              {
                  System.out.print(" ");
              }
              else
              {
                  int a = fact(i)/ (fact(i-index) *fact(index++));
                  System.out.print(a);
              }
            }

            System.out.println("");
        }

    }
}
