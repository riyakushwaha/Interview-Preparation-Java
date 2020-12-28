/*
    Name: Binary Tree
    Source: PepCoding
    List of existing functions:
    1. display - Display contents of the tree.
    2. construct - Construct tree.
    3. size - Returns number of nodes in tree.
    4. max - Returns max element present in tree.
    5. height - Returns height. (taking edge into consideration)
    6. min - Returns min element present in tree.
    7. find - finds element in Binary search tree.
    8. add
    9. remove
    10. rwsol - replace with sum of larger data nodes.
    11. lca - least common ancestor
    12. targetSumPair
*/
import java.io.*;
import java.util.Stack;

public class BinarySearchTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if(node == null)
        {
            return 0;
        }

        int ls = size(node.left);
        int rs = size(node.right);

        return ls+rs+1;
    }

    public static int sum(Node node) {
        if(node == null)
        {
            return 0;
        }

        int ls = sum(node.left);
        int rs = sum(node.right);

        return ls + rs + node.data;

    }

    public static int max(Node node) {

        while(node.right!= null)
        {
            node = node.right;
        }
        return node.data;
    }

    public static int min(Node node) {
        while(node.left!= null)
        {
            node = node.left;
        }
        return node.data;
    }

    public static boolean find(Node node, int data) {
        if(node == null)
        {
            return false;
        }

        if(data > node.data)
        {
            return find(node.right, data);
        }
        else if(data < node.data)
        {
            return find(node.left, data);
        }
        else
        {
            return true;
        }

    }

    public static Node add(Node node, int data) {
        // write your code here
        if(node == null)
        {
            Node base = new Node(data, null, null);
            return base;
        }

        if(data < node.data)
        {
            node.left = add(node.left, data);
        }
        else if(data > node.data)
        {
            node.right = add(node.right, data);
        }

        return node;
    }

    public static Node remove(Node node, int data) {
        if(node == null)
        {
            return null;
        }

        if (data < node.data)
        {
            node.left = remove(node.left, data);
        }
        else if(data > node.data)
        {
            node.right = remove(node.right, data);
        }
        else
        {
            if(node.left!= null && node.right!=null)
            {
                int max = max(node.left);
                node.data = max;
                node.left = remove(node.left, max);
                return node;
            }
            else if(node.left!=null)
            {
                return node.left;
            }
            else if(node.right!=null)
            {
                return node.right;
            }
            else
            {
                return null;
            }
        }

        return node;

    }

    static int sum = 0;
    public static void rwsol(Node node) {

        if(node == null)
        {
            return;
        }

        rwsol(node.right);

        int temp = node.data;
        node.data = sum;
        sum+= temp;

        rwsol(node.left);
        return;
    }

    public static int lca(Node node, int d1, int d2) {
        // write your code here
        if(node == null)
        {
            return -1;
        }

        if(d1 < node.data && d2 < node.data)
        {
            return lca(node.left, d1, d2);
        }
        else if( d1 > node.data && d2 > node.data)
        {
            return lca(node.right, d1, d2);
        }
        else
        {
            return node.data;
        }
    }

    public static void pir(Node node, int d1, int d2) {
        // write your code here
        if (node == null) {
            return;
        }

        if (d1 < node.data && d2 < node.data) {
            pir(node.left, d1, d2);
        } else if (d1 > node.data && d2 > node.data) {
            pir(node.right, d1, d2);
        } else {
            pir(node.left, d1, d2);
            System.out.println(node.data);
            pir(node.right, d1, d2);
        }

    }

    public static void targetSumPair1(Node root, Node node, int data) {
        if (node == null) {
            return;
        }

        targetSumPair1(root, node.left, data);
        int comp = data - node.data;
        if(node.data < comp)
        {
            if(find(root, comp))
            {
                System.out.println(node.data+ " "+comp);
            }
        }
        targetSumPair1(root, node.right, data);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (!values[i].equals("n")) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        boolean found = find(root, data);

        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(found);

        data = Integer.parseInt(br.readLine());
        root = add(root, data);
        display(root);

        data = Integer.parseInt(br.readLine());
        root = remove(root, data);
        display(root);

        rwsol(root);
        display(root);

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());
        int lca = lca(root, d1, d2);
        System.out.println(lca);

        d1 = Integer.parseInt(br.readLine());
        d2 = Integer.parseInt(br.readLine());
        pir(root, d1, d2);

        targetSumPair1(root, root, data);
    }

}