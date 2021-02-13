/*
    Name: Duplicate Brackets
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/duplicate-brackets-official/ojquestion
    Statement:  You are given a string exp representing an expression. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
    But, some of the pair of brackets maybe extra/needless. You are required to print true if you detect extra brackets and false otherwise.
 */
import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch==')')
            {
                if(stk.peek()=='(')
                {
                    System.out.println("true");
                    return;
                }
                else
                {
                    while(stk.peek()!='(')
                    {
                        stk.pop();
                    }
                    stk.pop();
                }
            }
            else
            {
                stk.push(ch);
            }
        }

        System.out.println("false");


    }
}
