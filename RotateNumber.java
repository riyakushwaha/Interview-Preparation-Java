import java.util.*;
/*
    Name: Rotate A Number
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/getting-started/rotate-a-number-official/ojquestion
    Statement: You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive,
    rotate to the right i.e. remove rightmost digit and make it leftmost. Do the reverse for negative value of k. Also
    k can have an absolute value larger than number of digits in n.
*/
public class RotateNumber {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();

        int temp =num;
        int length=0;

        while(temp!=0)
        {
            length++;
            temp= temp/10;
        }

        if(Math.abs(k)>length)
        {
            k = k%length;
        }

        if(k<0)
        {
            k = length +k;
        }

        int div =(int) Math.pow(10, k);
        int n = num%div;
        num = num/div;
        num = n*(int) Math.pow(10, length-k) +num;

        temp =num;
        int l2=0;

        while(temp!=0)
        {
            l2++;
            temp= temp/10;
        }
        while(length-l2>0)
        {
            System.out.print("0");
            l2++;
        }
        System.out.print(num);



    }
}

