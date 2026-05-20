package collection;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    public static void push(int x) {
        queue2.add(x);

        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public static int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.poll();
    }

    public static int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    public static boolean empty() {
        return queue1.isEmpty();
    }
}
