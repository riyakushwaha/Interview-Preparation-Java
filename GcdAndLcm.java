import java.util.Scanner;
/*
    Name: GCD And LCM
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-in-arrays/first-index-official/ojquestion
    Statement:  Print GCD and LCM.
*/

public class GcdAndLcm {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int on1= n1;
        int on2= n2;

        while(n1!=0)
        {
            int temp = n2%n1;
            n2=n1;
            n1=temp;
        }

        System.out.println("GCD is: "+n2);
        System.out.println("LCM is "+ (on1*on2)/n2);

    }
}
