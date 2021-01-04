import java.io.*;
import java.util.*;

public class HashMapImplementation {

    public static class HashMap < K, V > {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList < HMNode > [] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList < > ();
            }
        }

        public void put(K key, V value) throws Exception {
            // write your code here
            int bi = hashFun(key);
            int di = getIndexWithinBucket(bi, key);

            if(di==-1)
            {
                HMNode node = new HMNode(key,value);
                buckets[bi].add(node);
                size++;
            }
            else
            {
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = size * 1.0 / buckets.length;
            if(lambda > 2.0)
            {
                rehash();
            }
        }

        private int hashFun(K key) throws Exception
        {
            int val = key.hashCode();
            return Math.abs(val) % buckets.length;
        }

        private int getIndexWithinBucket(int bi, K key)
        {
            int di=-1;
            for(int i=0; i<buckets[bi].size(); i++)
            {
                if(key.equals(buckets[bi].get(i).key))
                {
                    di = i;
                }
            }
            return di;
        }

        private void rehash() throws Exception
        {
            LinkedList<HMNode> [] olddata = buckets;
            initbuckets(2 * buckets.length);
            size=0;
            for(int i =0; i<olddata.length; i++)
            {
                for(HMNode node: olddata[i])
                {
                    put(node.key, node.value);
                }
            }
        }


        public V get(K key) throws Exception {
            // write your code here
            int bi = hashFun(key);
            int di = getIndexWithinBucket(bi, key);

            if(di==-1)
            {
                return null;
            }
            else
            {
                return buckets[bi].get(di).value;
            }
        }

        public boolean containsKey(K key) throws Exception{
            // write your code here
            int bi = hashFun(key);
            int di = getIndexWithinBucket(bi, key);

            if(di==-1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public V remove(K key) throws Exception {
            // write your code here
            int bi = hashFun(key);
            int di = getIndexWithinBucket(bi, key);

            if(di==-1)
            {
                return null;
            }
            else
            {
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
        }

        public ArrayList < K > keyset() throws Exception {
            // write your code here
            ArrayList<K> keys = new ArrayList<>();
            for(int i =0; i< buckets.length; i++)
            {
                for(HMNode node: buckets[i])
                {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node: buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap < String, Integer > map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }

    }
}