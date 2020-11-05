/*
    Name: Custom Queue
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/normal-queue-official/ojquestion
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomQueue {
    public static class Custom {
        int[] data;
        int front;
        int size;

        public Custom(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for(int i =0; i<size; i++)
            {
                int index = (front + i)% data.length;
                System.out.println(data[index]+" ");
            }
            System.out.println();
        }

        void add(int val) {
            if(size == data.length)
            {
                System.out.println("Queue overflow");
            }
            else
            {
                int rear = (front + size)% data.length;
                size++;
                data[rear] = val;
            }
        }

        int remove() {
            if(size == 0)
            {
                System.out.println("Queue underflow");
                return -1;
            }
            else
            {
                int val = data[front];
                front = (front+1)% data.length;
                size--;
                return val;
            }
        }

        int peek() {
            if(size == 0)
            {
                System.out.println("Queue underflow");
                return -1;
            }
            else
            {
                return data[front];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Custom qu = new Custom(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if(str.startsWith("remove")){
                int val = qu.remove();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")){
                int val = qu.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(qu.size());
            } else if(str.startsWith("display")){
                qu.display();
            }
            str = br.readLine();
        }
    }
}
