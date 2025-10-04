package collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CustomRandomSet {
    int[] array;
    int count;
    Map<Integer, Integer> map;
    Random rand;

    public CustomRandomSet() {
        count = 0;
        array = new int[10];
        map = new HashMap<>();
        rand = new Random();
    }

    public void insert(int value) {
        if (map.containsKey(value)) {
            return;
        }

        if (count == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[count] = value;
        map.put(value, count);
        count++;
    }

    public void remove(int value) {
        if (!map.containsKey(value)) {
            return;
        }
        int index = map.get(value);
        map.remove(value);
        map.put(array[count - 1], index);

        int val = array[count - 1];
        array[index] = val;
        array[count - 1] = 0;
        count--;
    }

    public int getRandom() {
        return array[rand.nextInt(count)];
    }
}
