import java.util.Scanner;

public class InsertionSort {

    public static void sort(int []arr, int i){

        int l1= i;
        for( i =1; i<l1; i++)
        {
            int temp = arr[i];
            int j =i-1;
            while(j>=0 && arr[j]>temp)
            {
             arr[j+1]=arr[j];
             j--;
            }
            arr[j+1]=temp;

            for( int k =0; k<l1; k++){
                System.out.print(arr[k]+" ");

            }
            System.out.println("");
        }


    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String [] args)
    {

        int n = scanner.nextInt();
        int [] a = new int[n];

        for(int i =0; i<n; i++){
            a[i] = scanner.nextInt();
        }

        sort(a, n);

    }
}
