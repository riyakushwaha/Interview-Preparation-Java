/*
    Name: Merge K Sorted List
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/merge-k-sorted-lists-official/ojquestion
    Statement: You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.
    Constraints: Space complexity = O(k), Time complexity = nlogk, where k is the number of lists and n is number of elements across all lists.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {
    static class ListPair implements Comparable<ListPair>{
        int li;
        int di;
        int val;

        ListPair(int li, int di, int val)
        {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(ListPair other)
        {
            return this.val - other.val;
        }
    }
    public static ArrayList < Integer > mergeKSortedLists(ArrayList < ArrayList < Integer >> lists) {
        ArrayList < Integer > rv = new ArrayList < > ();
        PriorityQueue<ListPair> pq = new PriorityQueue<>();

        for(int i=0; i<lists.size(); i++)
        {
            pq.add(new ListPair(i, 0, lists.get(i).get(0)));
        }

        while(pq.size()>0){
            ListPair lp = pq.remove();
            rv.add(lp.val);
            lp.di++;

            if(lp.di < lists.get(lp.li).size())
            {
                pq.add(new ListPair(lp.li, lp.di, lists.get(lp.li).get(lp.di)));
            }
        }


        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList <ArrayList< Integer >> lists = new ArrayList < > ();
        for (int i = 0; i < k; i++) {
            ArrayList < Integer > list = new ArrayList < > ();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList < Integer > mlist = mergeKSortedLists(lists);
        for (int val: mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
