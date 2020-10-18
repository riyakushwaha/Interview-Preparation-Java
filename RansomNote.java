import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
    Name: Ransom Notes
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
*/
public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        int l1= magazine.length;
        int l2 = note.length;
        Boolean ctr=true;
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

        for(int i =0;i<l1;i++){
            String key = magazine[i];
            Boolean value = ht.containsKey(key);
            int newVal = (value==false)? 1: ht.get(key)+1;
            ht.put(key,newVal);
        }

        ht.forEach((k,v)->System.out.println("Key: "+k +", Value: "+ v));

        for(int i =0; i<l2;i++) {

                String key = note[i];
                Boolean value = ht.containsKey(key);
                int newVal = (value == false) ? -1 : (ht.get(key) - 1);
                ht.put(key, newVal);
                if (newVal <0) {
                    ctr = false;
                    break;
                 }
        }
        if(ctr){ System.out.println("Yes");}
        else {System.out.println("No");}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
