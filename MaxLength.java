import java.util.*;
import java.io.*;

public class MaxLength {
    public static void main(String args[]) throws IOException
    {   //write your code here
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();
        int [] ans = new int[test];
        int no = test-1;

        while(no>=0)
        {
            int n = scanner.nextInt();
            int [] arr = new int[n];
            int count=0;
            int temp=1;

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String a[] = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++)
            {
                arr[i]  = Integer.parseInt(a[i]);
            }


            for (int i = 1; i < n; i++)
            {
                if(arr[i]>arr[i-1])
                {
                    temp++;
                    if(count<temp)
                    {
                        count=temp;
                    }
                }
                else
                {

                    temp=1;

                }
            }

            ans[no]=count;

            no--;
        }

        for (int i = test-1; i>-1; i--)
        {
            System.out.println(ans[i]);
        }

    }
}
