/*
    Name: Next Greater Element To The Right
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/next-greater-element-official/ojquestion
    Statement:  You are given a number n, representing the size of array a. You are given n numbers, representing elements of array a.
    You are required to "next greater element on the right" for all elements of array. "Next greater element on the right" of an element x is defined as the
    first element to right of x having value greater than x. Note -> If an element does not have any element on it's right side greater than it, print -1.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] solve(int[] arr)
    {
        Stack<Integer> stk = new Stack<>();
        int [] array = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--)
        {
            while(!stk.isEmpty() && stk.peek() < arr[i])
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
            sb.append(val + "\n");
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


