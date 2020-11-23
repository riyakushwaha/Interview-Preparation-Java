import java.util.Scanner;
/*
    Name: Print all Permutations
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/print-all-permutations-of-a-string-iteratively-official/ojquestion
*/
public class StrPermutationI {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int total = factorial(str.length());
        int temp ;

        for(int i =0; i<total; i++)
        {
            StringBuilder sb = new StringBuilder(str);
            temp =i;

            for( int div = str.length(); div>0; div--)
            {
                int j = temp%div;
                System.out.print(sb.charAt(j));
                sb.deleteCharAt(j);

                temp = temp/div;
            }
            System.out.println();
        }
    }

    public static int factorial(int n)
    {
        int num =1;
        for(int i = 2; i<=n; i++)
        {
            num = num *i;
        }
        return num;
    }
}
