/*
    Name: Postfix Evaluation and Conversion
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/postfix-evaluation-conversions-official/ojquestion
    Statement: You are given a postfix expression. You are required to evaluate it and print it's value then to convert it to infix and prefix and print them.
 */
import java.util.Scanner;
import java.util.Stack;

public class PostfixEvalNdConversion {

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
        Stack<String> prefix = new Stack<>();
        for(int i=0; i<exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(Character.isDigit(ch))
            {
                operand.push(ch-'0');
                prefix.push(ch+"");
                infix.push(ch+"");

            }
            else if(ch =='*' || ch=='/' || ch=='-' || ch=='+')
            {
                int val2 = operand.pop();
                int val1 = operand.pop();
                int res = evaluate(val1, val2, ch);
                operand.push(res);

                String in2 = infix.pop();
                String in1 = infix.pop();
                String pre2 = prefix.pop();
                String pre1 = prefix.pop();
                infix.push("(" + in1 + ch + in2+ ")");
                prefix.push(ch + pre1 + pre2);

            }
        }

        System.out.println(operand.peek());
        System.out.println(infix.peek());
        System.out.println(prefix.peek());
    }
}
