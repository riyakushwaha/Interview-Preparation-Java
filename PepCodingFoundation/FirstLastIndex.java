import java.util.Scanner;

/*
    Name: First Index And Last Index
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/first-index-last-index-official/ojquestion

    Statement: Array is sorted. Array may have duplicate values. Find first and last index of element represented by data here.
*/
public class FirstLastIndex {
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
            else if(data==a[mid])
            {
                l=h = mid;
                break;
            }

        }

        if(l>h)
        {
            System.out.println(-1);
            System.out.println(-1);
            return;
        }

        while(a[l]==data)
        {
            l--;
        }

        while(a[h]==data)
        {
            h++;
        }

        System.out.println(l+1);
        System.out.println(h-1);


    }
}
