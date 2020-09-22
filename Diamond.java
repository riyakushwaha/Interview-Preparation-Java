import java.io.*;
import java.util.*;

public class Diamond {

    public static  void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i =0; i<n; i++)
        {
            int start= i+1;
            int j =0;
            int num =  Math.abs(n/2 -i);
            int count;
            if(n%2==0)
            {
                if(i<n/2)
                    { num--;}
            }
            while(j<num)
            {
                System.out.print(" ");
                j++;
            }
            j=0;
            count= n-(2*num);
            if(n%2==0)
            {
              count--;
            }
            j=0;

            while(j<count)
            {
                if(j<count/2)
                {
                    System.out.print(start++);
                }
                else
                {
                    System.out.print(start--);
                }
                j++;
            }

            System.out.println("");
        }
    }


}