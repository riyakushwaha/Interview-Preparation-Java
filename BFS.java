/*
    Name: Breadth First Traversal
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/bfs-graph-official/ojquestion
    Statement: You are required to do a breadth first traversal and print which vertex is reached via which path, starting from the src.
 */

import java.io.*;
import java.util.*;

public class BFS{
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair{
        int src;
        String psf;

        Pair(int src, String psf)
        {
            this.src = src;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        boolean [] visited = new boolean[vtces];
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src, src+""));

        while(que.size()>0)
        {
            Pair top = que.remove();

            if(visited[top.src])
            {
                continue;
            }

            visited[top.src] = true;
            System.out.println(top.src+"@"+top.psf);

            for( Edge edge: graph[top.src])
            {
                if(!visited[edge.nbr])
                {
                    que.add(new Pair(edge.nbr, top.psf+edge.nbr));
                }
            }
        }

    }
}