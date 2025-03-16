package collection;

public class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private static final int SIZE = 1000;
    private final Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE]; // Initialize bucket array
    }

    private int hash(int key) {
        return key % SIZE; // Compute bucket index
    }

    public void add(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key);
        } else {
            Node curr = buckets[index];
            while (true) {
                if (curr.key == key) return; // Prevent duplicate insertion
                if (curr.next == null) break;
                curr = curr.next;
            }
            curr.next = new Node(key); // Append to linked list
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        if (curr == null) return;

        if (curr.key == key) {
            buckets[index] = curr.next; // Remove head node
            return;
        }

        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next; // Unlink node
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return true; // Key found
            curr = curr.next;
        }
        return false; // Key not found
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */