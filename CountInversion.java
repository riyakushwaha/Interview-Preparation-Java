
import java.util.*;

/*
    Name: Merge Sort: Counting Inversions
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/ctci-merge-sort/problem

    Statement: In an array,arr, the elements at indices i and j (where i<j ) form an inversion if arr[i]>arr[j].
    In other words, inverted elements arr[i] and arr[j] are considered to be "out of order". To correct an inversion,
    we can swap adjacent elements.

   ---------------------------- Incomplete. Need to try again-----------------------
*/
public class CountInversion {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
    int len = arr.length;

    long a = 0;


    return a;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.print("\nResult: "+result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
     //   }

       // bufferedWriter.close();

        scanner.close();
    }
}
