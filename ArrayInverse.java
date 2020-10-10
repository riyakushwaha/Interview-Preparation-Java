import java.util.Scanner;

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

       // System.out.println(num);

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
