
import java.util.*;

public class Concepts{

    public static void zig_zag(List<String> words, char[] queries)
    {
        System.out.println();
        Collections.sort(words);
        //Your Code goes here
        String checked;
        for(int j=0; j<queries.length; j++)
        {
            for(int i=0; i<words.size(); i++)
            {
                if(words.get(i).charAt(0)==queries[j])
                {
                    System.out.println(words.get(i));
                    checked = words.remove(i);
                    i--;
                    words.add(checked);
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(s.next());
        }


        s.nextLine();

        String str = s.nextLine();

        String[] arr = str.split(" ");
        char[] queries = new char[arr.length];

        for(int i = 0; i < arr.length; i++) {
            queries[i] = arr[i].charAt(0);
        }

        zig_zag(list, queries);
    }

}