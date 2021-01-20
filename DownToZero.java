import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
    Name: Down to Zero II
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/down-to-zero-ii/problem
*/

public class DownToZero {

    /*
     * Complete the downToZero function below.
     */
    static int downToZero(int n) {
        /*
         * Write your code here.
         */

        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);
            System.out.println(result);
        //    bufferedWriter.write(String.valueOf(result));
        //    bufferedWriter.newLine();
        }

       // bufferedWriter.close();
    }
}
