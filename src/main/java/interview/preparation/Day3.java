package interview.preparation;

import java.util.*;

public class Day3 {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private static void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                backtrack(nums, temp, used, result);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String newWord = new String(chars);

                        if (newWord.equals(endWord)) {
                            return steps + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // mark as visited
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            steps++;
        }
        return 0;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];

            if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) continue;
            if (image[r][c] != originalColor) continue;

            image[r][c] = newColor;

            queue.offer(new int[]{r + 1, c});
            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r, c + 1});
            queue.offer(new int[]{r, c - 1});
        }

        return image;
    }


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrackParenthesis(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void backtrackParenthesis(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append('(');
            backtrackParenthesis(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (close < open) {
            current.append(')');
            backtrackParenthesis(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        map.put(node, new Node(node.val));
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (Node neighbour : curr.neighbors) {
                if (!map.containsKey(neighbour)) {
                    map.put(neighbour, new Node(neighbour.val));
                    stack.push(neighbour);
                }
                map.get(curr).neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }


}
