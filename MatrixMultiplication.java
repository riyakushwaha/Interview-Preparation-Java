import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();

        int [][] a1 = new int [n1][m1];

        for(int i =0; i<n1; i++)
        {
            for(int j =0; j<m1; j++)
            {
                a1[i][j]= scanner.nextInt();
            }
        }

        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();

        int [][] a2 = new int [n2][m2];

        for(int i =0; i<n2; i++)
        {
            for(int j =0; j<m2; j++)
            {
                a2[i][j]= scanner.nextInt();
            }
        }

        if(m1==n2)
        {
            int [][] num = new int [n1][m2];
            int sum;
            for(int i =0; i<n1; i++)
            {
                for(int j =0; j<m2; j++)
                {
                    sum=0;
                    for(int k=0; k<m1; k++)
                    {
                        sum+= a1[i][k]* a2[k][j];
                    }

                    num[i][j]= sum;
                }
            }


            // System.out.println("printing array");
            for(int i =0; i<n1; i++)
            {
                for(int j =0; j<m2; j++)
                {
                    System.out.print(num[i][j]+" ");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("Invalid input");
        }

    }
}
