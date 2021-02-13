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
    8. levelOrderLineWise - Display level order traversal in its own line.
    9. levelOrderLineWiseZigZag - Display level order traversal in line wise zigzag manner.
    10. mirror - create a mirror image of a tree.
    11. removeLeaves - remove leaves from tree.
    12. linearize - create a linear tree i.e. every node will have a single child only.
    13. getTail - get leaf of a linearized tree.
    14. find - find data in tree.
    15. nodeToRootPath - find the path from the element to root.
    16. lca - find the lowest common ancestor of two elements in tree.
    17. distanceBetweenNodes - find the distance between two node in terms of edges.
    18. areSimilar - check if two trees are similar.
    19. areMirror - check if two trees are mirror images of each other.
    20. IsSymmetric - check if the tree is symmetric.
    21. predecessorAndSuccessor - find predecessor and successor of the node.
    22. ceilAndFloor - find ceil and floor element of the node.
    23. kthLargest - find kth largest element in the tree.
    24. maxSubtreeSum - find the node with maximum subtree sum.
    25. calculateDiameter - The diameter is defined as maximum number of edges between any two nodes in the tree.
    26. IterativePreAndPostOrder - print the preorder and postorder traversal iteratively.
    27. multiSolver - calculates max, min, height and size of the tree.
    28. linearize2 - create a linear tree i.e. every node will have a single child only. OPTIMIZED METHOD
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class GenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state)
        {
            this.state = state;
            this.node = node;
        }
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

    public static void levelOrderLineWise(Node node){
        // write your code here
        Queue<Node> main = new ArrayDeque<>();
        Queue<Node> child = new ArrayDeque<>();
        main.add(node);

        while(!main.isEmpty())
        {
            Node temp = main.remove();
            System.out.print(temp.data+" ");
            for(Node ch: temp.children)
            {
                child.add(ch);
            }

            if(main.isEmpty())
            {
                main = child;
                child = new ArrayDeque<>();
                System.out.println("");
            }
        }
    }

    public static void levelOrderLineWiseZigZag(Node node){

        Stack<Node> main = new Stack<>();
        Stack<Node> child = new Stack<>();
        main.push(node);
        int ctr=1;
        while(!main.isEmpty())
        {
            Node temp = main.pop();
            System.out.print(temp.data+" ");
            if(ctr%2!=0)
            {
                for(Node ch : temp.children)
                {
                    child.push(ch);
                }
            }
            else
            {
                for(int i=temp.children.size()-1; i>=0; i--)
                {
                    child.push(temp.children.get(i));
                }
            }

            if(main.isEmpty())
            {
                main = child;
                child = new Stack<>();
                System.out.println("");
                ctr++;
            }

        }
    }

    public static void mirror(Node node){

        for(Node child: node.children)
        {
            mirror(child);
        }

        Collections.reverse(node.children);
    }

    public static void removeLeaves(Node node) {

        for(int i = node.children.size()-1; i >=0; i--)
        {
            Node child = node.children.get(i);
            if(child.children.size()==0)
            {
                node.children.remove(child);
            }
        }

        for(Node child: node.children)
        {
            removeLeaves(child);
        }
    }

    private static Node getTail(Node node)
    {
        while(node.children.size()>0)
        {
            node = node.children.get(0);
        }

        return node;
    }

    public static void linearize(Node node){

        if(node.children.size()==0)
        {
            return;
        }
        Node lchild = node.children.get(node.children.size()-1);
        linearize(lchild);
        while(node.children.size()>1)
        {
            Node last = node.children.remove(node.children.size()-1);
            linearize(node.children.get(node.children.size()-1));
            Node tail = getTail(node.children.get(node.children.size()-1));
            tail.children.add(last);
        }
    }

    public static Node linearize2(Node node){

        if(node.children.size()==0)
        {
            return node;
        }
        Node lc= linearize2(node.children.get(node.children.size()-1));

        while(node.children.size()>1)
        {
            Node last = node.children.remove(node.children.size()-1);
            Node tail = linearize2(node.children.get(node.children.size()-1));
            tail.children.add(last);
        }
        return lc;
    }

    public static boolean find(Node node, int data) {
        if(data ==node.data)
        {
            return true;
        }

        for(Node child: node.children)
        {
            boolean check = find(child, data);
            if(check)
            {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(data == node.data)
        {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }

        for(Node child: node.children)
        {
            ArrayList<Integer> res = nodeToRootPath(child, data);
            if(!res.isEmpty())
            {
                res.add(node.data);
                return res;
            }
        }

        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> a1 = nodeToRootPath(node, d1);
        ArrayList<Integer> a2 = nodeToRootPath(node, d2);
        int i = a1.size()-1;
        int j = a2.size()-1;
        // System.out.println(i+j);
        while(i>=0 && j>=0 && a1.get(i) == a2.get(j))
        {
            i--;
            j--;
        }
        return a1.get(i+1);
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2){
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }

        return (i+j+2);
    }

    public static boolean areSimilar(Node n1, Node n2) {
        if(n1.children.size()!= n2.children.size())
        {
            return false;
        }

        for(int i=0; i<n1.children.size(); i++)
        {
            boolean check = areSimilar(n1.children.get(i), n2.children.get(i));
            if(!check)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size()!=n2.children.size())
        {
            return false;
        }

        for(int i=0; i<n1.children.size(); i++)
        {
            int j = n1.children.size()-1-i;
            boolean check = areMirror(n1.children.get(i), n2.children.get(j));
            if(!check)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean IsSymmetric(Node node) {
        return areMirror(node, node);
    }

    static Node predecessor;
    static Node successor;
    static int state=0;
    public static void predecessorAndSuccessor(Node node, int data) {
        // write your code here
        if(data == node.data)
        {
            state =1;
        }
        else if(state==0)
        {
            predecessor = node;
        }
        else if(state ==1)
        {
            state=2;
            successor = node;
        }

        for(Node child: node.children)
        {
            predecessorAndSuccessor(child, data);
        }
    }

    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data) {
        if(node.data < data){
            floor = Math.max(floor, node.data);
        }
        if(node.data > data){
            ceil = Math.min(ceil, node.data);
        }
        for(Node child: node.children)
        {
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k){
        int temp = Integer.MAX_VALUE;

        for(int i=0; i<k; i++)
        {
            ceilAndFloor(node, temp);
            temp = floor;
            floor = Integer.MIN_VALUE;
        }

        return temp;
    }

    static int maxSum;
    static int maxNode;
    public static int maxSubtreeSum(Node node)
    {
        int sum = node.data;
        for(Node child: node.children)
        {
            sum+= maxSubtreeSum(child);
        }

        if(maxSum<sum)
        {
            maxSum = sum;
            maxNode = node.data;
        }

        return sum;
    }

    static int dia=0;
    public static int calculateDiameter(Node node)
    {
        int dch = -1;
        int sdch = -1;

        for(Node child: node.children)
        {
            int ch = calculateDiameter(child);
            if(ch > dch)
            {
                sdch = dch;
                dch = ch;
            }
            else if(ch > sdch)
            {
                sdch = ch;
            }
        }

        if(dch + sdch + 2 >dia)
        {
            dia = dch + sdch +2;
        }

        dch++;
        return dch;
    }

    public static void IterativePreAndPostOrder(Node node) {
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(node, -1));
        String pre = "";
        String post = "";
        while(stk.size()>0)
        {
            Pair p = stk.peek();
            if(p.state == -1)
            {
                pre+= (p.node.data+" ");
                p.state++;
            }
            else if(p.state == p.node.children.size())
            {
                stk.pop();
                post+= (p.node.data+" ");
            }
            else
            {
                stk.push(new Pair(p.node.children.get(p.state), -1));
                p.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }

    static int size, max, min, height;
    public static void multiSolver(Node node, int depth)
    {
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height =  Math.max(height, depth);
        for(Node child: node.children)
        {
            multiSolver(child, depth+1);
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
        levelOrderLineWise(root);
        levelOrderLineWiseZigZag(root);
        mirror(root);
        removeLeaves(root);
        linearize(root);
        linearize2(root);

        size = height =0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        multiSolver(root, 0);
    }
}
