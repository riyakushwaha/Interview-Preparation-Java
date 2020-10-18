import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    Name: All Indices of Array
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-in-arrays/all-indices-official/ojquestion

    Statement: Return an array of appropriate size which contains all indices at which x occurs in array a.
*/

public class AllOccurrenceRecursion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here

        if(idx == arr.length)
        {
            int [] abc = new int [fsf];
            return abc;
        }

        if(arr[idx]==x)
        {
            fsf+=1;
        }

        int [] num = allIndices(arr, x, idx+1, fsf);
        if(arr[idx]==x)
        {
            num[--fsf] = idx;
        }
        return num;

    }
}
