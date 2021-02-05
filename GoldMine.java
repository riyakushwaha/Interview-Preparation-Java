/*
    Name: Gold Mine (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion
 */
import java.util.Scanner;

public class GoldMine {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        int [][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int res = countPrice(arr, dp);
        System.out.println(res);
    }

    private static int countPrice(int[][] arr, int [][] dp) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0; i<arr.length; i++)
        {
           dp[i][0] = arr[i][0];
        }

        int temp;
        for(int j=1; j<arr[0].length; j++)
        {
            for(int i=0; i< arr.length; i++)
            {
                if(i==0)
                {
                    dp[i][j]+= Math.max(dp[i][j-1], dp[i+1][j-1]);
                }
                else if(i==arr.length-1)
                {
                    dp[i][j]+= Math.max(dp[i][j-1], dp[i-1][j-1]);
                }
                else
                {
                    temp = Math.max(dp[i-1][j-1], dp[i][j-1]);
                    dp[i][j]+= Math.max(temp, dp[i+1][j-1]);
                }

                dp[i][j]+= arr[i][j];
            }
        }

        temp = arr[0][m-1];
        for(int i=0; i<arr.length; i++)
        {
            if(temp<dp[i][m-1])
            {
                temp = dp[i][m-1];
            }
        }

        System.out.println("final dp");
        for (int i = 0; i < n; i++)
        {
            for(int j =0; j<m; j++)
            {
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }

        return temp;

    }


}
