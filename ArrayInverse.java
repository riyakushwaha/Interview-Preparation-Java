import java.util.Scanner;

/*
    Name: Inverse Of An Array
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/inverse-of-an-array-official/ojquestion

    Statement: The inverse of a number is defined as the number created by interchanging the face value and index of digits of
    number.e.g. for 426135, the inverse is 416253
*/

public class ArrayInverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] a = new int [n];

        int num =0;
        for(int i =0; i<n; i++)
        {
            a[i]= scanner.nextInt();
            num+= i * (int) Math.pow(10, a[i]);

        }

        for(int i =0; i<n; i++)
        {
            a[i] =num%10;
            num= num/10;
        }

        for( int i =0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }


    }

}
