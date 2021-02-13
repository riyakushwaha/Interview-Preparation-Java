/*
    Name: Perfect Friends
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/graphs/perfect-friends-official/ojquestion
    Statement: You are given a number n (representing the number of students). Each student will have an id
    from 0 to n - 1. You are given a number k (representing the number of clubs). In the next k lines, two numbers are given separated by a space. The numbers are ids of
    students belonging to same club. You have to find in how many ways can we select a pair of students such that both students are from different clubs.
 */

import java.io.*;
import java.util.*;

public class PerfectFriends {

    public static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr)
        {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[n];

        for(int i=0; i<n; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<k; i++)
        {
            String [] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            graph[a].add(new Edge(a, b));
            graph[b].add(new Edge(b, a));
        }

        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();



        boolean [] visited = new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> comp = new ArrayList<>();
                perfectFriends(graph, i, comp, visited);
                comps.add(comp);
            }
        }

        int count =0;
        for(int i=0; i<comps.size(); i++)
        {
            for(int j=i+1; j<comps.size(); j++)
            {
                count+= (comps.get(i).size() * comps.get(j).size());
            }
        }

        System.out.println(count);

    }

    public static void perfectFriends(ArrayList < Edge > [] graph , int src, ArrayList<Integer> comp,boolean [] visited){

        visited[src] = true;
        comp.add(src);

        for(Edge edge: graph[src])
        {
            if(!visited[edge.nbr])
            {
                perfectFriends(graph, edge.nbr, comp, visited);
            }
        }
    }
}