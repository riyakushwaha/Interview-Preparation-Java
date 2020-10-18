import java.util.Scanner;
/*
    Name: Find Prime Factorization of a Number
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/getting-started/prime-factorisation-official/ojquestion
    Statement: Print all its prime factors from smallest to largest.
*/
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
