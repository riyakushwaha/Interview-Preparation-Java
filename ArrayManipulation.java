import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
	
	int start, end, value,largest;
	start = largest =end=value=0; 
	int row= queries.length;
	int [] arr = new int [n];
	
	for (int i = 0; i<row; i++){
		start = queries[i][0];
		end = queries[i][1];
		value = queries[i][2];
	
		for(int j=start-1; j<end; j++){
			arr[j]+=value;
			}
	}
	for(int i =0; i<arr.length; i++){

		System.out.println(arr[i]);
	}
	largest = arr[0];
	for(int i =0; i<arr.length; i++){
		if(largest<arr[i])
		{
		largest= arr[i];
		}
	}
	return largest;
    }

   // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
  
	int [][] queries= {{1,5,3},{4,8,7},{6,9,1}};

        long result = arrayManipulation(10, queries);
		System.out.println(result);
   
    }
}
