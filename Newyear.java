import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Newyear {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int temp, count, j,i, largestAt, diff;
        temp= count=j= largestAt=diff=i =0;

        int d= q.length-1;

        for (i=d; i>0; i--){
            j=i;
            System.out.println("Value of i and j is "+i);
            while(q[j]!=(i+1)&&j>0){
			System.out.println("Entered while for j: "+j);
                j--;
            }

            largestAt = j;
			System.out.println("Largest at "+largestAt);
            diff = Math.abs(i-largestAt);
			System.out.println("Diff is "+diff);
            if(diff>2){
                System.out.println("Too chaotic\n\n");
				System.out.println("Entered if of diff");
                break;
            }
            while(largestAt<i){
                temp = q[largestAt];
                q[largestAt]= q[largestAt +1];
                q[largestAt+1]=temp;
                largestAt++;
                count++;
				System.out.println("Entered last while");
            }
        }
		 System.out.println("Out of loop\n\n");
        if(i==0){
      System.out.println(count);
       
        }
  
    }

  //  private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       //   Scanner scanner = new Scanner(System.in);
         //   int n = scanner.nextInt();
 
            int[] q = {1,2,5,3,7,8,6,4};

            minimumBribes(q);
        }

    }

