/*
    Name: Is Graph Bipartite
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/is-bipartite-official/ojquestion
    Statement: You are required to find and print if the graph is bipartite
 */

import java.io.*;
import java.util.*;

public class BipartiteGraph {
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

    static class Pair {
        int src;
        int level;

        Pair(int src, int level)
        {
            this.src = src;
            this.level = level;
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

        boolean check = true;
        int[] level = new int[vtces];
        for (int i = 0; i < vtces; i++) {
            if (level[i] == 0) {
                check = isBipartite(i, graph, level);
                if (!check) {
                    break;
                }
            }
        }

        System.out.println(check);
    }

    public static boolean isBipartite(int src, ArrayList < Edge > [] graph, int[] level) {

        ArrayDeque < Pair > que = new ArrayDeque < > ();
        que.add(new Pair(src, 1));

        while (que.size() > 0)
        {
            Pair top = que.remove();

            if (level[top.src] > 0)
            {
                if(level[top.src] != top.level)
                {
                    return false;
                }
                continue;
            }
            else
            {
                level[top.src] = top.level;
                for (Edge edge: graph[top.src])
                {
                    if (level[edge.nbr] == 0)
                    {
                        que.add(new Pair(edge.nbr, top.level + 1));
                    }
                }
            }

        }

        return true;

    }



}