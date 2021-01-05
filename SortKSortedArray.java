/*
     Name: Sort K Sorted Array
     Source: PepCoding
     Link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/sort-ksorted-official/ojquestion
     Statement: The array is nearly sorted. Every element is at-max displaced k spots left or right to it's position in the sorted array.
     Hence it is being called k-sorted array. You are required to sort and print the sorted array.
     Note -> You can use at-max k extra space and nlogk time complexity.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<=k; i++)
        {
            pq.add(arr[i]);
        }

        for(int i=k+1; i<arr.length; i++)
        {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        while(pq.size()>0)
        {
            System.out.println(pq.remove());
        }
    }
}
