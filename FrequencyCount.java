import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
/*
    Name: Frequency Queries
    Source: HackerRank
    Link: https://www.hackerrank.com/challenges/frequency-queries/problem
*/
public class FrequencyCount {

    // Complete the freqQuery function below.
    static void freqQuery(List<List<Integer>> queries) {

        int l1 = queries.size();
        List<Integer> ans = new ArrayList<Integer>();
        System.out.println("Size: "+l1);

        Hashtable <Integer, Integer> ht1 = new Hashtable<Integer, Integer>();
        Hashtable <Integer, Integer> ht2 = new Hashtable<Integer, Integer>();

        for(int i =0; i<l1; i++)
        {
            int type = queries.get(i).get(0);
            int value = queries.get(i).get(1);
            System.out.println("Type: "+type+" Value: "+value);

            if(type==1)
            {
                int a = ht1.getOrDefault(value, 0)+1;
                ht1.put(value, a);
                ht2.put(a, ht2.getOrDefault(a,0)+1);
                if(a-1>0){ ht2.put(a-1, ht2.get(a-1)-1); }
            }

            else if(type==2)
            {
                if(ht1.containsKey(value) && ht1.get(value)>0 )
                {
                    int b = ht1.get(value);
                    ht2.put(b, ht2.get(b)-1);
                    if(b-1>0)
                    {
                        ht2.put(b-1, ht2.getOrDefault(b-1, 0)+1);
                    }
                    ht1.put(value, b-1);

                }
            }

            else
            {
                int temp = ht2.getOrDefault(value, 0);
                if(temp>0){ ans.add(1); }
                else{ ans.add(0); }
            }
            System.out.println("\n HashTable one");
            ht1.forEach((k,v)->System.out.println("Key: "+k+" value: "+v));
            System.out.println("\n HashTable two");
            ht2.forEach((k,v)->System.out.println("Key: "+k+" value: "+v));

        }


        System.out.println("-----------Answer------------");
        for (int i: ans  ) {
            System.out.println(i);
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = scanner.nextInt();

        List<List<Integer>> queries = new ArrayList<>();
        for(int i=0; i<q ; i++){
            queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList())
            );
        }
        freqQuery(queries);
    }
}
