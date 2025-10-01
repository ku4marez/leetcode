package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class MySinglyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size = 0;

    public MySinglyLinkedList(Node<T> head, int size) {
        this.head = head;
        this.size = size;
    }

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node() {

        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> pointer = this.head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node<>(element);
        }
        size++;
    }

    public void addLast(T element) {
        this.add(element);
    }

    public void addFirst(T element) {
        Node<T> node = new Node<>(element);
        node.next = this.head;
        this.head = node;
        size++;
    }

    public T peekFirst() {
        return this.head != null ? this.head.value : null;
    }

    public T removeFirst() {
        if (this.head == null) return null;
        if (this.head.next == null) {
            Node<T> prev = this.head;
            head = null;
            size--;
            return prev.value;
        }
        Node<T> prev = this.head;
        head = this.head.next;
        size--;
        return prev.value;
    }

    public T remove() {
        if (this.head == null) return null;
        if (this.head.next == null) {
            Node<T> prev = this.head;
            head = null;
            size--;
            return prev.value;
        }
        Node<T> curr = this.head;
        Node<T> prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        this.size--;
        return curr.value;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        if (head == null) return null;
        Node<T> curr = this.head;
        Node<T> prev = null;
        int i = 0;
        while (curr != null && i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        prev.next = curr.next;
        this.size--;
        return curr.value;
    }

    public int indexOf(T value) {
        Node<T> pointer = this.head;
        int index = 0;
        while (pointer != null) {
            if (pointer.value.equals(value)) {
                return index;
            }
            pointer = pointer.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T element) {
        Node<T> pointer = this.head;
        while (pointer != null) {
            if (pointer.value.equals(element)) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> pointer = head;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T val = pointer.value;
                pointer = pointer.next;
                return val;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
