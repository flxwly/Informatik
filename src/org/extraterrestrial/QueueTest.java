package org.extraterrestrial;

import org.extraterrestrial.adt.Queue;

public class QueueTest {
    public static void main(String[] args) {

        Queue q = new Queue();

        for (int i = 0; i < 20; i++) {
            q.enqueue(Math.sin(i));
        }

        System.out.println(q);

        System.out.println(length(q));
        System.out.println(length(q));

    }

    public static int length(Queue q) {
        Queue h = new Queue();
        int length = 0;
        while(!q.isEmpty()) {
            h.enqueue(q.dequeue());
            length += 1;
        }
        while (!h.isEmpty()) {
            q.enqueue(h.dequeue());
        }
        return length;
    }
}
