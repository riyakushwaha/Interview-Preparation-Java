/*
    Name: Write Priority Queue Using Heap
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/priority-queue-using-heap-official/ojquestion
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PriorityQUsingHeap {
    public static class PriorityQueue {
        ArrayList< Integer > data;

        public PriorityQueue() {
            data = new ArrayList < > ();
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            upheapify(data.size()-1);
        }

        private void upheapify(int idx)
        {
            if(idx ==0)
            {
                return;
            }
            int pi = (idx-1) /2;
            if(data.get(pi) > data.get(idx))
            {
                swap(pi, idx);
                upheapify(pi);
            }
        }

        private void swap(int i, int j)
        {
            int a = data.get(i);
            data.set(i, data.get(j));
            data.set(j, a);
        }

        public int remove() {
            // write your code here
            if(this.size()==0)
            {
                System.out.println("Underflow");
                return -1;
            }

            swap(0, data.size()-1);
            int val = data.remove(data.size()-1);
            downheapify(0);
            return val;
        }

        private void downheapify(int pi)
        {
            int mini = pi;
            int li = mini * 2 + 1;
            int ri = mini * 2 + 2;
            if(li < data.size() && data.get(li) < data.get(mini))
            {
                mini = li;
            }

            if(ri < data.size() && data.get(ri) < data.get(mini))
            {
                mini = ri;
            }

            if(mini!=pi)
            {
                swap(pi, mini);
                downheapify(mini);
            }

        }

        public int peek() {
            // write your code here
            if(this.size()==0)
            {
                System.out.println("Underflow");
                return -1;
            }
            else
            {
                return data.get(0);
            }

        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
