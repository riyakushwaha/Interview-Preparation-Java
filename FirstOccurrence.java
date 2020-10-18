import java.util.Scanner;
/*
    Name: First Index (Find by Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-in-arrays/first-index-official/ojquestion
    Statement:  If x exists in array, print the first index where it is found otherwise print -1.
*/
public class FirstOccurrence {
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

        int num = firstIndex(arr, 0, x);
        System.out.println("result: " +num);
    }

    public static int firstIndex(int[] arr, int idx, int x){

        if(idx == arr.length)
        {
                return -1;
        }

        int index = firstIndex(arr, idx+1, x);
        if(arr[idx]==x)
        {
            return idx;
        }
        else
        {
            return index;
        }

    }
}
