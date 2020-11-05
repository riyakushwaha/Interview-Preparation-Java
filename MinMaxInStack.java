import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinMaxInStack {
    public static class MinStack {
        Stack<Integer> data;
        int min;
        int max;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if(data.isEmpty())
            {
                data.push(val);
                min = val;
                max = val;
            }
            else if(val < min)
            {
                data.push(val + val - min);
                min = val;
            }
            else if(val > max)
            {
                data.push(val + val - max);
                max = val;
            }
            else
            {
                data.push(val);
            }
        }

        int pop() {
            if(data.peek()<min)
            {
                int val = min;
                min = 2 * min - data.pop();
                return val;
            }
            else if(data.peek()>max)
            {
                int val = max;
                max = 2 * max - data.pop();
                return val;
            }
            else
            {
                return data.pop();
            }
        }

        int top() {
            if(data.peek() < min)
            {
                return min;
            }
            else if(data.peek() > min)
            {
                return max;
            }
            else
            {
                return data.peek();
            }
        }

        int min() {
            return min;
        }

        int max() {
            // write your code here
            return max;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            else if (str.startsWith("max")) {
                int val = st.max();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
