/*
    Name: Maze Paths (Using Recursion - Second Method - Optimized)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-maze-paths-official/ojquestion
    Statement: You are given a number n and a number m representing number of rows and columns in a maze.You are
    standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h'
    (1-step horizontal) and 'v' (1-step vertical).
*/

import java.util.Scanner;

public class MazePathsII {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int row  = scanner.nextInt();
        int col = scanner.nextInt();
        printMazePaths(1,1,row, col, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if(sr==dr && sc==dc)
        {
            System.out.println(psf);
            return;
        }

        if(sc<=dc)
        {
            printMazePaths(sr, sc+1, dr, dc, psf+"h");
        }

        if(sr<=dr)
        {
            printMazePaths(sr+1, sc, dr, dc, psf+"v");
        }

    }
}
