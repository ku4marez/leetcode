package interview.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Top50Easy {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        // Arrays
        int[] rotateArr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(rotateArr, 3);
        System.out.println(Arrays.toString(rotateArr));

        int[] duplicateArr = new int[]{1, 2, 3, 3, 5, 6, 7};
        System.out.println(containsDuplicate(duplicateArr));

        int[] signleArr = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(signleArr));

        int[] twoSumArr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(twoSumArr, 9)));

        int[] plusOneArr = new int[]{4, 9, 2, 8};
        System.out.println(Arrays.toString(plusOne(plusOneArr)));

        // Strings
        char[] charArray = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(charArray);
        System.out.println(Arrays.toString(charArray));

        int reverseInt = 321;
        System.out.println(reverse(reverseInt));

        String atoi = "-92783";
        System.out.println(myAtoi(atoi));

        String anagramStr1 = "abcd";
        String anagramStr2 = "dbac";
        System.out.println(isAnagram(anagramStr1, anagramStr2));

        String palindromeStr1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(palindromeStr1));

        String[] commonPrefix = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(commonPrefix));

        String uniqueCharString = "leetcode";
        System.out.println(firstUniqChar(uniqueCharString));

        // LinkedList
        ListNode deleteHead = new ListNode(4);
        deleteHead.next = new ListNode(5);
        deleteHead.next.next = new ListNode(6);
        deleteHead.next.next.next = new ListNode(7);

        deleteNode(deleteHead.next);
        System.out.println(deleteHead);

        ListNode cycleHead = new ListNode(3);
        cycleHead.next = new ListNode(2);
        cycleHead.next.next = new ListNode(0);
        cycleHead.next.next.next = new ListNode(-4);
        System.out.println(hasCycle(cycleHead));

        System.out.println(mergeTwoLists(cycleHead, deleteHead));

        ListNode reverseHead = new ListNode(3);
        reverseHead.next = new ListNode(2);
        reverseHead.next.next = new ListNode(0);
        reverseHead.next.next.next = new ListNode(  1);
        System.out.println(reverseList(reverseHead));
    }

    // Arrays
    private static void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        swap(nums, 0, length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    // Strings
    private static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
            start++;
            end--;
        }
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

    private static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        boolean negative = false;
        int i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            negative = s.charAt(i) == '-';
            i++;
        }

        long res = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && digit > (negative ? 8 : 7))) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return (int) (negative ? -res : res);
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            int j = 0;
            while (j < curr.length() && j < res.length() && res.charAt(j) == curr.charAt(j)) {
                j++;
            }
            res = res.substring(0, j);
            if (res.isEmpty()) return "";
        }
        return res;
    }

    private static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] == 1) return i;
        }
        return -1;
    }

    // LinkedList
    private static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) curr.next = list1;
        else curr.next = list2;
        return dummy.next;
    }

//    private static ListNode reverseList(ListNode head) {
//        if (head == null) return null;
//        ListNode current = head;
//        Stack<ListNode> stack = new Stack<>();
//        while (current != null) {
//            stack.push(current);
//            current = current.next;
//        }
//        ListNode newHead = stack.pop();
//        current = newHead;
//        while (!stack.isEmpty()) {
//            current.next = stack.pop();
//            current = current.next;
//        }
//        current.next = null;
//        return newHead;
//    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
