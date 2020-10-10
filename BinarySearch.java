import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int [n];
        int data;


        for(int i =0; i<n; i++)
        {
            a[i]= scanner.nextInt();
        }

        data = scanner.nextInt();

        System.out.println("entered in array");

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
                System.out.println("Found at position: "+mid);
                return;
            }
        }

        System.out.println("Not Found");




    }
}
