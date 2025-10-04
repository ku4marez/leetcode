package interview.interview;

import java.util.*;

public class Interview2 {

    public static void main(String[] args) {
        // 1. Count Connected Components (Graph)
        System.out.println("Connected Components:");
        System.out.println(countComponents(5, new int[][]{
                {0, 1}, {1, 2}, {3, 4}
        })); // 2

        // 2. Median from Stream (Heap-like)
        System.out.println("\nMedian from Stream:");
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println("After adding 1 → median = " + mf.findMedian()); // 1.0
        mf.addNum(2);
        System.out.println("After adding 2 → median = " + mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println("After adding 3 → median = " + mf.findMedian()); // 2.0
        mf.addNum(4);
        System.out.println("After adding 4 → median = " + mf.findMedian()); // 2.5
        mf.addNum(5);
        System.out.println("After adding 5 → median = " + mf.findMedian()); // 3.0


        // 3. Daily Temperatures (Stack)
        System.out.println("\nDaily Temperatures:");
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        // [1,1,4,2,1,1,0,0]

        // 4. Sliding Window Maximum (Queue/Deque)
        System.out.println("\nSliding Window Maximum:");
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{10, 3, -1, -3, 5, 3, 6, 7}, 3)));
        // [3,3,5,5,6,7]

        // 5. Generate Parentheses (Recursion)
        System.out.println("\nGenerate Parentheses:");
        System.out.println(generateParenthesis(3)); // ["((()))", "(()())", "(())()", "()(())", "()()()"]

        // Additional
        System.out.println("Top K Frequent:");
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));  // [1, 2]
        System.out.println(topKFrequent(new int[]{1}, 1));            // [1]
        System.out.println(topKFrequent(new int[]{4, 4, 4, 4, 5, 5, 6}, 2)); // [4, 5]

        System.out.println("Dijkstra shortest paths:");
        System.out.println(Arrays.toString(dijkstra(5, new int[][]{
                {0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 4, 3}, {3, 4, 1}
        }, 0))); // [0,2,3,9,6]

        System.out.println(Arrays.toString(dijkstra(3, new int[][]{
                {0, 1, 5}, {1, 2, 2}, {0, 2, 9}
        }, 0))); // [0,5,7]

        int[] quickSort = new int[]{20, 2, 7, 12, 15, 1, 6, 8};
        quickSort(quickSort);
        System.out.println("Quick Sort:" + Arrays.toString(quickSort));

        int[] mergeSort = new int[]{20, 2, 7, 12, 15, 1, 6, 8};
        mergeSort = mergeSort(mergeSort);
        System.out.println("Merge Sort:" + Arrays.toString(mergeSort));

        int[] minHeapSort = new int[]{20, 2, 7, 12, 15, 1, 6, 8};
        minHeapSort = buildMinHeap(minHeapSort);
        System.out.println("Min Heap Sort:" + Arrays.toString(minHeapSort));

        String sortStringCount = "hjksadkjh";
        System.out.println(countingSort(sortStringCount));

        String isAnagramA = "anagram";
        String isAnagramB = "nagaram";
        System.out.println(isAnagram(isAnagramA, isAnagramB));

        String parenthesis = "()(){{}]";
        System.out.println(isValidParentheses(parenthesis));

        int[] arr = new int[]{2, 7, 9, 11, 12, 13};
        System.out.println(twoSum2(arr, 20));

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(search2DMatrix(matrix, 3));
    }

    // 1. Count Connected Components
    public static int countComponents(int n, int[][] edges) {
        int res = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, x -> new HashSet<>()).add(b);
            graph.computeIfAbsent(b, x -> new HashSet<>()).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int cur = stack.pop();
                    for (int neighbor : graph.getOrDefault(cur, new HashSet<>())) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            stack.push(neighbor);
                        }
                    }
                }

                res++;
            }
        }

        return res;
    }


    // 2. Median Finder
    static class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size()) {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
            return (double) maxHeap.peek();
        }
    }

    // 3. Daily Temperatures
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int topIndex = stack.pop();
                result[topIndex] = i - topIndex;
            }
            stack.push(i);
        }
        return result;
    }

    // 4. Sliding Window Maximum
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    // 5. Generate Parentheses
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr.toString());
            return;
        }

        if (open < max) {
            curr.append("(");
            backtrack(res, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            backtrack(res, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    // Additional
    public static int[] dijkstra(int n, int[][] edges, int start) {
        if (edges == null || edges.length == 0) return new int[0];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new int[]{to, weight});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            if (currDist > dist[currNode]) continue;

            if (!graph.containsKey(currNode)) continue;

            for (int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currDist + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }

        }
        return dist;

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        return res.reversed();
    }

    // Some sorting stuff to refresh
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotValue = arr[right];
            int i = left - 1, j = left;
            while (j < right) {
                if (arr[j] <= pivotValue) {
                    i++;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
            int temp = arr[i + 1];
            arr[right] = temp;
            arr[i + 1] = pivotValue;
            int pi = i + 1;
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }

    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        if (arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return arr;
    }

    public static int[] buildMinHeap(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
        return arr;
    }

    private static void heapify(int[] arr, int i, int length) {
        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < length && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < length && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }
        if (smallest != i) {
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            heapify(arr, smallest, length);
        }
    }

    private static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        Map<Character, Integer> countS = new HashMap<>();
//        Map<Character, Integer> countT = new HashMap<>();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char sChar = s.charAt(i);
//            char tChar = t.charAt(i);
//            countS.put(sChar, countS.getOrDefault(sChar, 0) + 1);
//            countT.put(tChar, countT.getOrDefault(tChar, 0) + 1);
//        }
//        if (countS.size() != countT.size()) return false;
//        int pos = 0;
//
//        while (pos < countS.size()) {
//            Map.Entry<Character, Integer> entryS = countS.entrySet().iterator().next();
//            Map.Entry<Character, Integer> entryT = countT.entrySet().iterator().next();
//            if (!entryS.getKey().equals(entryT.getKey())) return false;
//            if (!entryS.getValue().equals(entryT.getValue())) return false;
//            pos++;
//        }
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

    private static String countingSort(String s) {
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (chars[i]-- > 0) {
                res.append((char) ('a' + i));
            }
        }
        return res.toString();
    }

    private static boolean isValidParentheses(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || !map.containsKey(c)) {
                stack.push(c);
            } else {
                Character openingBracket = stack.pop();
                if (!map.get(c).equals(openingBracket)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[2];
    }

    private static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }

    private static boolean search2DMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int foundRow = -1;
        while (top <= bottom) {
            int row = (top + bottom) / 2;
            if (matrix[row][cols - 1] < target) {
                top = row + 1;
            } else if (matrix[row][0] > target) {
                bottom = row - 1;
            } else {
                foundRow = row;
                break;
            }
        }

        if (foundRow == -1) return false;
        int left = 0, right = cols - 1;
        while (left <= right) {
            int col = (left + right) / 2;
            if (matrix[foundRow][col] < target) {
                left = col + 1;
            } else if (matrix[foundRow][col] > target) {
                right = col - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
