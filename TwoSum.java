import java.util.*;
/*
    Name: Two Sum
    Source: LeetCode
    Link: https://leetcode.com/problems/two-sum/
    Statement: Given an array of integers nums and an integer target, return indices of the two numbers such
    that they add up to target.
*/
public class TwoSum{

    // Complete the countSwaps function below.
    static void twosum(int[] nums, int target) {

        List<Integer> lt = new ArrayList<Integer>();
        int [] res = new int[2];

        for(int i =0 ; i<nums.length; i++)
        {
            if(lt.contains(target-nums[i]))
            {
                res[1]= i;
                res[0]= lt.indexOf(target-nums[i]);
                break;
            }
            else
            {
                lt.add(nums[i]);
            }
        }

        System.out.println("Result: ");
        for(int i : res)
        {
            System.out.println(i);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int target = scanner.nextByte();

     twosum(a,target );

        scanner.close();
    }
}
