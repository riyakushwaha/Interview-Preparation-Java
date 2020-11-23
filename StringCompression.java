import java.util.Scanner;
/*
    Name: String Compression
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/string-compression-official/ojquestion
*/
public class StringCompression {

    public static String compression1(String str){
        // write your code here
        String res = "";
        res += str.charAt(0);
        for(int i =0; i<str.length(); i++)
        {
            if(str.charAt(i) != res.charAt(res.length()-1))
            {
                res+= str.charAt(i);
            }
        }

        return res;
    }

    public static String compression2(String str){
        // write your code here
        int count =0;
        String res = "";
        res += str.charAt(0);

        for(int i =0; i<str.length(); i++)
        {
            if(str.charAt(i) != res.charAt(res.length()-1))
            {
                if(count>1)
                {
                    res+=count;
                }
                res+= str.charAt(i);
                count = 1;
            }
            else
            {
                count++;
            }
        }

        if(count>1)
        {
            res+=count;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
}
