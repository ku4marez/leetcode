package collection;

import java.util.*;

public class CustomRandomizedCollection {

    Map<Integer, List<Integer>> map;
    List<Integer> list;
    Random rand;

    public CustomRandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        list.add(val);
        List<Integer> indexes = map.getOrDefault(val, new ArrayList<>());
        indexes.add(list.size() - 1);
        map.put(val, indexes);
        return indexes.size() == 1;
    }

    public boolean remove(int val) {
        List<Integer> indexes = map.get(val);
        if (indexes == null || indexes.isEmpty()) {
            return false;
        }
        int idxToRemove = indexes.removeLast();

        int lastVal = list.getLast();

        list.set(idxToRemove, lastVal);

        int tail = list.size() - 1;
        List<Integer> lastIdxList = map.get(lastVal);
        lastIdxList.remove((Integer) tail);

        if (idxToRemove < list.size() - 1) {
            lastIdxList.add(idxToRemove);
        }

        list.removeLast();

        if (indexes.isEmpty()) map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}