/*
    Name: Get Connected Components Of A Graph
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/gcc-official/ojquestion
    Statement: You are required to find and print all connected components of the graph.
 */

import java.io.*;
import java.util.*;

public class ConnectedComp {
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

        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();

        // write your code here
        boolean [] visited = new boolean[vtces];

        for(int i=0; i<vtces; i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> comp = new ArrayList();
                connectedComp(graph, i, visited, comp);
                comps.add(comp);
            }
        }

        System.out.println(comps);
    }

    public static void connectedComp(ArrayList<Edge> [] graph, int src, boolean [] visited, ArrayList<Integer> comp )
    {
        visited[src] =  true;
        comp.add(src);
        for(Edge edge : graph[src])
        {
            if(!visited[edge.nbr])
            {
                connectedComp(graph, edge.nbr, visited, comp);
            }
        }
    }
}