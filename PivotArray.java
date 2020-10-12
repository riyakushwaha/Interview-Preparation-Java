import java.util.Scanner;

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
          //  System.out.println("left and right sum are: "+lftSum+" and "+rgtSum);
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
