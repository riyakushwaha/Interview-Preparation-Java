/*
    Name: Knights Tour (Recursion + BackTracking)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/knights-tour-official/ojquestion
    Statement: You are given a row and a column, as a starting point for a knight piece. You are required to generate the all moves of a knight
    starting in (row, col) such that knight visits all cells of the board exactly once. WAP to calculate and print all configurations of the chess
    board representing the route of knight through the chess board.
 */

import java.util.Scanner;
public class KnightsTour {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] chess = new int[n][n];
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        printKnightsTour(chess, row, col, 1);
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int move) {

        if(row<0 || col<0 || row>=chess.length || col>=chess.length || chess[row][col]>0)
        {
            return;
        }
        if(move==(chess.length * chess.length))
        {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = move;
        printKnightsTour(chess, row-2, col+1, move+1);
        printKnightsTour(chess, row-1, col+2, move+1);
        printKnightsTour(chess, row+1, col+2, move+1);
        printKnightsTour(chess, row+2, col+1, move+1);
        printKnightsTour(chess, row+2, col-1, move+1);
        printKnightsTour(chess, row+1, col-2, move+1);
        printKnightsTour(chess, row-1, col-2, move+1);
        printKnightsTour(chess, row-2, col-1, move+1);
        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
