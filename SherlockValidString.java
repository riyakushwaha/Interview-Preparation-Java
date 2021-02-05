import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
/*
    Name: Sherlock and the Valid String
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

    ---------------------------- Incomplete. Need to try again-----------------------
*/
public class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        int len = s.length();
        char [] val = s.toCharArray();
        Hashtable<Character, Integer> ht1 = new Hashtable<Character, Integer>();

        for(int i =0; i<len; i++)
        {
            int value = ht1.getOrDefault(val[i],0)+1;
            ht1.put(val[i], value );

        }

        System.out.println("h1");
        ht1.forEach((k,v)->  System.out.println("Key: "+k+" Value: "+v)     );
        int value = ht1.get(val[0]);
        List<Integer> list = new ArrayList<>();

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);
        scanner.close();
    }
}
