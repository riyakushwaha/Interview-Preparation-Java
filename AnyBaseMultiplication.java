import java.util.Scanner;

public class AnyBaseMultiplication {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2){
        // write your code here
        int res =0;
        int p =1;
        int digit=0;

        while(n2>0)
        {
            digit = n2%10;
            int singleProd = getSingleDigitMultiplication(b, n1, digit);

            res = getSum(b, res, singleProd*p);
            p = p*10;
            n2 = n2/10;
        }

       return res;
    }

    public static int getSingleDigitMultiplication(int b , int n1, int d)
    {   int digit, carry, res;
        digit = carry = res =0;
        int p =1;
        while (n1>0 ||carry>0)
        {
            digit = n1%10;
            int mul = digit*d +carry;
            carry = mul/b;
            res += mul%b *p;
            p = p*10;
            n1 = n1/10;
        }
        System.out.println("singleprod: "+res);
        return res;
    }

    public static int getSum(int b, int n1, int n2){
        // write ur code here
        int carry, res, sum;
        carry = res = sum=0;
        int p =1;

        while(n1!=0 || n2!=0 || carry>0)
        {
            sum = n1%10 + n2%10 + carry;
            carry = sum/b;
            sum=sum%b;
            res += sum* p;
            p = p*10;
            n1= n1/10;
            n2= n2/10;
        }

        System.out.println("sum: "+res);
        return res;
    }
}
