import java.util.Scanner;
/*
    Name: Find Pivot Index
    Source: LeetCode
    Link: https://leetcode.com/problems/find-pivot-index/
    Statement: The pivot index as the index where the sum of all the numbers to the left of the index is equal to the
    sum of all the numbers to the right of the index.
*/
public class PivotArray {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] nums = new int [n];
        int lftSum, rgtSum;
        lftSum = rgtSum = 0;
        int index = -1;

        for(int i =0; i<n; i++)
        {
            nums[i]= scanner.nextInt();
            rgtSum += nums[i];
        }

        for(int i =0; i<n; i++)
        {
            rgtSum-= nums[i];
            if(lftSum == rgtSum)
            {
                index = i;
                break;
            }
            lftSum+= nums[i];
        }

        System.out.println(index);
    }

}
