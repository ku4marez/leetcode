package collection;

import java.util.HashMap;
import java.util.LinkedList;

public class MyLRUCache {
    HashMap<Integer, Integer> map;
    LinkedList<Integer> usage;
    int capacity;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        usage = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        usage.remove((Integer) key);
        usage.addFirst(key);

        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            usage.remove((Integer) key);
        } else if (map.size() == capacity) {
            int lru = usage.removeLast();
            map.remove(lru);
        }

        map.put(key, value);
        usage.addFirst(key);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
