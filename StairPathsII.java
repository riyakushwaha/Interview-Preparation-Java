/*
    Name: Stair Paths (Using Recursion - Second Method - Optimized)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-stair-paths-official/ojquestion
    Statement: You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps
    in one move. Complete the body of getStairPaths function to get the list of all paths that can be used to climb
    the staircase up.
*/
import java.util.Scanner;

public class StairPathsII {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {

        if(n==0)
        {
            System.out.println(path);
            return;
        }
        if(n<0)
        {
            return;
        }

        for(int i =1; i<=3; i++)
        {
            printStairPaths(n-i, path+i);
        }
    }
}
