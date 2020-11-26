import java.util.Scanner;
/*
    Name: Rotate By 90 degree
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/rotate-by-90-degree-official/ojquestion
    Statement: You are required to rotate the matrix by 90 degree clockwise and then display the contents.
*/
public class RotateMatrix {
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

        transpose(arr);

        for(int i =0; i<arr.length; i++)
        {
          reverse(arr[i]);
        }

        display(arr);
    }

    public static void transpose(int [][] arr)
    {
        int temp;
        for(int i =0; i<arr.length; i++)
        {
            for(int j =i; j<arr[0].length; j++)
            {
               temp = arr[i][j];
               arr[i][j] = arr[j][i];
               arr[j][i] = temp;
            }
        }
    }

    public static void reverse(int [] arr)
    {
        int i =0;
        int j = arr.length -1;
        int temp;

        while(i<j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

    public static void display(int [][] arr)
    {
        System.out.println("PRINTING ELEMENTS");
        int n = arr.length;
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<n; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
