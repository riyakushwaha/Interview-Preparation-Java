import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] solve(int[] arr)
    {
        Stack<Integer> stk = new Stack<>();
        int [] array = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--)
        {
            while(!stk.isEmpty() && stk.peek() > arr[i])
            {
                stk.pop();
            }

            if(stk.isEmpty())
            {
                array[i] = -1;
            }
            else
            {
                array[i] = stk.peek();
            }

            stk.push(arr[i]);
        }

        return array;
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\t");
        }
        System.out.println(sb);
    }

    public static void main(String [] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }
}
