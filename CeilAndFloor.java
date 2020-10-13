import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args)  {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int [n];
        int data;


        for(int i =0; i<n; i++)
        {
            a[i]= scanner.nextInt();
        }

        data = scanner.nextInt();

        // System.out.println("entered in array");

        int l=0;
        int h =n-1;

        while (l<=h)
        {
            int mid = (l + h) /2;

            if(data<a[mid])
            {
                h = mid-1;
            }
            else if(data>a[mid])
            {
                l = mid+1;
            }
            else
            {
                System.out.println(a[mid+1]);
                System.out.println(a[mid]);
                return;
            }

        }

        System.out.println(a[l]);
        System.out.println(a[l-1]);
    }
}
