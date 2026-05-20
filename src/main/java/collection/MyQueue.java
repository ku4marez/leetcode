package collection;

import java.util.LinkedList;
import java.util.List;

public class MyQueue {

    static List<Integer> list = new LinkedList<>();

    public static void push(int x) {
        list.addLast(x);
    }

    public static int pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    public static int peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    public static boolean empty() {
        return list.isEmpty();
    }
}
