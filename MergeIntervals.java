/*
    Name: Merge Overlapping Intervals
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/merge-overlapping-interval-official/ojquestion
    Statement: You are given a number n, representing the number of time-intervals. In the next n lines, you are given a pair of space separated numbers.
    The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time). You are required to
    merge the meetings and print the merged meetings output in increasing order of start time
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Interval [] times = new Interval[arr.length];
        for(int i=0; i< arr.length; i++)
        {
            times[i] = new Interval(arr[i][0], arr[i][1]);
        }

        Arrays.sort(times);

        Stack<Interval> stk = new Stack<>();
        stk.push(times[0]);
        for(int i=1; i<arr.length ; i++)
        {
            if(times[i].startTime <= stk.peek().endTime)
            {
                stk.peek().endTime = Math.max(times[i].endTime, stk.peek().endTime);
            }
            else
            {
                stk.push(times[i]);
            }
        }

        Stack<Interval> stk1 = new Stack<>();
        while(!stk.isEmpty())
        {
            stk1.push(stk.pop());
        }

        while(!stk1.isEmpty())
        {
            Interval temp = stk1.pop();
            System.out.println(temp.startTime+" "+temp.endTime);
        }
    }

    public static class Interval implements Comparable<Interval>
    {
        int endTime;
        int startTime;

        Interval(int sT, int eT)
        {
            this.startTime = sT;
            this.endTime = eT;
        }

        @Override
        public int compareTo(Interval i1) {
            if(this.startTime != i1.startTime)
            {
                return this.startTime - i1.startTime;
            }
            else
            {
                return this.endTime - i1.endTime;
            }
        }
    }
}
