/*
    Name: Is Graph Connected
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/is-graph-connected-official/ojquestion
    Statement: You are required to find and print if the graph is connected (there is a path from every vertex to every other)
 */

import java.io.*;
import java.util.*;

public class GraphConnected{
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

        // write your code here
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean [] visited = new boolean[vtces];
        int count =0;
        for(int i=0; i<vtces; i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> comp = new ArrayList<>();
                isConnected(graph, i, visited, comp);
                comps.add(comp);
                count++;
            }

        }

        if(count>1)
        {
            System.out.println("false");
        }
        else
        {
            System.out.println("true");
        }
    }

    public static void isConnected(ArrayList<Edge> [] graph, int src, boolean [] visited, ArrayList<Integer> comp)
    {
        visited[src] = true;
        comp.add(src);

        for(Edge edge: graph[src])
        {
            if(!visited[edge.nbr]){
                isConnected(graph, edge.nbr, visited, comp);
            }
        }
    }

}