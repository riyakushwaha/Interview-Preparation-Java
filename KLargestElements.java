/*
     Name: K Largest Elements
     Source: PepCoding
     Link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/k-largest-elements-official/ojquestion
     Statement: You are required to find and print the k largest elements of array in increasing order.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k ; i++)
        {
            pq.add(arr[i]);
        }

        for(int i=k ; i<arr.length; i++)
        {
            if(arr[i] > pq.peek())
            {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while(pq.size()>0)
        {
            System.out.println(pq.remove());

        }
    }
}
