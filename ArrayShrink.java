import java.util.*;
        import java.io.*;
import java.util.ArrayList;


public class ArrayShrink {
    public static void main(String args[]) throws IOException {

        //write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.nextLine();
        String a[] = scanner.nextLine().split(" ");

        List<Integer> array = new java.util.ArrayList<Integer>();
        for (int i = 0; i < n; i++)
        {
            array.add(Integer.parseInt(a[i]));
        }

        int i=0;
        while(i<n-1)
        {
            if(array.get(i)==array.get(i+1))
            {
                array.remove(i);
                n--;
                array.set(i,array.get(i)+1);
                i=0;
            }
            else
            {
                i++;
            }
        }

        System.out.print(array.size());

    }
}