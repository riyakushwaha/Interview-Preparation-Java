import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
    Name: Minimum Swaps 2
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/minimum-swaps-2/problem
    Statement: You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any
    duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort
    the array in ascending order.
*/
public class Minswap {

    // Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int temp=0;
		int count=0;
		int d = arr.length-1;

		for(int i=d; i>0;i--)
		{
			while(arr[i]!= i+1)
			{
				int val = arr[i]-1;
				temp = arr[val];
				arr[val]=arr[i];
				arr[i]=temp;
				count++;
			}
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
