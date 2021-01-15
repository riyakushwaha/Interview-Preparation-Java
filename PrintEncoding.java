/*
    Name: Print Encodings (Using Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-encodings-official/ojquestion
 */

import java.util.Scanner;
public class PrintEncoding {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printEncodings(str, ""); // 123 -> abc, aw, lc
    }

    public static void printEncodings(String str, String ans) {

        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
       if(str.charAt(0)=='0')
        {
            return;
        }

        int val1 =  str.charAt(0) + 48;
        String rest1 = str.substring(1);
        printEncodings(rest1 , ans+ (char)val1);

        if(str.length()>1)
        {
            if(Integer.parseInt(str.substring(0,2))<27)
            {
                int val2 = Integer.parseInt(str.substring(0,2)) + 96;
                String rest2 = str.substring(2);
                printEncodings(rest2 , ans+ (char)val2);
            }

        }
    }
}
