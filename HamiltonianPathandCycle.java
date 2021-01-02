/*
    Name: Hamiltonian Path And Cycle
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/hamiltonian-official/ojquestion
    Statement: You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."
 */

import java.io.*;
import java.util.*;

public class HamiltonianPathandCycle {
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

        // write all your codes here

        HashSet<Integer> keys = new HashSet<>();
        hamiltonianPathCycle(src, graph, keys, src+"", src);

    }

    public static void hamiltonianPathCycle(int src, ArrayList<Edge> [] graph, HashSet<Integer> keys, String sof, int osrc)
    {
        if(keys.size() == graph.length -1)
        {
            boolean found = false;
            for(Edge edge: graph[src])
            {
                if(edge.nbr == osrc)
                {
                    found = true;
                    break;
                }
            }

            System.out.print(sof);
            if(found)
            {
                System.out.println("*");
            }
            else
            {
                System.out.println(".");
            }

        }

        keys.add(src);
        for(Edge edge : graph[src])
        {
            if(!keys.contains(edge.nbr))
                hamiltonianPathCycle(edge.nbr, graph, keys, sof+edge.nbr, osrc);
        }
        keys.remove(src);
    }

}