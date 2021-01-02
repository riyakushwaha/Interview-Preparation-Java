/*
    Name: Shortest Path In Weights (Djikstra Algo)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/shortest-path-in-weights-official/ojquestion
    Statement: You are given a graph and a source vertex. The vertices represent cities and the edges represent
    distance in kms. You are required to find the shortest path to each city (in terms of kms) from the source city along
    with the total distance on path from source to destinations.
 */

import java.io.*;
import java.util.*;

public class DjikstraAlgo{
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

    public static class Pair implements Comparable<Pair>{
        int src;
        String psf;
        int wsf;

        Pair(int src, String psf, int wsf)
        {
            this.src = src;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair oth)
        {
            return this.wsf - oth.wsf;
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
        boolean [] visited = new boolean[vtces];
        PriorityQueue<Pair> que = new PriorityQueue<>();
        que.add(new Pair(src, src+"", 0));


        while(que.size()>0)
        {
            Pair top = que.remove();

            if(visited[top.src])
            {
                continue;
            }

            visited[top.src] = true;
            System.out.println(top.src+ " via "+ top.psf+" @ "+top.wsf);

            for(Edge edge : graph[top.src])
            {
                if(!visited[edge.nbr])
                {
                    que.add(new Pair(edge.nbr, top.psf+ edge.nbr, top.wsf+edge.wt));
                }
            }
        }

    }
}