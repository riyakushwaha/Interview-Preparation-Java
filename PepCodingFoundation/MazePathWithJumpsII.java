/*
    Name: Maze Path With Jumps (Using Recursion - Second Method - Optimized)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-maze-path-with-jumps-official/ojquestion
    Statement: You are given a number n and a number m representing number of rows and columns in a maze. You are standing in the top-left corner
    and have to reach the bottom-right corner. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more
    steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
*/

import java.util.Scanner;
public class MazePathWithJumpsII {
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

        for(int i =1; i<=dc-sc; i++)
        {
            printMazePaths(sr, sc+i, dr, dc, psf+"h"+i);
        }
        for(int i =1; i<=dr-sr; i++)
        {
            printMazePaths(sr+i, sc, dr, dc, psf+"v"+i);
        }
        for(int i =1; i<=dr-sr && i<=dc-sc; i++)
        {
            printMazePaths(sr+i, sc+i, dr, dc, psf+"d"+i);
        }

    }
}
