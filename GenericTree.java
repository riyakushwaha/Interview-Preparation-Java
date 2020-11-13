/*
    Name: Generic Tree
    Source: PepCoding
    List of existing functions:
    1. display - Display contents of the tree.
    2. construct - Construct tree.
    3. size - Returns number of nodes in tree.
    4. max - Returns max element present in tree.
    5. height - Returns height. (taking edge into consideration)
    6. traversals - Display pre and post order traversal.
    7. levelOrder - Display level Order traversal.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        StringBuilder str = new StringBuilder(node.data + " -> ");
        for (Node child : node.children) {
            str.append(child.data).append(", ");
        }
        str.append(".");
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node){
        int count =0;
        for(Node child: node.children)
        {
           count+= size(child);
        }
        return count+1;
    }

    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for(Node child: node.children)
        {
            int val = max(child);
            max = Math.max(max, val);
        }

        return Math.max(max, node.data);
    }

    public static int height(Node node) {
        int ht = -1;

        for(Node child: node.children)
        {
            int h = height(child);
            ht = Math.max(ht, h);
        }

        return ht+1;
    }

    //pre-order and post-order
    public static void traversals(Node node){
        System.out.println("Node Pre "+node.data);
        for(Node child: node.children)
        {
            System.out.println("Edge Pre "+node.data+"--"+child.data);
            traversals(child);
            System.out.println("Edge Post "+node.data+"--"+child.data);
        }
        System.out.println("Node Post "+node.data);
    }

    public static void levelOrder(Node node){
        Queue<Node> qt = new ArrayDeque<>();
        qt.add(node);
        while (!qt.isEmpty())
        {
            Node temp = qt.remove();
            System.out.print(temp.data+" ");
            for(Node child: temp.children)
            {
                qt.add(child);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int sz = size(root);
        System.out.println(sz);

        int m = max(root);
        System.out.println(m);

        int h = height(root);
        System.out.println(h);

        traversals(root);
        levelOrder(root);
    }
}
