/*
    Name: Iterative Depth First Traversal
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/iterative-dft-official/ojquestion
    Statement: You are required to do a iterative depth first traversal and print which vertex is reached via which path, starting from the source.
 */

import java.io.*;
import java.util.*;

public class IterativeDFS {
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
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(src, src+""));

        while(stk.size()>0)
        {
            Pair top = stk.pop();

            if(visited[top.src])
            {
                continue;
            }

            visited[top.src] = true;
            System.out.println(top.src + "@" + top.psf);

            for(Edge edge: graph[top.src])
            {
                if(!visited[edge.nbr])
                {
                    stk.push(new Pair(edge.nbr, top.psf+edge.nbr));
                }
            }
        }

    }
}