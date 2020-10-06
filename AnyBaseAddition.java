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

        return res;
    }
}
