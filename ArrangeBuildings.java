/*
    Name: Arrange Buildings (Dynamic Programming)
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/arrange-buildings-official/ojquestion
    Statement: You are given a number n, which represents the length of a road. The road has n plots on it's each side. The road is to be so planned
    that there should not be consecutive buildings on either side of the road. You are required to find and print the number of ways in which the
    buildings can be built on both side of roads.
 */
import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int building = 1;
        int space = 1;
        int newBuilding, newSpace;

        for(int i=2; i<=n; i++)
        {
            newBuilding = space;
            newSpace = building + space;

            building = newBuilding;
            space = newSpace;
        }
        long res = space+building;
        System.out.println("res: "+(res*res));
    }
}
