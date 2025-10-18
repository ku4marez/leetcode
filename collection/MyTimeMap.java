package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTimeMap {
    Map<String, List<Pair>> map;

    public MyTimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        String res = "";
        if (list == null) return res;
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp > timestamp) {
                right = mid - 1;
            } else if (list.get(mid).timestamp <= timestamp) {
                left = mid + 1;
                res = list.get(mid).value;
            }
        }
        return res;
    }

    static class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */