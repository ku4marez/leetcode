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

        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(str);

        int[] duplicateArr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        findDuplicates(duplicateArr);

        String longestStr = "abcbde";
        longestUniqueSubstring(longestStr);

        int[] arrProd = new int[]{1, 1, 2, 6};
        productOfArray(arrProd);

        String parenthesis = "(()())";
        System.out.println(longestValidParentheses(parenthesis));

        System.out.println(generateParenthesis(5));

        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        System.out.println(Arrays.toString(merge(intervals)));

        int reverseInt = 123;
        System.out.println(reverse(reverseInt));

        String str1 = "231";
        String str2 = "10";
        System.out.println(multiply(str1, str2));

        System.out.println(missingNumber(new int[]{1, 2, 3, 5}));

        System.out.println(missingNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));

        System.out.println(duplicateNumbers(new int[]{1, 1, 3, 3, 4, 5, 6, 7}));
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
                    curr++;
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

    private static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    private static List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        generateParenthesis(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void generateParenthesis(List<String> res, StringBuilder temp, int open, int close, int n) {
        if (temp.length() == n * 2) {
            res.add(temp.toString());
        }

        if (open < n) {
            temp.append("(");
            generateParenthesis(res, temp, open + 1, close, n);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (close < open) {
            temp.append(")");
            generateParenthesis(res, temp, open, close + 1, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        res.add(curr);
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                curr = next;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int y = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && y > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && y < -8)) return 0;

            rev = rev * 10 + y;
        }
        return rev;
    }

    private static String multiply(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int product = n1 * n2;

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = product + arr[p2];

                arr[p2] = sum % 10;
                arr[p1] += sum / 10;  // carry
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        for (int digit : arr) {
            if (digit == 0 && leadingZero) continue;
            leadingZero = false;
            sb.append(digit);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

    private static int missingNumber(int[] arr) {
        int n = arr.length;
        int actualSum = 0;
        int expectedSum = (n + 1) * (n + 2) / 2;
        for (int val : arr) {
            actualSum += val;
        }
        return expectedSum - actualSum;
    }

    private static int[] missingNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                res.add(i + 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private static int[] duplicateNumbers(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] *= -1;
            } else res.add(index + 1);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
