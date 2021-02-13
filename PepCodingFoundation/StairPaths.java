/*
    Name: Stair Path (Using Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-stair-paths-official/ojquestion
    Statement: You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps
    in one move. Complete the body of getStairPaths function to get the list of all paths that can be used to climb
    the staircase up.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class StairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();

        ArrayList<String> res = getStairPaths(n);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(n<0)
        {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> list1 = getStairPaths(n-1);
        ArrayList<String> list2 = getStairPaths(n-2);
        ArrayList<String> list3 = getStairPaths(n-3);

        ArrayList<String> result = new ArrayList<>();

        for(String st: list1)
        {
            result.add(1+ st);
        }
        for(String st: list2)
        {
            result.add(2+ st);
        }
        for(String st: list3)
        {
            result.add(3+ st);
        }

        return result;
    }
}
