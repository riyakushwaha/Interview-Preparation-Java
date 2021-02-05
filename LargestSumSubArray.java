import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
    Name: Sub-array with maximum sum
    Source: GeeksForGeeks
    Link: https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
*/
public class LargestSumSubArray {

    public static void main(String[] args) throws java.io.IOException
    {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while(test>0)
        {
            int n = scanner.nextInt();
            int [] arr = new int [n];

            for(int i =0; i<n ; i++)
            {
                arr[i] =scanner.nextInt();
            }
            int sum=0;
            int max=arr[0];

            for(int i =0; i<n ; i++)
            {

                sum+= arr[i];
                if(max<sum)
                {
                    max=sum;
                }
                if(sum<0)
                {
                    sum=0;
                }

            }
            System.out.println(max);

            test--;
        }

    }
}
