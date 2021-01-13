import java.util.Scanner;
/*
    Name: Saddle Point
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/saddle-point-official/ojquestion
    Statement: You are required to find the saddle point of the matrix which is defined as the value which is smallest
    in it's row but largest in it's column.
*/
public class SaddlePoint {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] arr = new int [n][n];

        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n; j++)
            {
                arr[i][j]= scanner.nextInt();
            }
        }

       int min, max, col;

        for(int i =0; i<arr.length; i++)
        {
            min = max = arr[i][0];
            col=0;
            for(int j =0; j<arr.length; j++)
            {
                if(min>arr[i][j])
                {
                    min = arr[i][j];
                    col =j;
                }
            }

            for(int j =0; j<arr.length; j++)
            {
               if(max<arr[j][col])
               {
                   max = arr[j][col];
               }
            }

            if(max == min)
            {
                System.out.println(max);
                return;
            }

        }

        System.out.println("Invalid input");

    }


}
