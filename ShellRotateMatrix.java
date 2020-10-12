import java.util.Scanner;

public class ShellRotateMatrix {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //5
        int m = scanner.nextInt(); //7

        int [][] arr = new int [n][m];

        for(int i =0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                arr[i][j]= scanner.nextInt();
            }
        }

        int s = scanner.nextInt();//2
        int r = scanner.nextInt();//3

        int leastRow = s-1;//1
        int leastCol = s-1;//1
        int maxRow = n-s;// 5-2 = 3
        int maxCol = m-s;// 7-2 = 5

        r = r%((n-leastCol)*(m-leastCol));
        System.out.println("r is "+r);
        //Left Column
        while(r>0) //3
        {
            //int a = arr[leastRow][leastCol];//22
            int b = arr[maxRow][leastCol];//
            int c = arr[maxRow][maxCol];
            int d = arr[leastRow][maxCol];

            for(int i = maxRow; i>leastRow; i--)//3,2
            {
                arr[i][leastCol]= arr[i-1][leastCol];
               // System.out.println("arr["+i+"]["+leastCol+"]= arr["+(i-1)+"]["+leastCol+"]");
            }

            for(int i = maxCol; i>leastCol; i--)//5,4,3,2
            {
                arr[maxRow][i]= arr[maxRow][i-1];
               // System.out.println("arr["+maxRow+"]["+i+"]= arr["+maxRow+"]["+(i-1)+"]");
            }
            arr[maxRow][leastCol+1]= b;
           // System.out.println("arr["+maxRow+"]["+(leastCol+1)+"]= is:"+b);


            for(int i = leastRow; i<maxRow; i++)//1,2
            {
                arr[i][maxCol]= arr[i+1][maxCol];
               // System.out.println("arr["+i+"]["+maxCol+"]= arr["+(i+1)+"]["+maxCol+"]");
            }
            arr[maxRow-1][maxCol] =c;
           // System.out.println("arr["+maxRow+"]["+(maxCol-1)+"]= is:"+c);

            for(int i = leastCol; i<maxCol; i++)//1,2,3,4
            {
                arr[leastRow][i]= arr[leastRow][i+1];
               // System.out.println("arr["+leastRow+"]["+i+"]= arr["+leastRow+"]["+(i+1)+"]");
            }

            arr[leastRow][maxCol-1]=d;
           // System.out.println("arr["+leastRow+"]["+(maxCol-1)+"]= is:"+b);

            r--;
        }


        System.out.println("PRINTING ELEMENTS");
        for(int i =0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
