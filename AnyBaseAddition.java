import java.util.Scanner;
// 7-64-24- ans- 121
public class AnyBaseAddition {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int d = getSum(b, n1, n2);
        System.out.println("result: "+d);
    }

    public static int getSum(int b, int n1, int n2){
        // write ur code here
        int carry, a, res, sum;
        carry = a = res = sum=0;

        while(n1!=0 || n2!=0)
        {
            sum = n1%10 + n2%10 + carry;
            System.out.println("n1: "+n1);
            System.out.println("n2: "+n2);
            System.out.println("sum: "+sum);
            if(sum>=b)
            {
                carry = 1;
                if(sum==b)
                {
                    sum=0;
                }
                else
                {
                    sum= sum-b;
                }
            }
            else
            {
                carry =0;
            }
            res += sum* Math.pow(10,a++);
            n1= n1/10;
            n2= n2/10;

            System.out.println("n1 now: "+n1);
            System.out.println("n2 now: "+n2);
            System.out.println("sum now: "+sum);
        }

        res += carry* Math.pow(10,a++);

        System.out.println("res: "+res);
        return res;

    }
}
