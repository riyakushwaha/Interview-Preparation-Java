/*
    Name: Infix Evaluation
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/infix-evaluation-official/ojquestion
    Statement: You are given an infix expression. Evaluate and print it's value.
 */
import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        char op;
        int val1, val2, res;
        for(int i=0; i<exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(ch =='(')
            {
                operator.push(ch);
            }
            else if(Character.isDigit(ch))
            {
                operand.push(ch - '0');
            }
            else if( ch == ')')
            {
                while(operator.peek()!='(')
                {
                   op = operator.pop();
                   val2 = operand.pop();
                   val1 = operand.pop();
                   res = evaluate(val1, val2, op);
                   operand.push(res);
                }
                operator.pop();
            }
            else if(ch =='*' || ch =='/'|| ch=='+' || ch=='-')
            {
                while(!operator.isEmpty() && precedence(ch)<= precedence(operator.peek()) )
                {
                   // System.out.print("pushed "+ch);
                    op = operator.pop();
                    val2 = operand.pop();
                    val1 = operand.pop();
                    res = evaluate(val1, val2, op);
                    operand.push(res);
                }
                operator.push(ch);
            }
        }

        while (!operator.isEmpty())
        {
            op = operator.pop();
            val2 = operand.pop();
            val1 = operand.pop();
            res = evaluate(val1, val2, op);
            operand.push(res);
        }
        System.out.print(operand.peek());

    }

    public static int evaluate(int val1, int val2, char operator)
    {
        return switch (operator) {
            case '*' -> val1 * val2;
            case '/' -> val1 / val2;
            case '+' -> val1 + val2;
            case '-' -> val1 - val2;
            default -> -1;
        };
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
