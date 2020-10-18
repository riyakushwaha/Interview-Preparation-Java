import java.util.Scanner;
/*
    Name: Spiral Display
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/spiral-display-official/ojquestion
    Statement: You are required to traverse and print the contents of the 2d array in form of a spiral.
*/
public class MatrixSpiralTraversal {

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

        System.out.println("PRINTING ARRAY");
        int leastRow = 0;
        int leastCol =0;
        int maxRow = n-1;
        int maxCol = m-1;
        int entries = n*m;
        int count =0;

        while(count<entries)
        {
            //Print left column
            for(int i =leastRow; i<=maxRow && count<entries; i++)// 0-4
            {
                System.out.println(arr[i][leastCol]);
                count++;
            }
            leastCol++;

            //Print bottom row
            for(int i =leastCol; i<=maxCol && count<entries ; i++)
            {
                System.out.println(arr[maxRow][i]);
                count++;
            }
            maxRow--;

            //Print right column
            for(int i =maxRow; i>=leastRow && count<entries; i--)
            {
                System.out.println(arr[i][maxCol]);
                count++;
            }
            maxCol--;

            //Print top row
            for(int i =maxCol; i>=leastCol && count<entries ; i--)
            {
                System.out.println(arr[leastRow][i]);
                count++;
            }
            leastRow++;

          //  System.out.println("count after box is: "+count);
        }

    }
}
