import com.sun.jdi.ByteValue;

import java.util.Scanner;

import static java.lang.Integer.toBinaryString;

public class ArraySubset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] a = new int [n];

        for(int i =0; i<n; i++)
        {
            a[i]= scanner.nextInt();
        }

        int num = (int) Math.pow(2, n);
        int index;
        String str;
        for( int i =0; i<num; i++)
        {
            str="";
            index =i;
            for(int j =n-1; j>=0; j--)
            {
                if(index%2==0)
                {
                    str = "-\t"+str;
                }
                else
                {
                    str= a[j]+"\t"+str;
                }
                index = index/2;

            }
            System.out.println(str);

        }

    }
}


//       for( int i =0; i<num; i++)
//        {
//        index =i;
//        for(int j =n-1; j>=0; j--)
//        {
//        if(index%2==0)
//        {
//        // str = "-\t"+str;
//        System.out.print("-\t");
//        }
//        else
//        {
//        //str= a[j]+str;
//        System.out.print(a[j]+"\t");
//        }
//        index = index/2;
//
//        }
//        System.out.println();
//
//        }