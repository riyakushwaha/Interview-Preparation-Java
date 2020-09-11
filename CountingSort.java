import java.util.Scanner;

public class CountingSort {

    public static int [] sort(int []arr, int n){

        int l1= n;
        int [] count = new int[10];
        int [] sortedArray = new int [n];
        for(int i =0; i<n; i++)
        {
            int index = arr[i];
            count[index]= count[index]+1;
        }

        for(int i =1; i<10; i++)
        {
            count[i]= count[i-1]+count[i];
        }

        for(int i =0; i<n; i++)
        {
            int a = arr[i];
            int index= count[a];
            count[a]= index-1;
            sortedArray[index-1]=a;
        }

return sortedArray;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String [] args)
    {

        int n = scanner.nextInt();
        int [] a = new int[n];

        for(int i =0; i<n; i++){
            a[i] = scanner.nextInt();
        }
       // System.out.println("Result: ");
        a= sort(a, n);
        for( int i =0; i<n; i++){
            System.out.print(a[i]+" ");
        }

    }
}
