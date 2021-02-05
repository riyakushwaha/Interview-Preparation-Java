import java.io.*;
import java.util.*;

public class RepThreeTimesExceptOne  {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr) {
        //write your code here
        int tn = Integer.MAX_VALUE;
        int tnp1, tnp2, ctn, ctnp1, ctnp2;
        tnp1 = tnp2 = ctn = ctnp1 = ctnp2 = 0;

        for(int i : arr){
            ctn = tn & i;
            ctnp1 = tnp1 & i;
            ctnp2 = tnp2 & i;

            tn = tn & (~ctn);
            tnp1 = (tnp1 | ctn);

            tnp1 = tnp1 & (~ctnp1);
            tnp2 = (tnp2 | ctnp1);

            tnp2 = tnp2 & (~ctnp2);
            tn = (tn | ctnp2);
        }

        System.out.println(tnp1);

    }

}