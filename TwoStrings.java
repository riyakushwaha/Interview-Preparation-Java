import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

    int l1= s1.length();
    int l2= s2.length();
    int newVal =0;
    String result ="NO";
    Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();

    for(int i=0;i<l1;i++){
        char key = s1.charAt(i);
        Boolean value = ht.containsKey(key);
        if(value==false) {newVal=1;}
        ht.put(key,newVal);
    }

        for(int i=0;i<l2;i++){
            char key = s2.charAt(i);
            Boolean value = ht.containsKey(key);
            if(value==true) {result="YES";}
        }
     return (result);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
          //  bufferedWriter.newLine();
        }

       // bufferedWriter.close();

        scanner.close();
    }
}
