/*
    Name: Stack To Queue Adapter - Remove Efficient
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/stack-to-queue-adapter-remove-efficient-official/ojquestion
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackToQueueAdapterII {
    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
           return mainS.size();
        }

        void add(int val) {
            while (!mainS.isEmpty())
            {
                helperS.push(mainS.pop());
            }
            mainS.push(val);
            while (!helperS.isEmpty())
            {
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if(mainS.isEmpty())
            {
                System.out.println("Queue underflow");
                return -1;
            }
            else
            {
                return mainS.pop();
            }
        }

        int peek() {
            if(mainS.isEmpty())
            {
                System.out.println("Queue underflow");
                return -1;
            }
            else
            {
                return mainS.peek();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (str.equals("quit") == false) {
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
