import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
    Name: Poisonous Plants
    Source: HackerRank
    Link: https://www.hackerrank.com/contests/technoliterati-test-3/challenges/poisonous-plants/problem

 ---------------------------- Incomplete. Need to try again-----------------------
*/public class PoisonousPlants {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {

        int len = p.length;
        int i;
        List<Integer> l1 = new ArrayList<Integer>();

        for( i=0; i<len ; i++)
        {
           l1.add(p[i]);
        }

        for( i=0; i<l1.size() ; i++)
        {
            boolean flag =false;
            for(int j =l1.size()-1; j>0; j--)
            {
                if (l1.get(j) > l1.get(j-1) )
                {

                    int a =l1.remove(j);
                   // System.out.println("removed " +a);
                    flag= true;
                }

            }

            if(!flag)
            {
                break;
            }
        }
    return i;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);
        System.out.println("result" +result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}