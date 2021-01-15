import java.util.Scanner;
/*
    Name: Print All SubArrays
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/print-all-subarrays-official/ojquestion
    Statement: You are required to print all sub arrays of arr.
*/
public class PrintSubArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int [n];

        for(int i =0; i<n; i++)
        {
            a[i]= scanner.nextInt();
        }
        //System.out.println("entered in array");
        int num  =0;

        while(num<n)
        {
            for(int i =num; i<n ; i++)
            {
                for(int j =num; j<=i ; j++)
                {
                    System.out.print(a[j]+" ");
                }
                System.out.println("");
            }
            num++;
        }


    }
}
