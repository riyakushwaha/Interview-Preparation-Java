import java.util.*;


class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements java.util.Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {

        if(a.score>b.score){
            return -1;
        }
        else if(a.score <b.score){
            return 1;
        }
        else{
            int res = a.name.compareTo(b.name);
            return res;
        }

    }
}


public class Comparator<P> {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        System.out.println("-------------");

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}