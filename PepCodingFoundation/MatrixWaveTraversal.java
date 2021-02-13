import java.util.Scanner;
/*
    Name: Wave Traversal
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/wave-traversal-official/ojquestion
    Statement: You are required to traverse and print the contents of the 2d array in form of a wave - down the first
    column then up the second column and so on.
*/
public class MatrixWaveTraversal {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int [][] arr = new int [n][m];

        for(int i =0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                arr[i][j]= scanner.nextInt();
            }
        }

       // System.out.println("PRINTING ARRAY");
        int j =0;
        for(int i =0; i<m ; i++)
        {

            if(i%2!=0)
            {
                while(j>0)
                {
                    System.out.println(arr[--j][i]);
                }
            }
            else
            {
                while(j<n)
                {
                    System.out.println(arr[j++][i]);
                }
            }
        }

    }
}
