package pt.pa.test;

import org.junit.jupiter.api.Test;
import pt.pa.adts.FullQueueException;
import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {

    @Test
    void enqueue() {
        Queue<Integer> queue = new QueueLinkedList<>();
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    void dequeue() {
        Queue<Integer> queue = new QueueLinkedList<>();
        try {
            for (int i = 0; i < 15; i++) {
                queue.enqueue(i);
            }
            while (queue.size() != 0) {
                System.out.println(queue.dequeue());
            }
        } catch(FullQueueException e) {
            throw new AssertionError(e.getMessage());
        }
        //assertTrue(queue.isEmpty());
    }

    @Test
    void front() {
        Queue<Integer> queue = new QueueLinkedList<>();
        for (int i=0; i<15; i++) {
            queue.enqueue(i);
        }
        assertSame(queue.front(), 0);
    }

    /*@Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }*/
}