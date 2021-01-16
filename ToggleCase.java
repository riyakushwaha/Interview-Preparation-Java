import java.util.Scanner;
/*
    Name: Toggle Case
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/toggle-case-official/ojquestion
*/
public class ToggleCase {
    public static String toggleCase(String str){
        //write your code here
        StringBuilder sb = new StringBuilder(str);

        for(int i =0; i<sb.length(); i++)
        {
            int ch =  str.charAt(i);
            //if char is uppercase
            if(ch<91 && ch>64)
            {
                ch+= 32;
            }
            else
            {
               ch-=32;
            }
            sb.setCharAt(i, (char) ch);
        }

        str = sb.toString();
        return str;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}
