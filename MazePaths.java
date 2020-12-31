/*
    Name: Maze Path (Using Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-paths-official/ojquestion#
    Statement: You are given a number n and a number m representing number of rows and columns in a maze.You are
    standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h'
    (1-step horizontal) and 'v' (1-step vertical).
*/

import java.util.ArrayList;
import java.util.Scanner;

public class MazePaths {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int row  = scanner.nextInt();
        int col = scanner.nextInt();
        ArrayList<String> res = getMazePaths(1,1,row, col);
        System.out.println(res);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if(sc==dc && sr==dr)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> hpath = new ArrayList<>();
        ArrayList<String> vpath = new ArrayList<>();

        if(sc<dc)
        {
            hpath = getMazePaths(sr, sc+1, dr, dc);
        }

        if(sr<dr)
        {
            vpath = getMazePaths(sr+1, sc, dr, dc);
        }

        ArrayList<String> result = new ArrayList<>();

        for(String st: hpath)
        {
            result.add("h"+st);
        }
        for(String st: vpath)
        {
            result.add("v"+st);
        }

        return result;
    }
}
