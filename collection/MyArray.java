package collection;

import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class MyArray<T> implements Iterable<T> {
    private T[] array;
    // real size
    private int size = 0;
    // capacity
    private int capacity = 0;

    public MyArray() {
        this(16);
    }

    public MyArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("capacity cannot be negative");
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void add(T t) {
        if (size + 1 >= capacity) {
            if (capacity == 0) capacity++;
            else capacity *= 2;
            T[] newArr = (T[]) new Object[capacity];
            if (size >= 0) System.arraycopy(array, 0, newArr, 0, size);
            this.array = newArr;
        }
        this.array[size++] = t;

    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T t) {
        array[index] = t;
    }

    public T remove(T t) {
        T toRemove = null;
        int index = indexOf(t);
        if (index != -1) {
            toRemove = this.array[index];
            T[] newArr = (T[]) new Object[capacity];
            System.arraycopy(array, 0, newArr, 0, index);
            if (size - index >= 0) System.arraycopy(this.array, index + 1, newArr, index, size - index);
            this.array = newArr;
            this.size--;
        }
        return toRemove;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return remove(array[index]);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        this.size = 0;
    }

    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            T element = this.array[i];
            if (element.equals(t)) return i;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[index++];
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
