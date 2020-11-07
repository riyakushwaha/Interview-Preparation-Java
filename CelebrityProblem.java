/*
    Name: Celebrity Problem
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/celebrity-problem-official/ojquestion
    Statement: You are given a number n, representing the number of people in a party. You are given n strings of n length containing 0's and 1's
    If there is a '1' in ith row, jth spot, then person i knows about person j.A celebrity is defined as somebody who knows no other person than himself but everybody
    else knows him. If there is a celebrity print it's index otherwise print "none"
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<arr.length; i++)
        {
            stk.push(i);
        }

        while(stk.size()>=2)
        {
            int i = stk.pop();
            int j = stk.pop();

            if(arr[i][j]==1)
            {
                stk.push(j);
            }
            else
            {
                stk.push(i);
            }
        }

        int cel = stk.pop();

        for(int i=0; i<arr.length; i++)
        {
            if(i!=cel)
            {
                if(arr[cel][i]==1 || arr[i][cel]==0)
                {
                    System.out.println("none");
                    return;
                }
            }
        }

        System.out.println(cel);

    }
}
