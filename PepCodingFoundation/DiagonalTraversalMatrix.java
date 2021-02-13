import java.util.Scanner;
/*
    Name: Diagonal Traversal
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/diagonal-traversal-official/ojquestion
    Statement: You are required to diagonally traverse the upper half of the matrix and print the contents.
*/

public class DiagonalTraversalMatrix {
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

        System.out.println("printing elements");
        for(int i =0; i<n ; i++)
        {
            for(int j =0; j<n-i; j++)
            {
                System.out.println(arr[j][i+j]);
            }
        }
    }
}
