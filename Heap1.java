import java.util.*;

public class Heap1 {

    public static class PriorityQueue {
        ArrayList < Integer > data;

        public PriorityQueue(int [] arr) {
            data = new ArrayList < > ();
            for(int i: arr)
            {
                data.add(i);
            }
            for(int i = data.size()/2 -1; i>=0; i--)
            {
                downheapify(i);
            }
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int idx) {
            if (idx == 0) {
                return;
            }
            int pi = (idx - 1) / 2;
            if (data.get(pi) > data.get(idx)) {
                swap(pi, idx);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            int a = data.get(i);
            data.set(i, data.get(j));
            data.set(j, a);
        }

        public int remove() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int pi) {
            int mini = pi;
            int li = mini * 2 + 1;
            int ri = mini * 2 + 2;
            if (li < data.size() && data.get(li) < data.get(mini)) {
                mini = li;
            }

            if (ri < data.size() && data.get(ri) < data.get(mini)) {
                mini = ri;
            }

            if (mini != pi) {
                swap(pi, mini);
                downheapify(mini);
            }

        }

        public int peek() {
            // write your code here
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else {
                return data.get(0);
            }

        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) {
        int [] arr = {50, 40, 56, 12, 45, 9, 0, 23, 70, 33, 89, 60, 100};
        PriorityQueue qu = new PriorityQueue(arr);

        while(qu.size()>0)
        {
            System.out.print(qu.remove()+" ");
        }

    }
}