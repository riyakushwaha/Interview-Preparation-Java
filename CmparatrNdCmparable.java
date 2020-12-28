import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CmparatrNdCmparable {

    public static class Student implements Comparable<Student>
    {
        int rollNo;
        int height;
        int weight;

        Student(int rollNo, int height, int weight)
        {
            this.height = height;
            this.rollNo = rollNo;
            this.weight = weight;
        }

        //Returns increasing order. For decreasing order, write --> { return other.rollNo - this.rollNo }
        public int compareTo(Student other)
        {
            return this.rollNo - other.rollNo;
        }

        public String toString()
        {
            String str = "RollNo: " + this.rollNo + " Height: " + this.height + " Weight: " + this.weight;
            return str;
        }
    }

    public static class StudentHtComparator implements Comparator<Student>
    {
        public int compare(Student s1, Student s2)
        {
            return s1.height - s2. height;
        }
    }

    public static class StudentWtComparator implements Comparator<Student>
    {
        public int compare(Student s1, Student s2)
        {
            return s1.weight - s2. weight;
        }
    }

    public static void main(String [] args)
    {
        System.out.println("Increasing order of Roll Number");
        PriorityQueue<Student> pqrno = new PriorityQueue<>();
        pqrno.add(new Student(2, 135, 87));
        pqrno.add(new Student(12, 125, 97));
        pqrno.add(new Student(5, 205, 77));
        pqrno.add(new Student(1, 155, 58));
        while (!pqrno.isEmpty())
        {
            System.out.println(pqrno.remove());
        }
        System.out.println();

        System.out.println("Increasing order of Height");
        PriorityQueue<Student> pqht = new PriorityQueue<>(new StudentHtComparator());
        pqht.add(new Student(2, 135, 87));
        pqht.add(new Student(12, 125, 97));
        pqht.add(new Student(5, 205, 77));
        pqht.add(new Student(1, 155, 58));
        while (!pqht.isEmpty())
        {
            System.out.println(pqht.remove());
        }
        System.out.println();

        System.out.println("Increasing order of Weight");
        PriorityQueue<Student> pqwt = new PriorityQueue<>(new StudentWtComparator());
        pqwt.add(new Student(2, 135, 87));
        pqwt.add(new Student(12, 125, 97));
        pqwt.add(new Student(5, 205, 77));
        pqwt.add(new Student(1, 155, 58));
        while (!pqwt.isEmpty())
        {
            System.out.println(pqwt.remove());
        }
        System.out.println();
    }
}
