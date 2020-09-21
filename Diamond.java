import java.io.*;
import java.util.*;

public class Diamond {

    public static  void main(String []args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i =0; i<n; i++)
        {
            int start=i+1;
            int num = Math.abs(n/2 -i);
            int j =0;
            int count = n -(2*num);

            if(n%2==0)
            {

                if(i>n/2-1)
                {
                    num+=1;
                    count-=1;
                }
                else {
                    count += 1;
                }

            }


            while(j<num)
            {
                System.out.print(" ");
                j++;
            }

            for(int k =num-1; k<n/2; k++)
            {
                System.out.print(start++);
                count--;
            }

            start= start-1;
            while(count>0)
            {
                System.out.print(--start);
                count--;
            }
            System.out.println("");
        }
    }


}