import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BubbleSort{

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int l1 = a.length;
        int swap =0;
        boolean flag = false;
        for(int i =1; i<l1; i++)
        {
            for(int j= 0; j<l1-i; j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    ++swap;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }

      for(int i =0; i<l1; i++){
          System.out.print(a[i]);
      }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
