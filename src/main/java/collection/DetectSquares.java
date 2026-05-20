package collection;

import java.util.*;

public class DetectSquares {
    private final Map<Integer, Map<Integer, Integer>> points = new HashMap<>();

    public void add(int[] p) {
        int x = p[0], y = p[1];
        points.computeIfAbsent(x, k -> new HashMap<>())
                .merge(y, 1, Integer::sum);
    }

    public int count(int[] p) {
        int x = p[0], y = p[1];
        if (!points.containsKey(x)) return 0;
        int res = 0;

        // iterate over all possible y2 that share the same x
        for (int y2 : points.get(x).keySet()) {
            if (y2 == y) continue;
            int side = y2 - y; // vertical side length

            // check both horizontal directions
            res += points.getOrDefault(x + side, Collections.emptyMap())
                    .getOrDefault(y, 0)
                    * points.getOrDefault(x + side, Collections.emptyMap())
                    .getOrDefault(y2, 0)
                    * points.get(x).get(y2);

            res += points.getOrDefault(x - side, Collections.emptyMap())
                    .getOrDefault(y, 0)
                    * points.getOrDefault(x - side, Collections.emptyMap())
                    .getOrDefault(y2, 0)
                    * points.get(x).get(y2);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */