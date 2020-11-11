import java.util.Scanner;

public class ProductExceptSelf {
    public static void main(String [] args)
    {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int [] arr = new int[n];
//        for(int i=0; i<n ; i++)
//        {
//            arr[i] = scanner.nextInt();
//        }
//        int [] res = productExceptSelf(arr);
//        for(int i: res)
//        {
//            System.out.print(i+" ");
//        }

        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while(test-- >0)
        {
            int n = scanner.nextInt();
            int [][] arr = new int[n][3];
            for(int i=0; i<arr.length; i++)
            {
                for(int j=0; j<3; j++)
                {
                    arr[i][j] = scanner.nextInt();
                }
            }

            int max = 0;
            for(int i=0; i<arr.length; i++)
            {
                if(max < arr[i][2]/(arr[i][0] +1) * arr[i][1])
                {
                    max = arr[i][2]/(arr[i][0]+1) * arr[i][1];
                }
            }

            System.out.println(max);

        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int [] arr = new int[nums.length];
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];

        left[0] = 1;
        right[nums.length-1] = 1;

        for(int i=1; i<left.length; i++)
        {
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i=right.length-2; i>=0; i--)
        {
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i=0; i<arr.length ; i++)
        {
            arr[i] = right[i] * left[i];
        }

        return arr;
    }
}
