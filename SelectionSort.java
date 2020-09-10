import java.util.Scanner;

public class SelectionSort {

    public static void sort(int []arr, int n){

        int l1= n;
        for( int i =0; i<l1; i++)
        {
           // System.out.println("i: "+i);
            int min = arr[i];
            int j =i+1;
            int index =i;


            while(j<l1)
            {
               // System.out.println("j: "+j);
                if(min>arr[j]){
                    min = arr[j];
                    index =j;
                   // System.out.println("entered if: index is "+index);

                }
              //  System.out.println("min: "+min);
                j++;
            }

            if(index!=i)
            {//System.out.println("final: ");

                int temp = arr[i];
                arr[i]= min;
                arr[index]= temp;
            }

        }

        for( int i =0; i<l1; i++){
            System.out.print(arr[i]+" ");
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
