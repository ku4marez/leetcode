package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class MyDoublyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public MyDoublyLinkedList(Node<T> head, Node<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public static class Node<T> {
        T value;
        Node<T> next, prev;

        public Node() {

        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public void clear() {
        Node<T> pointer = head;
        while (pointer != null) {
            Node<T> next = pointer.next;
            pointer.prev = null;
            pointer.next = null;
            pointer.value = null;
            pointer = next;
        }
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        this.addLast(element);
    }

    public void addAtIndex(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        int i = 0;
        Node<T> pointer;

        if (index < size / 2) {
            pointer = this.head;
            while (i < index) {
                pointer = pointer.next;
                i++;
            }
        } else {
            pointer = this.tail;
            i = size - 1;
            while (i > index) {
                pointer = pointer.prev;
                i--;
            }
        }

        Node<T> node = new Node<>(value);
        node.prev = pointer.prev;
        node.next = pointer;

        if (pointer.prev != null) {
            pointer.prev.next = node;
        }
        pointer.prev = node;
        size++;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
            tail = head;
        } else {
            Node<T> node = new Node<>(element);
            node.prev = tail;
            this.tail.next = node;
            this.tail = node;
        }
        size++;
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
            tail = head;
        } else {
            Node<T> node = new Node<>(element);
            node.next = this.head;
            this.head = node;
        }
        size++;
    }

    public T peekFirst() {
        return this.head != null ? this.head.value : null;
    }

    public T peekLast() {
        return this.tail != null ? this.tail.value : null;
    }

    public T removeFirst() {
        if (this.head == null) return null;
        T value = this.head.value;
        this.head = this.head.next;
        size--;
        if (isEmpty()) tail = null;
        else this.head.prev = null;
        return value;
    }

    public T remove() {
        return this.removeLast();
    }

    public T remove(Node<T> node) {
        if (isEmpty()) return null;
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T value = node.value;

        node.value = null;
        node.next = null;
        node.prev = null;
        size--;
        return value;
    }

    public T removeLast() {
        if (this.tail == null) return null;
        T value = this.tail.value;
        this.tail = this.tail.prev;
        size--;
        if (isEmpty()) {
            tail = null;
            head = null;
        } else this.tail.next = null;
        return value;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();

        int i = 0;
        Node<T> pointer;

        if (index < size / 2) {
            pointer = this.head;
            while (i < index) {
                pointer = pointer.next;
                i++;
            }
        } else {
            pointer = this.tail;
            i = size - 1;
            while (i > index) {
                pointer = pointer.prev;
                i--;
            }
        }
        return remove(pointer);
    }

    public int indexOf(T value) {
        int index = 0;
        Node<T> pointer = this.head;

        if (value == null) {
            while (pointer != null) {
                if (pointer.value == null) {
                    return index;
                }
                pointer = pointer.next;
                index++;
            }
        } else {
            while (pointer != null) {
                if (value.equals(pointer.value)) {
                    return index;
                }
                pointer = pointer.next;
                index++;
            }
        }
        return -1;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        int i = 0;
        Node<T> pointer;

        if (index < size / 2) {
            pointer = this.head;
            while (i < index) {
                pointer = pointer.next;
                i++;
            }
        } else {
            pointer = this.tail;
            i = size - 1;
            while (i > index) {
                pointer = pointer.prev;
                i--;
            }
        }
        return (int) pointer.value;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> pointer = this.head;
        while (pointer != null) {
            sb.append(pointer.value);
            if (pointer.next != null) {
                sb.append(", ");
            }
            pointer = pointer.next;
        }
        sb.append("]");
        return sb.toString();
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
