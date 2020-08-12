import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

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

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	
          int[] arr = {8, 45, 35, 84, 79, 12, 74, 92, 81,
		  82, 61, 32, 36, 1 ,65, 44, 89, 40, 28, 20, 97, 90,
		  22, 87, 48, 26, 56, 18, 49, 71, 23, 34, 59, 54, 14,
		  16, 19, 76, 83, 95, 31, 30, 69, 7 ,9, 60, 66, 25, 52,
		  5 ,37, 27, 63, 80, 24, 42, 3, 50, 6 ,11, 64, 10, 96, 47,
		  38, 57, 2 ,88, 100, 4, 78, 85, 21, 29, 75, 94, 43, 77, 
		  33 ,86, 98, 68, 73, 72, 13, 91, 70, 41, 17, 15, 67, 93, 
		  62 ,39, 53, 51, 55, 58, 99, 46};
		  
	// int [] arr ={3, 7, 6, 9 ,1, 8, 10, 4 ,2 ,5};

        int res = minimumSwaps(arr);
		System.out.println(res);

       
    }
}

   /* int count=0;
		int val =-1;
        int d = arr.length-1;
        for(int i=d; i>0 ; i--){
            for (int j=0; j<=i-1;j++){
			
                if(arr[i]<arr[j] && val<j){
				val=j;
				}
				
				{
                    temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                    count++;
                }     
				}
			temp = arr[val];
            arr[val]=arr[i];
            arr[i]=temp;
            count++;
        }
        return count;*/