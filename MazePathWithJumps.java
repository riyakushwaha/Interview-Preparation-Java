/*
    Name: Maze Path With Jumps (Using Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-path-with-jumps-official/ojquestion
    Statement: You are given a number n and a number m representing number of rows and columns in a maze. You are standing in the top-left corner
    and have to reach the bottom-right corner. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more
    steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
*/

import java.util.ArrayList;
import java.util.Scanner;

public class MazePathWithJumps {
    public static void main(String[] args){
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

        ArrayList<String> hpath;
        ArrayList<String> vpath;
        ArrayList<String> dpath;
        ArrayList<String> result = new ArrayList<>();

        for(int i =1; i<= dc-sc; i++)
        {
            hpath = getMazePaths(sr, sc+i, dr, dc);
            for(String st: hpath)
            {
                result.add("h"+i+st);
            }
        }

        for(int i =1; i<= dr-sr; i++)
        {
            vpath = getMazePaths(sr+i, sc, dr, dc);
            for(String st: vpath)
            {
                result.add("v"+i+st);
            }
        }

        for(int i =1; i<= dc-sc && i<= dr-sr ; i++)
        {
            dpath = getMazePaths(sr+i, sc+i, dr, dc);
            for(String st: dpath)
            {
                result.add("d"+i+st);
            }
        }

        return result;
    }
}
