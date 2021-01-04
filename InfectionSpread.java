/*
    Name: Spread Of Infection
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/infection-spread-official/ojquestion
    Statement: You are also given a src person (who got infected) and time t. You are required to find how many people will get infected in time t,
    if the infection spreads to neighbors of infected person in 1 unit of time.
 */

import java.io.*;
import java.util.*;

public class InfectionSpread {
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
        int day;

        Pair(int src, int day)
        {
            this.src = src;
            this.day = day;
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
        int t = Integer.parseInt(br.readLine());

        int count = 0;

        int [] visited = new int[vtces];
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair (src, 1));

        while(que.size()>0)
        {
            Pair top = que.remove();

            if(visited[top.src] > 0)
            {
                continue;
            }

            visited[top.src] = top.day;
            if(top.day > t)
            {
                break;
            }

            count++;
            for(Edge edge : graph[top.src])
            {
                if(visited[edge.nbr] == 0)
                {
                    que.add(new Pair(edge.nbr, top.day +1));
                }
            }
        }

        System.out.println(count);
    }

}