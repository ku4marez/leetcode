package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ListOperations {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Bitwise approach to convert Binary Number in a Linked List to Integer
    public static int getDecimalValue(ListNode head) {
        if (head == null) {
            return 1;
        }
        int sum = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            int currentBit = cur.val;
            sum = sum << 1;
            sum = sum | currentBit;
        }
        return sum;
    }

    // Iterative Traversal with Pointer Manipulation
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        for (ListNode current = head; current.next != null; ) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // Floyd’s Cycle Detection Algorithm (also called the "Tortoise and Hare" approach).
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Fast & Slow approach to find middle of the list
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Moves one step
            fast = fast.next.next;    // Moves two steps
        }

        return slow; // Middle node
    }

    // Merge Two Sorted Lists Using Iterative Approach
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    // Two-Pointer Approach to Find Intersection Node
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // Iterative Approach with Dummy Node
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    // Stack-Based Reversal of Linked List
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        ListNode newHead = stack.pop();
        current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        current.next = null;
        return newHead;
    }

    // Two-Pointer Approach and Reversal for Palindrome Check
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfStart = reverseList(slow);

        ListNode firstHalfStart = head;
        ListNode secondHalfPointer = secondHalfStart;
        boolean isPalindrome = true;

        while (secondHalfPointer != null) {
            if (firstHalfStart.val != secondHalfPointer.val) {
                isPalindrome = false;
                break;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        reverseList(secondHalfStart);

        return isPalindrome;
    }
}
