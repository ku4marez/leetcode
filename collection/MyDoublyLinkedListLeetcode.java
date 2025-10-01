package collection;

public class MyDoublyLinkedListLeetcode {

    private Node head;
    private Node tail;
    private int size = 0;

    public MyDoublyLinkedListLeetcode() {}

    public static class Node {
        int value;
        Node next, prev;

        public Node() {}
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node pointer;
        if (index < size / 2) {
            pointer = head;
            for (int i = 0; i < index; i++) pointer = pointer.next;
        } else {
            pointer = tail;
            for (int i = size - 1; i > index; i--) pointer = pointer.prev;
        }
        return pointer.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node pointer;
        if (index < size / 2) {
            pointer = head;
            for (int i = 0; i < index; i++) pointer = pointer.next;
        } else {
            pointer = tail;
            for (int i = size - 1; i > index; i--) pointer = pointer.prev;
        }

        Node node = new Node(val);
        node.prev = pointer.prev;
        node.next = pointer;
        pointer.prev.next = node;
        pointer.prev = node;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        Node pointer;
        if (index < size / 2) {
            pointer = head;
            for (int i = 0; i < index; i++) pointer = pointer.next;
        } else {
            pointer = tail;
            for (int i = size - 1; i > index; i--) pointer = pointer.prev;
        }

        remove(pointer);
    }

    private void remove(Node node) {
        if (node == null || isEmpty()) return;

        if (node.prev == null) {
            removeFirst();
            return;
        }
        if (node.next == null) {
            removeLast();
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
        size--;
    }

    private void removeFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    private void removeLast() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
