/*
    Name: Minimum Cost In Maze Traversal (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/min-cost-maze-traversal-official/ojquestion
    Statement:  You are given n*m numbers, representing elements of 2d array a, which represents a maze.
    You are standing in top-left cell and are required to move to bottom-right cell.
    You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
    Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- right cell).
    You are required to traverse through the matrix and print the cost of path which is least costly.
 */

import java.util.Scanner;

public class MinCostMazeTraversal {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int res = climbStairs(arr, n - 1, m - 1);
        System.out.println(res);
    }

    private static int climbStairs(int[][] arr, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            arr[i][col] += arr[i + 1][col];
        }
        for (int i = col - 1; i >= 0; i--) {
            arr[row][i] += arr[row][i + 1];
        }
        int a = row - 1;
        int b = col - 1;

        while (a > 0 && b > 0) {
            // System.out.println("a: "+a+" b: "+b);
            for (int i = b; i >= 0; i--) //row traversal , col change
            {
                arr[a][i] += Math.min(arr[a + 1][i], arr[a][i + 1]);
            }

            for (int i = a - 1; i >= 0; i--) //col traversal row change
            {
                arr[i][b] += Math.min(arr[i][b + 1], arr[i + 1][b]);
            }
            a--;
            b--;

        }

        while (a > b)
        {
            arr[a][b] += Math.min(arr[a + 1][b], arr[a][b + 1]);
            a--;
        }
        while (b > a)
        {
            arr[a][b] += Math.min(arr[a][b + 1], arr[a + 1][b]);
            b--;
        }
        arr[0][0] += Math.min(arr[0][1], arr[1][0]);
        return arr[0][0];
    }
}