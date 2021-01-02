/*
    Name: Order Of Compilation
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/compilation-order-official/ojquestion
    Statement:  You are given a directed acyclic graph. The vertices represent tasks and edges represent
    dependencies between tasks. You are required to find and print the order in which tasks could be done. The task that should be
    done at last should be printed first and the task which should be done first should be printed last.
    This is called topological sort. Check out the question video for details.
 */

import java.io.*;
import java.util.*;

public class OrderOfCompilation {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
        }

        Stack < Integer > stk = new Stack < > ();
        boolean[] visited = new boolean[vtces];
        for (int i = 0; i < vtces; i++) {
            if (!visited[i]) {
                orderOfComp(i, graph, stk, visited);
            }
        }

        while (stk.size() > 0) {
            System.out.println(stk.pop());
        }
    }

    public static void orderOfComp(int src, ArrayList < Edge > [] graph, Stack < Integer > stk, boolean[] visited) {
        if (visited[src]) {
            return;
        }

        visited[src] = true;
        for (Edge edge: graph[src]) {
            if (!visited[edge.nbr]) {
                orderOfComp(edge.nbr, graph, stk, visited);

            }
        }

        stk.push(src);
    }

}