package interview.preparation;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // ===============================================
        // DAY 1 - Strings, Arrays, Hashing input/output tests
        // ===============================================
        int[] nums1 = {1, 1, 2, 2, 3};
        System.out.println(Day1.removeDuplicates(nums1));

        String s1 = "abcabcbb";
        System.out.println("Length of longest substring: " + Day1.lengthOfLongestSubstring(s1));

        String s2 = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome: " + Day1.isPalindrome(s2));

        int[] nums2 = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max subarray of size k: " + Day1.maxSumSubarrayOfSizeK(nums2, k));

        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Two sum: " + Day1.twoSum(numbers, target));

        // ===============================================
        // DAY 2 - Stack, Heap, Sliding Window input/output tests
        // ===============================================
        int[] nums3 = {15, 7, 11, 15};
        System.out.println(Arrays.toString(nums2) + " Contains duplicates: " + Day2.containsDuplicate(nums3));

        String brackets = "({[]})";
        System.out.println("Is valid parentheses: " + Day2.isValid(brackets));

        Day2.LRUCache cache = new Day2.LRUCache(2);
        cache.put(1, 1);             // cache: [1]
        cache.put(2, 2);             // cache: [2,1]
        System.out.println("Get 1: " + cache.get(1)); // returns 1
        cache.put(3, 3);             // evicts key 2
        System.out.println("Get 2 (should be -1): " + cache.get(2)); // returns -1

        int[] freqInput = {1, 1, 1, 2, 2, 3};
        int kFreq = 2;
        System.out.println("Top K frequent: " + Arrays.toString(Day2.topKFrequent(freqInput, kFreq)));

        int[] slidingInput = {1, 3, -1, -3, 5, 3, 6, 7};
        int kWindow = 3;
        System.out.println("Sliding window max: " + Arrays.toString(Day2.maxSlidingWindow(slidingInput, kWindow)));

        // ===============================================
        // DAY 3 - Recursion, DFS, BFS input/output tests
        // ===============================================

        int[] numsPerm = {1, 2, 3};
        System.out.println("Permutations of " + Arrays.toString(numsPerm) + ":");
        List<List<Integer>> perms = Day3.permute(numsPerm);
        perms.forEach(System.out::println);

        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Word Ladder length: " + Day3.ladderLength(begin, end, wordList));

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        System.out.println("Flood Fill Result:");
        int[][] filled = Day3.floodFill(image, sr, sc, newColor);
        for (int[] row : filled) {
            System.out.println(Arrays.toString(row));
        }

        int nParentheses = 3;
        System.out.println("Generated Parentheses for n = " + nParentheses + ": " + Day3.generateParenthesis(nParentheses));

        Day3.Node node1 = new Day3.Node(1);
        Day3.Node node2 = new Day3.Node(2);
        Day3.Node node3 = new Day3.Node(3);
        Day3.Node node4 = new Day3.Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        Day3.Node cloned = Day3.cloneGraph(node1);
        System.out.println("Cloned graph root value: " + cloned.val);


        // ===============================================
        // DAY 4 - Sorting and Binary Search input/output tests
        // ===============================================

        int[] numsMerge = {5, 2, 3, 1};
        System.out.println("Merge Sort of " + Arrays.toString(numsMerge) + ":");
        Day4.mergeSort(numsMerge);
        System.out.println(Arrays.toString(numsMerge));

        int[] numsQuick = {5, 3, 8, 4, 2, 7, 1, 10};
        System.out.println("Quick Sort of " + Arrays.toString(numsQuick) + ":");
        Day4.quickSort(numsQuick);
        System.out.println(Arrays.toString(numsQuick));

        int[] searchArray = {1, 3, 5, 7, 9};
        int target2 = 1;
        System.out.println("Binary Search for " + target2 + " in " + Arrays.toString(searchArray) + ": " +
                Day4.binarySearch(searchArray, target2));

        int[] insertArray = {1, 3, 5, 6};
        int insertTarget = 2;
        System.out.println("Search Insert Position for " + insertTarget + " in " + Arrays.toString(insertArray) + ": " +
                Day4.searchInsert(insertArray, insertTarget));

        // Assume isBadVersion is mocked externally
        System.out.println("First Bad Version in range 1 to 5 (bad = 4): " + Day4.firstBadVersion(5));

        // ===============================================
        // DAY 5 - Prefix Sum and Sliding Window input/output tests
        // ===============================================

        int[] numsRangeSum = {1, 2, 3, 4};
        int[][] rangeQueries = {{1, 3}, {0, 2}};
        System.out.println("Range Sum Queries on " + Arrays.toString(numsRangeSum) + ": " +
                Arrays.toString(Day5.rangeSum(numsRangeSum, rangeQueries)));

        int[] numsSubarrayK = {1, 2, 1, 3};
        int k2 = 3;
        System.out.println("Number of subarrays with sum " + k + " in " + Arrays.toString(numsSubarrayK) + ": " +
                Day5.subarraySumEqualsK(numsSubarrayK, k2));

        int[] maxSumArray = {2, 1, 5, 1, 3, 2};
        int windowSize = 3;
        System.out.println("Max sum of subarray size " + windowSize + " in " + Arrays.toString(maxSumArray) + ": " +
                Day5.maxSumSubarray(maxSumArray, windowSize));

        String str = "bcdfabcbb";
        System.out.println("Length of longest substring without repeating chars in \"" + str + "\": " +
                Day5.lengthOfLongestSubstring(str));

        int[] binaryArray = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println("Number of binary subarrays with sum " + goal + " in " + Arrays.toString(binaryArray) + ": " +
                Day5.numSubarraysWithSum(binaryArray, goal));

        // ===============================================
        // DAY 6 - Intervals and Stack/Queue input/output tests
        // ===============================================

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merged intervals: " + Arrays.deepToString(Day6.merge(intervals1)));

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println("After inserting new interval: " + Arrays.deepToString(Day6.insert(intervals2, newInterval)));

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Days until warmer temperature: " + Arrays.toString(Day6.dailyTemperatures(temperatures)));

        String validBrackets = "({[]})";
        System.out.println("Is \"" + validBrackets + "\" valid? " + Day6.isValid(validBrackets));

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int window = 3;
        System.out.println("Sliding window max in " + Arrays.toString(nums) + ": " +
                Arrays.toString(Day6.maxSlidingWindow(nums, window)));

        // ===============================================
        // DAY 7 - Recursion and System Design Input Tests
        // ===============================================

        int[] permInput = {1, 2, 3};
        System.out.println("Permutations: " + Day7.permute(permInput));

        int[] subsetInput = {1, 2, 3};
        System.out.println("Subsets: " + Day7.subsets(subsetInput));

        int a = 5, b = 3;
        System.out.println("Multiply " + a + " * " + b + " = " + Day7.multiply(a, b));

        String s = "applepenapple";
        List<String> dict = Arrays.asList("apple", "pen");
        System.out.println("Can word \"" + s + "\" be broken using dict? " + Day7.wordBreak(s, dict));

        int[] candidates = {2, 3, 6, 7};
        int target3 = 7;
        System.out.println("Combination sum for target " + target + ": " + Day7.combinationSum(candidates, target3));


        // ===============================================
        // DAY 8 - Trees and Recursion Input Tests
        // ===============================================

        Day8.TreeNode root1 = Day8.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("Max Depth: " + Day8.maxDepth(root1));

        Day8.TreeNode root2 = Day8.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        int targetSum = 22;
        System.out.println("Has Path Sum = " + targetSum + "? " + Day8.hasPathSum(root2, targetSum));

        Day8.TreeNode root3 = Day8.buildTree(new Integer[]{1, null, 2, 3});
        System.out.println("Inorder Traversal: " + Day8.inorderTraversal(root3));

        Day8.TreeNode root4 = Day8.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Day8.TreeNode p = Day8.find(root4, 5);  // assuming find returns node with given value
        Day8.TreeNode q = Day8.find(root4, 1);
        System.out.println("Lowest Common Ancestor of 5 and 1: " + Day8.lowestCommonAncestor(root4, p, q).val);

        Day8.TreeNode root5 = Day8.buildTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        String serialized = Day8.serialize(root5);
        System.out.println("Serialized Tree: " + serialized);
        Day8.TreeNode deserialized = Day8.deserialize(serialized);
        System.out.println("Deserialized Tree Root: " + deserialized.val);

        // ===============================================
        // DAY 9 - Graphs and Heaps Input Tests
        // ===============================================

        System.out.println("Is graph bipartite? " + Day9.isBipartite(new int[][]{
                {1, 3}, {0, 2}, {1, 3}, {0, 2}
        }));

        System.out.println("Dijkstra shortest paths: " + Day9.dijkstra(5, new int[][]{
                {0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 4, 3}, {3, 4, 1}
        }, 0));

        System.out.println("Top K frequent: " + Day9.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

        System.out.println("Kth largest in stream:");
        Day9.KthLargest kth = new Day9.KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));  // 4
        System.out.println(kth.add(5));  // 5
        System.out.println(kth.add(10)); // 5
        System.out.println(kth.add(9));  // 8
        System.out.println(kth.add(4));  // 8

        System.out.println("Course Schedule Possible? " + Day9.canFinish(4, new int[][]{
                {1, 0}, {2, 1}, {3, 2}
        }));


        // ===============================================
        // DAY 10 - Greedy, DFS/BFS, and Graph Problems
        // ===============================================

        System.out.println("Can attend all meetings? " + Day10.canAttendMeetings(new int[][]{
                {0, 30}, {5, 10}, {15, 20}
        }));

        System.out.println("Reconstruct itinerary: " + Day10.findItinerary(List.of(
                List.of("JFK", "SFO"),
                List.of("JFK", "ATL"),
                List.of("SFO", "ATL"),
                List.of("ATL", "JFK"),
                List.of("ATL", "SFO")
        )));

        System.out.println("Pacific Atlantic water flow: " + Day10.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));

        System.out.println("Minimum jumps to reach end: " + Day10.jump(new int[]{2, 3, 1, 1, 4}));

        System.out.println("Accounts merge: " + Day10.accountsMerge(List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        )));

        // ===============================================
        // DAY 11 - Backtracking and Permutations
        // ===============================================

        System.out.println("Generate all subsets: " + Day11.subsets(new int[]{1, 2, 3}));

        System.out.println("Permutations of list: " + Day11.permute(List.of(1, 2, 3)));

        System.out.println("Word search exists in grid? " + Day11.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));

        System.out.println("Solve N-Queens (N=4): " + Day11.solveNQueens(4));

        System.out.println("Restore valid IP addresses: " + Day11.restoreIpAddresses("25525511135"));

        // ===============================================
        // DAY 12 - Union-Find, Sliding Window
        // ===============================================

        System.out.println("Number of connected components: " + Day12.hasCycle(5, new int[][]{
                {0, 1}, {1, 2}, {3, 4}
        }));

        System.out.println("Longest substring without repeating characters: " + Day12.lengthOfLongestSubstring("abcabcbb"));

        System.out.println("Max sliding window (k=3): " + Arrays.toString(Day12.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

        System.out.println("Minimum window substring: " + Day12.minWindow("ADOBECODEBANC", "ABC"));

        System.out.println("Find circle number (friend circles): " + Day12.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));

        // ===============================================
        // DAY 13 - DP: Knapsack, Subsets
        // ===============================================

        System.out.println("0/1 Knapsack max value: " + Day13.knapsack(
                new int[]{1, 3, 4, 5}, // weights
                new int[]{1, 4, 5, 7}, // values
                7                    // capacity
        ));

        System.out.println("Can partition to equal subset sum: " + Day13.canPartition(
                new int[]{1, 5, 11, 5}
        ));

        System.out.println("Count of subsets with sum: " + Day13.countSubsetsWithSum(
                new int[]{1, 2, 3, 3},
                6
        ));

        System.out.println("Target sum ways: " + Day13.findTargetSumWays(
                new int[]{1, 1, 1, 1, 1},
                3
        ));

        System.out.println("Coin change (min coins to make amount): " + Day13.coinChange(
                new int[]{1, 2, 5},
                11
        ));

        // ===============================================
        // DAY 14 - Graphs, Backtracking, Heaps, Matrix, DP
        // ===============================================
        System.out.println("Number of islands: " + Day14.numIslands(
                new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }
        ));

        System.out.println("All permutations: " + Day14.permute(
                new int[]{1, 2, 3}
        ));

        System.out.println("Top K frequent elements: " + Day14.topKFrequent(
                new int[]{1, 1, 1, 2, 2, 3},
                2
        ));

        System.out.println("Minimum path sum in matrix: " + Day14.minPathSum(
                new int[][]{
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                }
        ));

        System.out.println("Word search exists: " + Day14.exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                },
                "ABCCED"
        ));
    }
}