import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of disks
        int n1 = scanner.nextInt(); // tower1 id
        int n2 = scanner.nextInt(); // tower2 id
        int n3 = scanner.nextInt(); // tower3 id
        toh(n, n1, n2, n3);
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n==0)
        {
            return;
        }
        toh(n-1, t1id, t3id, t2id);
        System.out.println(n+"["+t1id+"->"+t2id+"]");
        toh(n-1, t3id, t2id, t1id);

    }
}
