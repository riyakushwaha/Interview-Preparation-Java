import java.util.Scanner;

public class QuickSort {

    public static int partition(int lb, int ub, int []arr){

            int start = lb;
            int end = ub;
            int pivot = arr[end];
        int j=-1;
            System.out.println("\nstart: "+start);
            System.out.println("end: "+end);
            System.out.println("pivot: "+pivot);

            for(int i=0; i<=end; i++)
            {

               if(arr[i]<=pivot)
               {
                   j++;
                   int temp = arr[j];
                   arr[j]= arr[i];
                   arr[i]=temp;

               }
            }

        for( int i =0; i<=end; i++){
           // System.out.print(arr[i]+" ");
        }
            return j;

    }

    private static  void quicksort(int lb, int ub, int []arr){
        if(lb<ub){
            int a = partition(lb, ub, arr);
            quicksort(lb, a-1, arr);
            quicksort(a+1, ub, arr);
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

        quicksort(0, n-1, a);
        System.out.print("\nResult: ");
        for( int i =0; i<n; i++){
            System.out.print(a[i]+" ");
        }

    }
}
