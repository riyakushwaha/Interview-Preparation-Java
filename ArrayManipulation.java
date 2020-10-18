/*
    Name: Array Manipulation
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/crush/problem

    Statement: Starting with a 1-indexed array of zeros and a list of operations, for each operation add
     a value to each of the array element between two given indices, inclusive. Once all operations have
     been performed, return the maximum value in the array.

   ---------------------------- Incomplete. Need to try again-----------------------
*/

public class ArrayManipulation {


    static long arrayManipulation(int n, int[][] queries) {

	int start, end, value,largest;
	int row= queries.length;
	int [] arr = new int [n];

	for(int i=0; i<row; i++)
	{
		start = queries[i][0]-1;
		end= queries[i][1];
		value = queries[i][2];

		arr[start]+= value;
		if(end!=n){
			arr[end]+= -(value);
		}
	}

	for(int i=1; i<n ; i++)
	{
		arr[i]= arr[i]+arr[i-1];
	}

	largest = arr[0];
	for(int i=1; i<n ; i++)
	{
		if(largest<arr[i])
			{
				largest= arr[i];
			}
	}


	return largest;
    }

   // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
  
	int [][] queries= {{1,2,100},{2,5,100},{3,4,100}};

        long result = arrayManipulation(5, queries);
		System.out.println(result);
   
    }
}
