import java.util.Scanner;

public class MergeSort {
// len =7, lb =0, mid = 3, ub=6
    public static void merge(int lb,int mid , int ub, int []arr){
        int n1 = mid - lb + 1;
        int n2 = ub - mid;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[lb + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = lb;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    private static  void mergesort(int lb, int ub, int []arr){
        if(lb<ub){
            int mid = (lb+ub)/2;
            mergesort(lb, mid, arr);
            mergesort( mid+1,ub, arr);
            merge(lb, mid, ub, arr);

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

        mergesort(0, n-1, a);
        System.out.print("\nResult: ");
        for( int i =0; i<n; i++){
            System.out.print(a[i]+" ");
        }

    }
}
