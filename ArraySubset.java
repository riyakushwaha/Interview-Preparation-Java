import java.util.Scanner;

/*
    Name: Subsets Of Array
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/subsets-of-array-official/ojquestion

    Statement: You are required to print all subsets of arr. Each subset should be
    on separate line. For more clarity check out sample input and output.
*/


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

