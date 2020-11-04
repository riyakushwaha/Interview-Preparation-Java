/*
    Name: Infix Conversions
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/infix-conversions-official/ojquestion
    Statement: You are given an infix expression. You are required to convert it to postfix and prefix and print them in separate lines.
 */
import java.util.Scanner;
import java.util.Stack;

public class InfixConversions {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();

        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> operator = new Stack<>();
        char op;
        String pre1, pre2, post1, post2;
        for(int i=0; i<exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(ch == '(')
            {
                operator.push(ch);
            }
            else if(ch == ')')
            {
                while(operator.peek()!= '(')
                {
                    post2 = postfix.pop();
                    post1 = postfix.pop();
                    pre2 = prefix.pop();
                    pre1 = prefix.pop();
                    op = operator.pop();

                    postfix.push(post1+post2+op);
                    prefix.push(op+pre1+pre2);
                }
                operator.pop();
            }
            else if(ch =='*' || ch =='/'|| ch=='+' || ch=='-')
            {
                while(!operator.isEmpty() && precedence(ch)<= precedence(operator.peek()) )
                {
                    post2 = postfix.pop();
                    post1 = postfix.pop();
                    pre2 = prefix.pop();
                    pre1 = prefix.pop();
                    op = operator.pop();

                    postfix.push(post1+post2+op);
                    prefix.push(op+pre1+pre2);
                }
                operator.push(ch);
            }
            else
            {
                prefix.push(ch+"");
                postfix.push(ch+"");
            }

        }

        while(!operator.isEmpty())
        {
            post2 = postfix.pop();
            post1 = postfix.pop();
            pre2 = prefix.pop();
            pre1 = prefix.pop();
            op = operator.pop();

            postfix.push(post1+post2+op);
            prefix.push(op+pre1+pre2);
        }

        System.out.println(postfix.peek());
        System.out.print(prefix.peek());
    }

    public static int precedence(char op)
    {
        if(op == '*' || op =='/')
        {
            return 2;
        }
        else if(op == '+' || op =='-')
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

}
