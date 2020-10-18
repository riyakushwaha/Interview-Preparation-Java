import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
    Name: Get KeyPad Combination (Using Recursion)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-kpc-official/ojquestion
    Statement: WAP to get the list of all words that could be produced by the keys in str.
*/
public class KeypadCombination {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        ArrayList<String> res = getKPC(str);
        System.out.println(res);
    }

    public static ArrayList<String> getKPC(String str) {

        ArrayList<String> keypad = new ArrayList<>();
        if(str.length()==0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }


        String [] items = new String[]{".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        keypad.addAll(Arrays.asList(items));

        char ch = str.charAt(0);
        String  rest = str.substring(1);

        ArrayList<String> list = getKPC(rest);

        ArrayList<String> result = new ArrayList<>();
        String letter = keypad.get(ch-'0');


        for(int i =0; i<letter.length(); i++)
        {
            for( String res: list)
            {
                result.add(letter.charAt(i)+res);
            }
        }

        return result;
    }
}
