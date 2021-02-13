/*
    Name: Stock Span
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/stock-span-official/ojquestion
    Statement: You are given a number n, representing the size of array a. You are given n numbers, representing the prices of a share on n days.
    You are required to find the stock span for n days. Stock span is defined as the number of days passed between the current day and the first day
    before today when price was higher than today.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\t");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int [] array = new int[arr.length];
        stk.push(arr.length-1);
        for(int i=arr.length-2 ; i>=0; i--)
        {
            while(!stk.isEmpty() && arr[stk.peek()]<arr[i])
            {
                array[stk.peek()] = stk.peek() - i;
                stk.pop();
            }
            stk.push(i);
        }

        while(!stk.isEmpty())
        {
            array[stk.peek()] = stk.peek()+1;
            stk.pop();
        }

        return array;
    }

}
