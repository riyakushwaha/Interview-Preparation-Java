import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    Name: Leaders In An Array
    Source: GeeksForGeeks
    Link: https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0
    Statement: An element of array is leader if it is greater than or equal to all
    the elements to its right side. Also, the rightmost element is always a leader.
*/


public class ArrayLeader {

    public static void main(String[] args) throws java.io.IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();
        while(test>0)
        {
            int n = Integer.parseInt(br.readLine());
            int [] arr = new int [n];
            String [] st = (br.readLine()).split(" ");
            for(int i =0; i<n; i++)
            {
                arr[i] = Integer.parseInt(st[i]);
            }

            int max = -1;
            for(int i =n-1; i>=0; i--)
            {
                if(max<=arr[i])
                {
                   max = arr[i];
                   stk.push(max);
                }

            }

            while(!stk.empty())
            {
                System.out.print(stk.pop()+" ");
            }
            System.out.println("");
            test--;
        }

    }
}
