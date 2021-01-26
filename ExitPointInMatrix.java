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
        int [][] arr = new int [n][m];

        for(int i =0; i<n; i++)
        {
            for(int j =0; j<m; j++)
            {
                arr[i][j]= scanner.nextInt();
            }
        }

        int i, j, dir;
        i = j = dir =0;
        while(true){
            dir = (dir + arr[i][j]) % 4;

            if(dir == 0){
                j++;
            }else if(dir == 1){
                i++;
            }else if(dir == 2){
                j--;
            }
            else{
                i--;
            }

            if(i<0){
                i++;
                break;
            }else if(j<0){
                j++;
                break;
            }else if(i == arr.length){
                i--;
                break;
            }else if(j == arr[0].length){
                j--;
                break;
            }
        }

        System.out.println(i);
        System.out.println(j);
    }
}
