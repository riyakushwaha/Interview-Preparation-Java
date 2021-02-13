/*
    Name: Flood Fill (Recursion + BackTracking)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/flood-fill-official/ojquestion
    Statement: You are given n*m numbers, representing elements of 2d array a. The numbers can be 1 or 0 only. You are standing in the top-left corner
    and have to reach the bottom-right corner. Only four moves are allowed 't' (1-step up), 'l' (1-step left), 'd' (1-step down) 'r' (1-step right).
    You can only move to cells which have 0 value in them. You can't move out of the boundaries or in the cells which have value 1 in them (1 means
    obstacle). WAP to print all paths that can be used to move from top-left to bottom-right.
 */

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][] arr = new int[n][m];
        boolean [][] visited = new boolean[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                arr[i][j] = scanner.nextInt();
            }
        }
        floodfill(arr, 0,0,"", visited);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){

        if(row== maze.length-1 && col== maze[0].length-1)
        {
            System.out.println(psf);
            return;
        }

        if(row>= maze.length || row<0 || col<0 || col>= maze[0].length || maze[row][col] == 1 ||  visited[row][col])
        {
            return;
        }

        visited[row][col] = true;
        floodfill(maze, row-1, col, psf+"t", visited);
        floodfill(maze, row, col-1, psf+"l", visited);
        floodfill(maze, row+1, col, psf+"d", visited);
        floodfill(maze, row, col+1, psf+"r", visited);
        visited[row][col] = false;

    }
}
