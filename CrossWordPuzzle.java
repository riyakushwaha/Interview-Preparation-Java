import java.util.Scanner;

public class CrossWordPuzzle {
    public static void solution(char[][] arr, String[] words, int vidx){

        if(vidx == words.length){
            print(arr);
            return;
        }

        String word = words[vidx];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length ; j++){
                if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
                    if(canPlaceHorizontally(arr, word, i, j)){
                        boolean [] selfPlaced = placeWordHorizontally(arr, word, i , j);
                        solution(arr, words, vidx + 1);
                        unPlaceWordHorizontally(arr, selfPlaced, i , j);
                    }

                    if(canPlaceVertically(arr, word, i, j)){
                        boolean [] selfPlaced = placeWordVertically(arr, word, i , j);
                        solution(arr, words, vidx + 1);
                        unPlaceWordVertically(arr, selfPlaced, i , j);
                    }
                }
            }
        }

    }

    public static boolean canPlaceHorizontally(char [][] arr, String word, int i, int j){
        if(j - 1 >= 0 && arr[i][j-1] != '+'){
            return false;
        }
        else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+'){
            return false;
        }

        for(int jj = 0; jj < word.length(); jj++){
            if(j + jj >= arr[0].length || arr[i][j + jj] == '+'){
                return false;
            }
        }

        return true;
    }

    public static boolean [] placeWordHorizontally(char [][] arr, String word, int i, int j){

        boolean [] selfPlaced = new boolean[word.length()];
        for(int jj = 0; jj < word.length(); jj++){
            if(arr[i][j + jj] == '-' ){
                arr[i][j + jj] = word.charAt(jj);
                selfPlaced[jj] = true;
            }
        }

        return selfPlaced;
    }

    public static void unPlaceWordHorizontally(char [][]arr, boolean [] selfPlaced, int i, int j){

        for(int jj = 0; jj < selfPlaced.length; jj++){
            if(selfPlaced[jj]){
                arr[i][j + jj] = '-';
            }
        }
    }

    public static boolean canPlaceVertically(char [][] arr, String word, int i, int j){
        if(i - 1 >= 0 && arr[i -1][j] != '+'){
            return false;
        }
        else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+'){
            return false;
        }

        for(int ii = 0; ii < word.length(); ii++){
            if(i + ii >= arr.length || arr[i + ii][j] == '+'){
                return false;
            }
        }

        return true;
    }

    public static boolean [] placeWordVertically(char [][] arr, String word, int i, int j){

        boolean [] selfPlaced = new boolean[word.length()];
        for(int ii = 0; ii < word.length(); ii++){
            if(arr[i + ii][j] == '-'){
                arr[i + ii][j] = word.charAt(ii);
                selfPlaced[ii] = true;
            }
        }

        return selfPlaced;
    }

    public static void unPlaceWordVertically(char [][]arr, boolean [] selfPlaced, int i, int j){

        for(int ii = 0; ii < selfPlaced.length; ii++){
            if(selfPlaced[ii]){
                arr[i + ii][j] = '-';
            }
        }
    }

    public static void print(char[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr.length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for(int i = 0 ; i < arr.length; i++){
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i = 0 ; i  < words.length; i++){
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}

//        +L++++++++
//        +O++++++++
//        +N++++++++
//        +DELHI++++
//        +O+++C++++
//        +N+++E++++
//        +++++L++++
//        ++ANKARA++
//        +++++N++++
//        +++++D++++

//        +A++++++++
//        +N++++++++
//        +K++++++++
//        +DELHI++++
//        +R+++C++++
//        +A+++E++++
//        +++++L++++
//        ++LONDON++
//        +++++N++++
//        +++++D++++