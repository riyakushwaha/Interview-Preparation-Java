import java.util.Scanner;
/*
    Name: Search In A Sorted Matrix
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/search-in-a-sorted-2d-array-official/ojquestion
    Statement: You are required to find x in the matrix and print it's location int (row, col) format as discussed in
    output format below.
*/
public class SearchInMatrix {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int data = scanner.nextInt();
        int i = 0;
        int j = n-1;
        while(i<arr.length && j>=0)
        {
            if(arr[i][j]==data)
            {
                System.out.println(i);
                System.out.println(j);
                return;
            }
            else if(data> arr[i][j])
            {
                i++;
            }
            else
            {
                j--;
            }

        }

        System.out.println("Not Found");



    }
}
