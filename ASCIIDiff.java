import java.util.Scanner;

/*
    Name: String With Difference Of Every Two Consecutive Characters
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/string-with-difference-of-every-two-consecutive-characters-official/ojquestion

    Statement: You have to form a string that contains the difference of ASCII values of every two consecutive characters between those characters.
    For "abecd", the answer should be "a1b3e-2c1d"
*/

public class ASCIIDiff {
    public static String solution(String str){
        // write your code here
        StringBuilder sb = new StringBuilder("");
        sb.append(str.charAt(0));

        for(int i =1; i<str.length(); i++)
        {
            int a = str.charAt(i) - str.charAt(i-1);
            sb.append(a);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
