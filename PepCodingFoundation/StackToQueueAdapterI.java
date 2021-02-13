/*
    Name: Stack To Queue Adapter - Add Efficient
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/stack-to-queue-adapter-add-efficient-official/ojquestion
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackToQueueAdapterI {
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
            mainS.push(val);
        }

        int remove() {
            if(!mainS.isEmpty())
            {
                while (mainS.size()!=1)
                {
                    helperS.push(mainS.pop());
                }
                int val = mainS.pop();
                while (!helperS.isEmpty())
                {
                    mainS.push(helperS.pop());
                }
                return val;
            }
            return -1;
        }

        int peek() {
            while (mainS.size()!=1)
            {
                helperS.push(mainS.pop());
            }
            int val = mainS.peek();
            while (!helperS.isEmpty())
            {
                mainS.push(helperS.pop());
            }
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

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
