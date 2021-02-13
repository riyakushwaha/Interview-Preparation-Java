import java.util.Scanner;
/*
    Name: The Curious Case Of Benjamin Bulbs
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/getting-started/benjamin-bulbs-official/ojquestion

    Statement:  You are given n number of bulbs. They are all switched off. A weird fluctuation in voltage hits the circuit n times.
    In the 1st fluctuation all bulbs are toggled, in the 2nd fluctuation every 2nd bulb is toggled, in the 3rd fluctuation every
    3rd bulb is toggled and so on. You've to find which bulbs will be switched on after n fluctuations.
*/

public class BenjaminBulbs {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=1; i*i<=n; i++)
        {
            System.out.println(i*i);
        }

    }
}
