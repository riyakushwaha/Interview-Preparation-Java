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
        int carry, res, sub;
        carry = res = sub=0;
        int p =1;

        while(n2!=0 || n1!=0 || carry>0)
        {
            int num = n2%10 +carry;
            if(num<n1%10)
            {

                sub = num+ b - n1%10;
                carry =-1;
            }
            else
            {
                sub = num - n1%10;
                carry =0;
            }

            res += sub* p;
            p= p*10;
            n1= n1/10;
            n2= n2/10;
        }

        return res;
    }

}
