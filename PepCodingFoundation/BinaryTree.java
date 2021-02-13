/*
    Name: Binary Tree
    Source: PepCoding
    List of existing functions:
    1. display - Display contents of the tree.
    2. construct - Construct tree.
    3. size - Returns number of nodes in tree.
    4. max - Returns max element present in tree.
    5. height - Returns height. (taking edge into consideration)
    6. sum - Return sum of all nodes.
    7. levelOrder
    8. iterativePrePostInTraversal
    9. find
    10. nodeToRootPath
    11. printKLevelsDown
    12. printKNodesFar
    13. pathToLeafFromRoot
    14. createLeftClonedTree
    15. transBackToLeftClonedTree
    16. printSingleChildNodes
    17. removeLeaves
    18. diameter
    19. tilt
    20. isBST
    21. isBalanced
    22. largestBSTSubtree
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right)
        {
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
        int count = 0;
        count+= size(node.left);
        count+= size(node.right);

        return count + 1;
    }

    public static int sum(Node node) {
        if(node == null)
        {
            return 0;
        }

        int sum = node.data;
        sum+= sum(node.left);
        sum+= sum(node.right);

        return sum;
    }

    public static int max(Node node) {
        if(node == null)
        {
            return 0;
        }

        int max;
        int lmax = max(node.left);
        int rmax = max(node.right);
        max = Math.max(lmax, rmax);

        return Math.max(max, node.data);
    }

    public static int height(Node node) {

        int hght = -1;
        if(node == null)
        {
            return hght;
        }

        hght = Math.max(height(node.left), height(node.right));

        return hght+1;
    }

    public static void levelOrder(Node node) {

        Queue<Node> que = new ArrayDeque<>();
        que.add(node);
        while(!que.isEmpty())
        {
            int s = que.size();
            for(int i=0; i<s; i++)
            {
                Node temp = que.remove();
                System.out.print(temp.data+" ");
                if(temp.left != null)
                {
                    que.add(temp.left);
                }
                if(temp.right != null)
                {
                    que.add(temp.right);
                }
            }

            System.out.println();
        }
    }

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> que = new Stack<>();
        que.add(new Pair(node, 1));
        String pre ="";
        String post = "";
        String in ="";
        while(!que.isEmpty())
        {
            Pair temp = que.peek();
            if(temp.state == 1)
            {
                temp.state++;
                pre+= temp.node.data+" ";
                if(temp.node.left !=null)
                {
                    que.push(new Pair(temp.node.left, 1));
                }
            }
            else if(temp.state ==2)
            {
                temp.state++;
                in+= temp.node.data+ " ";
                if(temp.node.right !=null)
                {
                    que.push(new Pair(temp.node.right, 1));
                }
            }
            else
            {
                post+= temp.node.data+ " ";
                que.pop();
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public static boolean find(Node node, int data) {
        if(node == null)
        {
            return false;
        }
        if(node.data == data)
        {
            return true;
        }

        boolean check = find(node.left, data);
        if(check){return true;}

        check = find(node.right, data);
        if(check){return true;}

        return false;
    }

    public static ArrayList< Integer > nodeToRootPath(Node node, int data) {
        if(node == null)
        {
            return new ArrayList<>();
        }

        if(node.data == data)
        {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }

        ArrayList<Integer> res;
        res = nodeToRootPath(node.left, data);
        if(!res.isEmpty())
        {
            res.add(node.data);
            return res;
        }

        res = nodeToRootPath(node.right, data);
        if(!res.isEmpty())
        {
            res.add(node.data);
            return res;
        }

        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k) {
        if(node == null || k<0)
        {
            return;
        }

        if(k==0)
        {
            System.out.println(node.data);
        }

        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
    }

    public static ArrayList < Node > nodeToRootPath2(Node node, int data) {
        if (node == null) {
            return new ArrayList < > ();
        }

        if (node.data == data) {
            ArrayList < Node > base = new ArrayList < > ();
            base.add(node);
            return base;
        }

        ArrayList < Node > res;
        res = nodeToRootPath2(node.left, data);
        if (!res.isEmpty()) {
            res.add(node);
            return res;
        }

        res = nodeToRootPath2(node.right, data);
        if (!res.isEmpty()) {
            res.add(node);
            return res;
        }

        return new ArrayList < > ();
    }

    public static void printKLevelsDown2(Node node, int k, Node block) {
        if (node == null || k < 0 || block == node) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
        }

        printKLevelsDown2(node.left, k - 1, block);
        printKLevelsDown2(node.right, k - 1, block);
    }

    public static void printKNodesFar(Node node, int data, int k) {
        ArrayList <Node> path;
        path = nodeToRootPath2(node, data);
        for(int i=0; i<path.size(); i++)
        {
            printKLevelsDown2(path.get(i), k-i, i==0? null: path.get(i-1));
        }
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {

        sum+= node.data;
        path+= node.data+ " ";

        if(node.left == null && node.right== null && sum>lo && sum<hi)
        {
            System.out.println(path);
            return;
        }

        if(node.left != null)
        {
            pathToLeafFromRoot(node.left, path, sum, lo, hi);
        }

        if(node.right != null)
        {
            pathToLeafFromRoot(node.right, path, sum, lo, hi);
        }

    }

    public static Node createLeftCloneTree(Node node) {
        if(node == null)
        {
            return null;
        }

        Node l = createLeftCloneTree(node.left);
        Node r = createLeftCloneTree(node.right);
        Node temp = new Node(node.data, null, null);
        node.left = temp;
        temp.left = l;

        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node) {
        if(node == null)
        {
            return null;
        }

        Node l = transBackFromLeftClonedTree(node.left.left);
        Node r = transBackFromLeftClonedTree(node.right);
        node.left = l;

        return node;

    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if(node == null)
        {
            return;
        }

        if(parent!=null){
            if((parent.left==node && parent.right ==null) || (parent.right==node && parent.left==null))
            {
                System.out.println(node.data);
            }
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node removeLeaves(Node node) {
        if(node == null)
        {
            return null;
        }
        if(node.left == null && node.right ==null)
        {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;

    }

    public static int diameter1(Node node) {
        if(node == null)
        {
            return 0;
        }

        int ld = diameter1(node.left);
        int rd = diameter1(node.right);
        int da = height(node.left) + height(node.right)+ 2;

        int finaldia = Math.max(da, Math.max(ld, rd));

        return finaldia;
    }

    static class DiaHeightPair
    {
        int height;
        int dia;
    }

    public static DiaHeightPair diameter2(Node node)
    {
        if(node==null)
        {
            DiaHeightPair dhp = new DiaHeightPair();
            dhp.height = -1;
            dhp.dia = 0;
            return dhp;
        }

        DiaHeightPair ldhp = diameter2(node.left);
        DiaHeightPair rdhp = diameter2(node.right);

        DiaHeightPair mdhp = new DiaHeightPair();
        mdhp.height = Math.max(ldhp.height, rdhp.height)+1;
        int fdia = ldhp.height +  rdhp.height +2 ;
        mdhp.dia = Math.max(fdia, Math.max(ldhp.dia, rdhp.dia));

        return mdhp;
    }

    static int tilt = 0;
    public static int tilt(Node node) {
        if(node == null)
        {
            return 0;
        }

        int ls = tilt(node.left);
        int rs = tilt(node.right);
        int ts = ls + rs + node.data;
        tilt+= Math.abs(ls-rs);

        return ts;
    }

    static class BSTPair{
        boolean bst;
        int max;
        int min;
    }

    public static BSTPair isBST(Node node)
    {
        if(node==null)
        {
            BSTPair bp= new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.bst = true;
            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.bst = lp.bst && rp.bst && (node.data > lp.max && node.data < rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        return mp;

    }

    static boolean bal = true;
    public static int isBalanced1(Node node)
    {
        if(node == null)
        {
            return -1;
        }

        int lh = isBalanced1(node.left);
        int rh = isBalanced1(node.right);
        int gap = Math.abs(lh-rh);
        if(gap >1)
        {
            bal = false;
        }

        int th = Math.max(lh, rh )+1;

        return th;
    }

    static class BalPair{
        boolean isBal;
        int ht;
    }

    public static BalPair isBalanced2(Node node)
    {
        if(node == null)
        {
            BalPair bp = new BalPair();
            bp.isBal= true;
            bp.ht = -1;
            return bp;
        }

        BalPair lp = isBalanced2(node.left);
        BalPair rp = isBalanced2(node.right);

        BalPair mp = new BalPair();
        mp.isBal = lp.isBal && rp.isBal && (Math.abs(lp.ht - rp.ht)<2);
        mp.ht = Math.max(lp.ht, rp.ht) +1;

        return mp;
    }

    static class BSTPair2
    {
        boolean bst;
        int max;
        int min;
        int size;
        Node root;
    }
    public static BSTPair2 largestbstsubtree(Node node)
    {
        if(node == null)
        {
            BSTPair2 bp = new BSTPair2();
            bp.bst = true;
            bp.max = Integer.MIN_VALUE;
            bp.min = Integer.MAX_VALUE;
            bp.size = 0;
            bp.root = null;
            return bp;
        }

        BSTPair2 lp = largestbstsubtree(node.left);
        BSTPair2 rp = largestbstsubtree(node.right);

        BSTPair2 mp = new BSTPair2();
        mp.bst = lp.bst && rp.bst && (node.data > lp.max && node.data < rp.min);
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));

        if(mp.bst)
        {
            mp.size = lp.size + rp.size +1;
            mp.root = node;
        }
        else if(lp.size > rp.size)
        {
            mp.size = lp.size;
            mp.root = lp.root;
        }
        else
        {
            mp.size = rp.size;
            mp.root = rp.root;
        }
        return mp;

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

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);

        levelOrder(root);
        iterativePrePostInTraversal(root);

        int data = Integer.parseInt(br.readLine());

        boolean found = find(root, data);
        System.out.println(found);

        ArrayList < Integer > path = nodeToRootPath(root, data);
        System.out.println(path);

        int k = Integer.parseInt(br.readLine());
        printKLevelsDown(root, k);

        data = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        printKNodesFar(root, data, k);

        int lo = Integer.parseInt(br.readLine());
        int hi = Integer.parseInt(br.readLine());
        pathToLeafFromRoot(root, "", 0, lo, hi);

        root = createLeftCloneTree(root);
        display(root);

        root = transBackFromLeftClonedTree(root);
        display(root);

        printSingleChildNodes(root, null);

        root = removeLeaves(root);
        display(root);

        int diameter = 0;
        diameter = diameter1(root);

        DiaHeightPair d = diameter2(root);
        System.out.println(d.dia);

        tilt(root);
        System.out.println(tilt);

        BSTPair ib = isBST(root);
        System.out.println(ib.bst);

        isBalanced1(root);
        System.out.println(bal);

        BalPair bp = isBalanced2(root);
        System.out.println(bp.isBal);

        BSTPair2 fp = largestbstsubtree(root);
        System.out.println(fp.root.data+"@"+fp.size);

    }
}
