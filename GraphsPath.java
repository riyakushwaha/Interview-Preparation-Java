/*
    Name: Has Path?
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/has-path-official/ojquestion
    Statement: You are required to find if a path exists between src and dest. If it does, print true
     otherwise print false.
 */

import java.io.*;
import java.util.*;

public class GraphsPath {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        boolean [] visited = new boolean[vtces];

        boolean path = hasPath(src, dest, graph, visited);
        System.out.println(path);
        // write your code here
    }

    public static boolean hasPath(int src, int dest, ArrayList < Edge > [] graph, boolean [] visited)
    {
        if(src == dest)
        {
            return true;
        }

        visited[src] = true;
        for( Edge e: graph[src])
        {
            if(!visited[e.nbr])
            {
                boolean check = hasPath(e.nbr, dest, graph, visited);
                if(check)
                {
                    return check;
                }
            }
        }

        return false;

    }

}