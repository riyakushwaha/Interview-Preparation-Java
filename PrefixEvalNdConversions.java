/*
    Name: Prefix Evaluation and Conversion
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/prefix-official/ojquestion
    Statement: You are given a prefix expression. You are required to evaluate it and print it's value then to convert it to infix and postfix and print them.
 */
import java.util.Scanner;
import java.util.Stack;

public class PrefixEvalNdConversions {
    public static int evaluate(int val1, int val2, char op)
    {
        if(op == '*')
        {
            return val1  * val2;
        }
        else if(op == '/')
        {
            return val1 / val2;
        }
        else if(op == '+')
        {
            return val1 + val2;
        }
        else
        {
            return val1 - val2;
        }
    }

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();

        Stack<Integer> operand = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for(int i=exp.length()-1; i>=0; i--)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
            {
                operand.push(ch-'0');
                postfix.push(ch+"");
                infix.push(ch+"");

            }
            else if(ch =='*' || ch=='/' || ch=='-' || ch=='+')
            {
                int val1 = operand.pop();
                int val2 = operand.pop();
                int res = evaluate(val1, val2, ch);
                operand.push(res);

                String in1 = infix.pop();
                String in2 = infix.pop();
                String post1 = postfix.pop();
                String post2 = postfix.pop();
                infix.push("(" + in1 + ch + in2+ ")");
                postfix.push(post1 + post2+ ch);

            }
        }

        System.out.println(operand.peek());
        System.out.println(infix.peek());
        System.out.println(postfix.peek());
    }
}
