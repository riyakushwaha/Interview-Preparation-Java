//Subtract n1 from n2. Both numbers have base b.

import java.util.Scanner;

public class AnyBaseSubtraction {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int d = getDifference(b, n1, n2);
        System.out.println(d);
    }

    public static int getDifference(int b, int n1, int n2){
        // write your code here
        int carry, a, res, sub;
        carry = a = res = sub=0;

        while(n2/10!=0 || n1!=0)
        {
            System.out.println("n1 now: "+n1%10);
            System.out.println("n2 now: "+n2%10);
            if(n2%10+carry<n1%10)
            {

                sub = n2%10+ b - n1%10+carry;
                carry =-1;
            }
            else
            {
                sub = n2%10 - n1%10+carry;
                carry =0;
            }

            System.out.println("sub: "+sub);
            res += sub* Math.pow(10,a++);
            n1= n1/10;
            n2= n2/10;
            System.out.println("res: "+res);
        }

        if(n2%10 +carry>0)
        {
            res += (n2%10 +carry)* Math.pow(10,a++);
        }


        return res;
    }

}
