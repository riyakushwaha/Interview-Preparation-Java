import java.util.Scanner;
/*
    Name: Shell Rotate
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/shell-rotate-official/ojquestion
    Statement: You are given a number r, representing number of anti-clockwise rotations (for +ve numbers) of the shell s.
    You are required to rotate the sth shell of matrix by r rotations and display the matrix using display function.
*/
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

        rotateShell(arr, s, r);
        display(arr);
    }


    public static void rotateShell(int [][] arr, int s, int r)
    {
        int [] oneD = fillOneDFromShell(arr, s);
        rotate(oneD, r);
       fillShellFromOneD(arr, oneD, s);
    }

    public static int [] fillOneDFromShell(int [][]arr, int s)
    {
        int leastRow = s-1;//2
        int leastCol = s-1;//2
        int maxRow = arr.length -s;//5-3 = 2
        int maxCol = arr[0].length -s;// 7-3 =4
        int n = 2 * (maxRow - leastRow + maxCol - leastCol);
        int [] num = new int [n];
        int index =0;

        for(int i =leastRow ; i<=maxRow; i++)
        {
            num[index++] = arr[i][leastCol];
        }
        leastCol++;

        for(int i = leastCol; i<=maxCol; i++)
        {
            num[index++] = arr[maxRow][i];
        }
        maxRow--;

        for(int i = maxRow; i>leastRow; i--)
        {
            num[index++] = arr[i][maxCol];
        }

        for(int i =maxCol; i>=leastCol; i--)
        {
            num[index++] = arr[leastRow][i];
        }

        return num;

    }

    public static void fillShellFromOneD(int [][]arr, int [] oned, int s)
    {
        int leastRow = s-1;//1
        int leastCol = s-1;//1
        int maxRow = arr.length -s;//5-2 = 3
        int maxCol = arr[0].length -s;// 7-2 =5
        int index = 0;

        for(int i =leastRow ; i<=maxRow; i++)
        {
            arr[i][leastCol] = oned[index++];

        }
        leastCol++;

        for(int i = leastCol; i<=maxCol; i++)
        {
            arr[maxRow][i] = oned[index++];
        }
        maxRow--;

        for(int i = maxRow; i>leastRow; i--)
        {
            arr[i][maxCol] = oned[index++];
        }

        for(int i =maxCol; i>=leastCol; i--)
        {
            arr[leastRow][i] = oned[index++];
        }

    }

    public static void reverse(int [] oneDArray, int l, int r)
    {
        int temp;
        while(l<r)
        {
           temp = oneDArray[l];
           oneDArray[l]= oneDArray[r];
           oneDArray[r] = temp;
           l++;
           r--;
        }

    }

    public static void rotate(int [] oneDArray, int r)// r=3
    {
        int n = oneDArray.length;
        if(r<0)
        {
            r = r+n;
        }
        r = r%n;

        reverse(oneDArray, n-r, n-1);
        reverse(oneDArray, 0, n-r-1);
        reverse(oneDArray, 0, n-1);

    }


    public static void display(int [][] arr)
    {
        System.out.println("PRINTING ELEMENTS");
        for(int i =0; i<arr.length; i++)
        {
            for(int j =0; j<arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}


//        System.out.println("Rotated array");
//        for(int i =0; i<oneD.length; i++)
//        {
//            System.out.print(oneD[i]+" ");
//        }
