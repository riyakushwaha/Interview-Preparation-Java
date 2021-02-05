/*
    Name: Smallest Number Following Pattern
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/smallest-number-following-pattern-official/ojquestion
    Statement: You are given a pattern of upto 8 length containing characters 'i' and 'd'. 'd' stands for decreasing and 'i' stands for increasing
    You have to print the smallest number, using the digits 1 to 9 only without repetition, such that the digit decreases following a d and increases following an i.
    HERE IT IS IMPLEMENTED USING STACK 0(N) SPACE, WE CAN DO IT WITH O(1) SPACE TOO BY USING THE SAME LOGIC.
 */
import java.util.Scanner;
import java.util.Stack;

public class SmallestNumInPattern {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Integer> stk = new Stack<>();
        int ctr = 1;
        for(int i =0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            stk.push(ctr);
            ctr++;
            if(ch == 'i')
            {
                while(!stk.isEmpty())
                {
                    System.out.print(stk.pop()+" ");
                }
            }

        }
        stk.push(ctr);
        while(!stk.isEmpty())
        {
            System.out.print(stk.pop()+" ");
        }

    }

}
