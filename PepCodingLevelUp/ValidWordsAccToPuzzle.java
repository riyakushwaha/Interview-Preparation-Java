import java.util.*;

public class ValidWordsAccToPuzzle {

    public static ArrayList < Integer > findNumOfValidWords(String[] words, String[] puzzles) {
        //write your code here
        ArrayList<Integer> sol = new ArrayList<>();
        HashMap<Character, ArrayList<Integer>> hmap = new HashMap<>();
        for(int i = 0; i< 26; i++){
            hmap.put((char)('a' + i), new ArrayList<>());
        }

        for(String word: words){
            int mask = 0;
            //Preparing BitMask for Word
            for(char ch: word.toCharArray()){
                int bit =  ch - 'a';
                mask = (mask | (1<<bit) );
            }
            //Adding bitmask to each list of alphabet contained in word.
            HashSet<Character> set = new HashSet<>();
            for(char ch: word.toCharArray()){
                if(set.contains(ch)){
                    continue;
                }
                set.add(ch);
                hmap.get(ch).add(mask);
            }
        }

        for(String puzzle: puzzles){
            int mask = 0;
            //Preparing BitMask for Puzzles
            for(char ch: puzzle.toCharArray()){
                int bit =  ch - 'a';
                mask = (mask | (1<<bit) );
            }
            int count = 0;
            char fch = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = hmap.get(fch);
            for(int word : wordsToCheck){
                if((word & mask) == word){
                    count++;
                }
            }

            sol.add(count);
        }

        return sol;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0; i < m; i++) {
            puzzles[i] = scn.next();
        }
        ArrayList < Integer > ans = findNumOfValidWords(words, puzzles);
        for (int i = 0; i<ans.size(); i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }

}