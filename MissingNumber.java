/*
    Name: Missing Number
    Source: LeetCode
    Link: https://leetcode.com/problems/missing-number/
 */

import java.util.Scanner;
public class MissingNumber {

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] nums = new int[n];

        for(int i=0; i<n ; i++)
        {
            nums[i] = scanner.nextInt();
        }
        int res = missingNumber(nums);
        System.out.println(res);
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n* (n+1)) /2;
        for(int i: nums)
        {
            sum-=i;
        }
        return sum;
    }
}
