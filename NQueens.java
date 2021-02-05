/*
    Name: Target Sum Subsets (Recursion + BackTracking)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/n-queens-official/ojquestion
    Statement: You are required to place n number of queens in the n * n cells of board such that no queen can kill another. WAP to calculate
    and print all safe configurations of n-queens.Note that Queens kill at distance in all 8 directions
 */

import java.util.Scanner;
public class NQueens {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length )
        {
            System.out.println(qsf);
            return;
        }

        for(int col =0; col<chess.length; col++)
        {
            if(safePlace(chess, row, col))
            {
                chess[row][col] = 1;
                printNQueens(chess, qsf+row+"-"+col+",", row+1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean safePlace(int [][] chess, int row, int col)
    {
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row-1, j=col; i>=0 ; i--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<chess.length; i--, j++)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }

        return true;
    }
}
