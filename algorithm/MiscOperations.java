package algorithm;

import java.util.*;

public class MiscOperations {


    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, -1, 1};
        firstMissingPositive(arr);

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        longestConsecutiveSequence(nums);

        int[] subarr = new int[]{1, 2, 3};
        subarraySum(subarr, 3);

        int[] topK = new int[]{1, 1, 1, 2, 2, 3};
        topKFrequent(topK, 2);

        String[] str = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(str);

        int[] duplicateArr = new int[]{4,3,2,7,8,2,3,1};
        findDuplicates(duplicateArr);

        String longestStr = "abcbde";
        longestUniqueSubstring(longestStr);

        int[] arrProd = new int[]{1, 1, 2, 6};
        productOfArray(arrProd);
    }

    // Use Prefix Sum + HashMap
    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Max heap based on frequency
    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res[i] = entry.getKey();
        }
        return res;
    }

    // Set-Based Linear Scan
    private static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int curr = nums[i];
                int currStreak = 1;
                while (set.contains(curr + 1)) {
                    curr ++;
                    currStreak++;
                }
                max = Math.max(max, currStreak);
            }
        }
        return max;
    }

    // If in place modification is possible
    private static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (
                    nums[i] >= 1 &&
                    nums[i] <= nums.length &&
                    nums[i] != nums[nums[i] - 1]
            ) {
                int correctIndex = nums[i] - 1;

                // Swap nums[i] with nums[correctIndex]
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return 0;
    }

    // Sort char array
    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>(List.of(str)));
            } else {
                map.get(sorted).add(str);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(new ArrayList<>(entry.getValue()));
        }
        return ans;
    }

    // In place array marking
    private static int[] findDuplicates(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res[index] = nums[index];
            } else {
                nums[index] = -nums[index];
            }

        }
        return res;
    }

    // Sliding window + hash map
    public static String longestUniqueSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLen = 0, startOfMax = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (seen.contains(c)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startOfMax = left;
            }
        }

        return s.substring(startOfMax, startOfMax + maxLen);
    }

    // Build prefix and suffix products and combine them.
    private static int[] productOfArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix *= arr[i];
        }
        return res;
    }
}
