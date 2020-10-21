package pt.pa;

import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new QueueLinkedList<>();

        try {
            for(int i = 0; i < 15; i++) {
                queue.enqueue(i);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            System.out.println("Queue is empty? " + (queue.isEmpty()?"Yes":"No"));

            System.out.println("Front of queue is: " + queue.front());

            System.out.println("Before the 'dequeue' operation, the size of the queue is: " + queue.size());

            System.out.println("Dequeue all elements from queue:");

            while(queue.size() != 0){
                System.out.println(queue.dequeue());
            }

            System.out.println("After the 'dequeue' operation, the size of the queue is: " + queue.size());

            System.out.println("Queue is empty? " + (queue.isEmpty()?"Yes":"No"));

            queue.enqueue(1234);
            queue.enqueue(2345);

            System.out.println("Before clear, is the queue empty? " + (queue.isEmpty()?"Yes":"No"));

            queue.clear();

            System.out.println("After clear, is the queue empty? " + (queue.isEmpty()?"Yes":"No"));

            System.out.println();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
