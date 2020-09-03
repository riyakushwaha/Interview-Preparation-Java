import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Regex {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        ArrayList<String> names = new ArrayList<String>();
        String myRegex = "[a-z]+@gmail.com";
        Pattern p = Pattern.compile(myRegex);

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            Matcher m = p.matcher(emailID);
            while(m.find()){
                names.add(firstName);
            }

        }



        Collections.sort(names);
        names.forEach((i)->System.out.println(i));
        scanner.close();
    }
}
