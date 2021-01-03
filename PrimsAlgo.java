/*
    Name: Minimum Wire Required To Connect All Pcs (Prim')s Algo
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/minimum-wire-to-connect-all-pcs-official/ojquestion
    Statement: You are given a graph and a source vertex. The vertices represent computers and the edges
    represent length of LAN wire required to connect them. You are required to find the minimum length of wire required to connect all PCs over a network.
    Print the output in terms of which all PCs need to be connected, and the length of wire between them.
 */

import java.io.*;
import java.util.*;

public class PrimsAlgo {
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

    public static class Pair implements Comparable<Pair>
    {
        int vtx;
        int src;
        int wt;

        Pair(int vtx, int src, int wt)
        {
            this.vtx = vtx;
            this.src = src;
            this.wt = wt;
        }

        public int compareTo(Pair oth)
        {
            return this.wt - oth.wt;
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

        boolean [] visited = new boolean[vtces];
        PriorityQueue<Pair> que = new PriorityQueue<>();
        que.add(new Pair(0, -1, 0));

        while(que.size() > 0)
        {
            Pair top = que.remove();

            if(visited[top.vtx])
            {
                continue;
            }

            visited[top.vtx] = true;

            if(top.src > -1)
            {
                System.out.println("[" + top.vtx + "-" + top.src + "@" + top.wt + "]");
            }

            for(Edge edge: graph[top.vtx])
            {
                if(!visited[edge.nbr])
                {
                    que.add(new Pair(edge.nbr, edge.src, edge.wt));
                }

            }


        }




    }

}