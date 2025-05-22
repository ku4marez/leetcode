package misc;

import java.util.*;

public class HashMapAlgorithm {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int k = 9;
        System.out.println("Return the indices of two numbers such that they add up to the target: " + twoSum(nums, k));

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Given a list of strings, group the anagrams together: " + groupAnagrams(strs));

        int[] nums1 = {1, 5, 5, 2, 1};
        int k1 = 3;
        System.out.println("Count the number of continuous subarrays that sum to k: " + subArrSumEqualsK(nums1, k1));
    }

    private static int[] twoSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i])) {
                return new int[]{map.get(k - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

//    private static List<String[]> groupAnagrams(String[] strs) {
//        HashMap<String, List<String>> map = new HashMap<>();
//        List<String[]> ans = new ArrayList<>();
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String key = new String(chars);
//            List<String> existingStr = map.get(key);
//            if (existingStr == null) {
//                map.put(key, new ArrayList<>(Collections.singleton(str)));
//            } else {
//                existingStr.add(str);
//            }
//        }
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//            List<String> value = entry.getValue();
//            String[] strings = new String[value.size()];
//            for (int i = 0; i < strings.length; i++) {
//                strings[i] = value.get(i);
//            }
//            ans.add(strings);
//
//        }
//        return ans;
//    }

    // Groups words that are anagrams of each other
        // Returns a list of string arrays, each containing grouped anagrams
    private static List<String[]> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String[]> ans = new ArrayList<>();

        for (String str : strs) {
            // Sort characters of the string to form a key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Use the sorted string as the key to group anagrams
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Convert each group to a String[] and add to the result
        for (List<String> group : map.values()) {
            ans.add(group.toArray(new String[0]));
        }

        return ans;
    }

    private static int subArrSumEqualsK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
