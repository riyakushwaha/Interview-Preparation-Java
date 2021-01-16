/*
    Name: Get KeyPad Combination (Using Recursion - Second Method - Optimized)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-kpc-official/ojquestion
    Statement: WAP to get the list of all words that could be produced by the keys in str.
*/
import java.util.Scanner;

public class KeypadCombinationII {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printKPC(str, "");
    }

    static String [] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printKPC(String str, String ans) {

        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);
        String keypad = codes[ch - '0'];
        for(int i =0; i<keypad.length(); i++)
        {
            printKPC(rest, ans+keypad.charAt(i));
        }
    }
}
