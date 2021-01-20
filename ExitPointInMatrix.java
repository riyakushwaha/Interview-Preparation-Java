import java.util.Scanner;
/*
    Name: Exit Point Of a Matrix
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/exit-point-matrix-official/ojquestion

    Statement: Consider this array a maze and a player enters from top-left corner in east direction.
    The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
    You are required to print the indices in (row, col) format of the point from where you exit the matrix.
*/
public class ExitPointInMatrix {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i,j;
        Boolean rgt, lft, up, down;
        rgt = true;
        lft = up = down = false;

        int [][] arr = new int [n][m];

        for(i =0; i<n; i++)
        {
            for(j =0; j<m; j++)
            {
                arr[i][j]= scanner.nextInt();
            }
        }

        System.out.println("PRINTING RESULT");

        i=j=0;
        while(i<n && j<m)
        {
            System.out.println("Checking for index"+i+" and "+j );
            if(arr[i][j]==1)
            {
               if(lft)
               {
                   i--;
                   lft  = false;
                   up = true;
               }
               else if(rgt)
               {
                   i++;
                   rgt = false;
                   down = true;
               }
               else if(up)
               {
                    j++;
                    up = false;
                    rgt = true;

               }
               else if(down)
               {
                    j--;
                    down = false;
                    lft = true;
               }
            }
            else
            {
                if(lft)
                {
                    j--;
                }
                else if(rgt)
                {
                    j++;
                }
                else if(up)
                {
                    i--;
                }
                else if(down)
                {
                    i++;
                }
            }
        }


        if(i==n)
        {
            System.out.println(--i);
            System.out.println(j);
        }
        else{
            System.out.println(i);
            System.out.println(--j);
        }
    }
}
