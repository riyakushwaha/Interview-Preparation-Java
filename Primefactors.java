import java.util.Scanner;

public class Primefactors {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 2;

        while(n!=1)
        {
            if(n%i==0)
            {
                n = n/i;
                System.out.print(i+" ");
            }
            else
            {
                i++;
            }
        }


    }
}
