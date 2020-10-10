import java.util.Scanner;

public class ButterflyPattern {

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int  spaces;

        for(int i=n-1; i>=0; i--)
        {
            spaces = i*2;

            int rt = n-i;
            int lt = n-i;

            while(rt>0)
            {
                System.out.print("*");
                rt--;
            }

            while(spaces>0)
            {
                System.out.print(" ");
                spaces--;
            }

            while(lt>0)
            {
                System.out.print("*");
                lt--;
            }

            System.out.println("");
        }

        for(int i=0; i<n; i++)
        {
            spaces = i*2;

            int rt = n-i;
            int lt = n-i;

            while(rt>0)
            {
                System.out.print("*");
                rt--;
            }

            while(spaces>0)
            {
                System.out.print(" ");
                spaces--;
            }

            while(lt>0)
            {
                System.out.print("*");
                lt--;
            }

            System.out.println("");
        }




    }
}
