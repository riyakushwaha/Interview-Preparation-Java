/*
    Name: Balanced Brackets
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/balanced-brackets-official/ojquestion
    Statement:  You are given a string exp representing an expression. You are required to check if the expression is balanced
    i.e. closing brackets and opening brackets match up well.
 */
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch=='[' || ch=='{' || ch=='(')
            {
                stk.push(ch);
            }
            else if(ch==']' || ch=='}' || ch==')')
            {
                if(stk.isEmpty())
                {
                    System.out.println("false");
                    return;
                }
                else if(ch==']' && stk.peek() =='[')
                {
                    stk.pop();
                }
                else if(ch=='}' && stk.peek() =='{')
                {
                    stk.pop();
                }
                else if(ch==')' && stk.peek() =='(')
                {
                    stk.pop();
                }
                else
                {
                    System.out.println("false");
                    return;
                }
            }
        }

        if(stk.isEmpty())
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

    }
}
