import java.util.*;
import java.lang.*;
import java.util.Queue;

/*
    Name: Morgan And a String
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/morgan-and-a-string/problem

 ---------------------------- Incomplete. Need to try again-----------------------
*/
public class MorganAndString {
// Complete the morganAndString function below.
    static String morganAndString(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();

       StringBuilder s = new StringBuilder("");
        int flag =0;

        Queue<String> q1  = new LinkedList<>();
        Queue<String> q2  = new LinkedList<>();

        for(int i =0; i<l1; i++)
        {
            q1.add(a.substring(i, i+1));
        }
        for(int i =0; i<l2; i++)
        {
            q2.add(b.substring(i, i+1));
        }

        while(!q1.isEmpty() && !q2.isEmpty())
        {
            String v1 = q1.peek();
            String v2 = q2.peek();
            if(v1.compareTo(v2)>0)
            {
                s.append(q2.remove());
                flag =1;
            }
            else if(v1.compareTo(v2)<0)
            {
                s.append(q1.remove());
                flag =2;
            }
            else
            { s.append(q1.remove());            }


        }
        while(!q1.isEmpty())
        {
            s.append(q1.remove());

        }
        while(!q2.isEmpty())
        {
            s.append(q2.remove());
        }

    String ans = s.toString();
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = morganAndString(a, b);

            System.out.println("Result "+result);
        }
        scanner.close();
    }
}