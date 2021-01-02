/*
    Name: Number Of Islands
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/count-islands-official/ojquestion
    Statement: You are given a 2d array where 0's represent land and 1's represent water.
    Assume every cell is linked to it's north, east, west and south cell. You are required to find and count the number of islands.
 */

import java.io.*;
import java.util.*;

public class NoOfIsland {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        boolean [][] visited = new boolean[m][n];

        int count=0;
        for(int i=0; i< arr.length; i++)
        {
            for(int j =0; j<arr[0].length; j++)
            {
                if(arr[i][j]==0 && !visited[i][j])
                {
                    countLand(i, j, arr, visited);
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static void countLand(int i, int j, int [][] arr, boolean [][]visited)
    {
        if(i<0 || j<0 || i>= arr.length || j>=arr[0].length || arr[i][j] ==1 || visited[i][j])
        {
            return ;
        }

        visited[i][j] = true;
        countLand(i-1, j, arr, visited);
        countLand(i+1, j, arr, visited);
        countLand(i, j-1, arr, visited);
        countLand(i, j+1, arr, visited);
    }

}