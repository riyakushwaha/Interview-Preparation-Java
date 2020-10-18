import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/*
    Name: Frequency Queries
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/2d-array/problem
*/
public class HourGlassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    int sum =0;
	int flag=1;
    int largestSum=0;
    int row = arr.length;
    int col = arr[0].length;
    for(int i =0; i<row-2 ; i++)
    {
        for (int j =0; j<col-2; j++)
        {
            for(int a =j; a<j+3; a++)
            {
                sum += arr[i][a];
				System.out.println("After"+sum);
                sum += arr[i+2][a];
				System.out.println("Later"+sum);
                if(a==j+2)
                {
					System.out.println("Entered if");
					sum+= arr[i+1][a-1];
					if(flag==1)
					{
					largestSum=sum;
					flag = 0;
					}
					
                    if(largestSum <sum){
					System.out.print(largestSum +" "+sum);
					largestSum = sum;
					System.out.println(largestSum);}
					sum = 0;					
                }
            }
        }
    }
    return largestSum;
    }

   // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
		if(-2>-9){System.out.println("Good work");}
        int[][] arr = { { -1, -1, 0, -9, -2, -2},
						{ -2 ,-1, -6, -8, -2, -5 },
						{ -1, -1, -1, -2, -3, -4},
						{-1, -9, -2, -4, -4, -5 },
						{ -7, -3, -3, -2, -9, -9 },
						{ -1, -3, -1, -2, -4, -5 }};
	 //System.out.println("Enter values ");
       /* for (int i = 0; i < 6; i++) {
            
            for (int j = 0; j < 6; j++) {
               arr[i][j]=sc.nextInt();
            }
        }*/

        int result = hourglassSum(arr);

       System.out.println(result);
    }
}
