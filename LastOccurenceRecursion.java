import java.util.Scanner;
/*
    Name: Last Index (Find by Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-in-arrays/last-index-official/ojquestion
    Statement:  If x exists in array, print the last index where it is found otherwise print -1.
*/
public class LastOccurenceRecursion {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int [n];

        for(int i =0; i<n ; i++)
        {
            arr[i] = scanner.nextInt();
        }

        int x = scanner.nextInt();

        int num = lastIndex(arr, 0, x);
        System.out.println("result: " +num);
    }

    public static int lastIndex(int[] arr, int idx, int x){

        if(idx == arr.length-1)
        {
            if(arr[idx]==x)
            {
                return idx;
            }
            else
            {
                return -1;
            }

        }

        int num = lastIndex(arr, idx+1, x);
        if(num==-1 && arr[idx]==x)
        {
            num = idx;
        }
        return num;
    }
}
