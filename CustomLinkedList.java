/*
    Name: Custom Linked List
    Source: PepCoding
    List of existing functions:
    1. addLast - adds a new element with given value to the end of Linked List
    2. display - Prints the elements of linked list from front to end in a single line.
    3. size - Returns the number of elements in the linked list.
    4. removeFirst - Removes the first element from Linked List.
    5. getFirst - Returns the data of first element.
    6. getLast - Returns the data of last element.
    7. getAt - Returns the data of element available at the index passed.
    8. addFirst - adds a new element with given value in front of linked list.
    9. addAt - adds a new element at a given index.
    10. removeLast - removes the last element of linked list.
    11. removeAt - remove an element at a given index
    12. getNodeAt - Returns the node available at the index passed.
    13. reverseDI - reverse the contents of linked list by changing the "data" property of nodes.
    14. reversePI - reverse the contents of linked list by changing the "next" property of nodes.
    15. kthFromLast - return value of kth node from end.
    16. mid - return middle value of the list.
    17. mergeTwoSortedLists - merges two sorted Linked lists.
    18. midNode - return middle node of the list.
    19. mergeSort - applies mergesort algorithm to sort the linked list.
    20. removeDuplicates - removes duplicate data nodes from sorted linked list.
    21. oddEven - Tweak the list such that all odd values are followed by all even values and maintaining the relative order of elements.
    22. kReverse - The function is expected to tweak the list such that all groups of k elements in the list get reversed and linked. If the
        last set has less than k elements, leave it as it is.
    23. displayReverse and displayReverseHelper - display content of list in reverse order recursively.
    24. reversePR and reversePRHelper - Reverse list using pointers by recursion.
    25. reverseDR and reverseDRHelper - Reverse list using data property by recursion.
    26. IsPalindrome and PalindromeHelper -  Check if the linked list is a palindrome or not and return boolean value.
    27. fold and foldHelper - The function is expected to place last element after 1st element, 2nd last element after 2nd element and so on.
    28. addTwoLists and Addition -  The function is passed two linked lists which represent two numbers - the first element is the most significant digit
    and the last element is the least significant digit. The function is expected to add the two linked list and return a new linked list.
    29. findIntersection - The function is passed two linked lists which start separately but merge at a node and become common thereafter. The function is expected
    to find the point where two linked lists merge.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;

                temp.next = node;
                size++;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI() {
            int li = 0;
            int ri = size - 1;
            while(li < ri){
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI(){
            Node prev = null;
            Node curr = head;
            Node later;
            while(curr!=null)
            {
                later = curr.next;
                curr.next = prev;
                prev = curr;
                curr = later;
            }
            tail = head;
            head = prev;
        }

        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

        public int mid() {
            Node f = head;
            Node s = head;

            while (f.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            }

            return s.data;
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ml = new LinkedList();

            Node one = l1.head;
            Node two = l2.head;
            while (one != null && two != null) {
                if (one.data < two.data) {
                    ml.addLast(one.data);
                    one = one.next;
                } else {
                    ml.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                ml.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                ml.addLast(two.data);
                two = two.next;
            }

            return ml;
        }

        public static Node midNode(Node head, Node tail){
            Node f = head;
            Node s = head;

            while(f != tail && f.next != tail){
                f = f.next.next;
                s = s.next;
            }

            return s;
        }

        public static LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }

            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head, mid);
            LinkedList ssh = mergeSort(mid.next, tail);
            LinkedList sl = mergeTwoSortedLists(fsh, ssh);
            return sl;
        }

        public void removeDuplicates(){
            LinkedList res = new LinkedList();

            while(this.size() > 0){
                int val = this.getFirst();
                this.removeFirst();

                if(res.size() == 0 || val != res.tail.data){
                    res.addLast(val);
                }
            }

            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }

        public void oddEven(){

            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            while (this.size()>0)
            {
                int val = this.getFirst();
                this.removeFirst();;

                if(val%2 == 0)
                {
                    even.addLast(val);
                }else{
                    odd.addLast(val);
                }
            }

            if(odd.size()>0 && even.size()>0)
            {
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = even.size + odd.size;
            }
            else if(odd.size()>0)
            {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            }
            else
            {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }

        public void kReverse(int k) {
            LinkedList prev = new LinkedList();
            while(this.size >0)
            {
                LinkedList curr = new LinkedList();
                if(this.size >= k)
                {
                    for(int i=0; i<k; i++)
                    {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }
                else
                {
                    int s = this.size;
                    for(int i=0; i<s; i++)
                    {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }

                }

                if(prev.head == null)
                {
                    prev.head = curr.head;
                    prev.tail = curr.tail;
                    prev.size = curr.size;
                }
                else
                {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size+= curr.size;
                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }

        private void displayReverseHelper(Node node){
            if(node == null)
            {
                return;
            }
            else
            {
                displayReverseHelper(node.next);
                System.out.print(node.data+" ");
            }
        }

        public void displayReverse(){
            displayReverseHelper(head);
            System.out.println();
        }

        private void reversePRHelper(Node node){
            if(node == tail)
            {
                return;
            }
            reversePRHelper(node.next);
            node.next.next = node;
        }

        public void reversePR(){
            reversePRHelper(head);
            head.next = null;
            Node temp = head;
            head = tail;
            tail = temp;
        }

        private void reverseDRHelper(Node node, int floor){
            if(node == tail)
            {
                return;
            }
            reverseDRHelper(node.next, floor+1);
            if(floor>=size/2)
            {
                int temp = left.data;
                left.data = node.data;
                node.data = temp;
                left = left.next;
            }
        }

        Node left;
        public void reverseDR(){
            left = head;
            reverseDRHelper(head, 0);
        }

        private boolean PalindromeHelper(Node node, int floor)
        {
            if(node ==null)
            {
                return true;
            }

            boolean res = PalindromeHelper(node.next, floor+1);
            if(floor>=size/2)
            {
                if(res && left.data == node.data)
                {
                    left = left.next;
                    return res;
                }
                else
                {
                    return false;
                }


            }
            return res;
        }

        public boolean IsPalindrome() {
            left = head;
            return PalindromeHelper(head, 0);
        }

        private void foldHelper(Node right, int floor)
        {
            if(right ==null){
                return;
            }
            foldHelper(right.next, floor+1);

            if(floor>=size/2 && left!=right)
            {
                Node temp = left;
                left = left.next;
                temp.next = right;
                right.next = left;
            }
        }

        public void fold() {
            left = head;
            foldHelper(head, 0);
            left.next = null;
            tail = left;

        }

        private static int addition(Node node1, int pv1, Node node2, int pv2, LinkedList res)
        {
            if(node1 ==null && node2==null)
            {
                return 0;
            }

            int data =0;
            if(pv1> pv2)
            {
                int c =addition(node1.next, pv1-1, node2, pv2, res);
                data = node1.data + c;
            }
            else if(pv1 < pv2)
            {
                int c = addition(node1, pv1, node2.next, pv2-1, res);
                data = node2.data + c;
            }
            else
            {
                int c =addition(node1.next, pv1-1, node2.next, pv2-1, res);
                data = node1.data + node2.data + c;
            }

            int rem = data % 10;
            int carry = data/10;
            res.addFirst(rem);
            return carry;
        }

        public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
            LinkedList res = new LinkedList();
            int carry = addition(one.head, one.size, two.head, two.size, res);

            if(carry>0)
            {
                res.addFirst(carry);
            }
            return res;
        }

        public static int findIntersection(LinkedList one, LinkedList two){
            Node node1 = one.head;
            Node node2 = two.head;

            int extra = Math.abs(one.size - two.size);
            if(one.size > two.size)
            {
                for(int i=0; i<extra; i++)
                {
                    node1 = node1.next;
                }
            }
            else
            {
                for(int i=0; i<extra; i++)
                {
                    node2 = node2.next;
                }
            }

            while(node1 != node2)
            {
                node1 = node1.next;
                node2 = node2.next;
            }

            return node1.data;

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            } else if (str.startsWith("size")) {
                System.out.println(list.size());
            } else if (str.startsWith("display")) {
                list.display();
            } else if (str.startsWith("removeFirst")) {
                list.removeFirst();
            } else if (str.startsWith("getFirst")) {
                int val = list.getFirst();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getLast")) {
                int val = list.getLast();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("getAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = list.getAt(idx);
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("addFirst")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addFirst(val);
            } else if (str.startsWith("addAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                int val = Integer.parseInt(str.split(" ")[2]);
                list.addAt(idx, val);
            } else if (str.startsWith("removeLast")) {
                list.removeLast();
            } else if (str.startsWith("removeAt")) {
                int idx = Integer.parseInt(str.split(" ")[1]);
                list.removeAt(idx);
            } else if(str.startsWith("reverseDI")){
                list.reverseDI();
            } else if(str.startsWith("reversePI")){
                list.reversePI();
            }
            str = br.readLine();
        }


    }
}
