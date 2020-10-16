import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {

        if(str.length()==1){
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            res.add(str);
            return res;
        }

        char ch = str.charAt(0);
        String tillNow = str.substring(1);

        ArrayList<String> list = gss(tillNow);
        ArrayList<String> result = new ArrayList<>();
        for(String st: list)
        {
            result.add(""+st);
        }
        for(String st: list)
        {
            result.add(ch+st);
        }

        return result;
    }
}
