import java.util.Scanner;

/*
    Name: Ceil and Floor
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/ceil-floor-official/ojquestion

    Statement:  You are required find the ceil and floor of d in the array a.
    Ceil is defined as value in array which is just greater than d. If an element equal to d exists that will be considered as ceil.
    Floor is defined as value in array which is just lesser than d. If an element equal to d exists that will be considered as floor.
    Asssumption - Array is sorted.
*/

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
