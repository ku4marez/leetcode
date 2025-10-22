package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalOperations {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < end) {
                res++;
            } else {
                end = interval[0];
            }
        }
        return res;
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = result.getLast();
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                if (!inserted) {
                    inserted = true;
                    res.add(newInterval);
                }
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        if (!inserted) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
