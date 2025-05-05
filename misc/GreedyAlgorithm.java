package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 1. Merge Intervals
        List<int[]> intervals = Arrays.asList(new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18});
        System.out.println("Merged Intervals:");
        for (int[] interval : mergeIntervals(intervals)) {
            System.out.println(Arrays.toString(interval));
        }

        // 2. Jump Game
        int[] jumpArr = {2, 3, 1, 1, 4};
        System.out.println("\\nCan jump to end: " + canJump(jumpArr));

        // 3. Activity Scheduling
        List<int[]> meetings = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 3});
        System.out.println("\\nMax non-overlapping meetings: " + maxMeetings(meetings));
    }

    // Merges overlapping intervals using a greedy strategy
    private static List<int[]> mergeIntervals(List<int[]> intervals) {
        // Step 1: Sort intervals by start time
        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            // Step 2: If result is empty OR current interval does not overlap with the last
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval); // Add as-is
            } else {
                // Step 3: Overlapping — merge by updating the end to the max value
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result;
    }

    // Determines if you can reach the last index from the first using max jumps
    private static boolean canJump(int[] nums) {
        int farthest = 0;

        // Traverse each index within current reachable range
        for (int i = 0; i <= farthest; i++) {
            // Update farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // Early exit: if we can reach or pass the last index
            if (farthest >= nums.length - 1) return true;
        }

        // If we finish the loop and never reach the end
        return false;
    }


    // Returns the maximum number of non-overlapping meetings you can attend
    private static int maxMeetings(List<int[]> meetings) {
        // Step 1: Sort meetings by end time (greedy choice)
        meetings.sort(Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = -1;

        for (int[] meeting : meetings) {
            // Step 2: Only attend this meeting if it starts after or at the end of the last one
            if (meeting[0] >= lastEnd) {
                count++;               // Accept this meeting
                lastEnd = meeting[1];  // Update last end time
            }
        }

        return count;
    }

}
