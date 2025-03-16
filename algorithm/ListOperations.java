package algorithm;

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

    // Rotate a Linked List by k Places
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length of the list
        ListNode current = head;
        int n = 1;
        while (current.next != null) {
            n++;
            current = current.next;
        }

        // Step 2: Reduce k within bounds
        k %= n;
        if (k == 0) return head;  // If k is now 0, no rotation is needed

        // Step 3: Find the new tail (n-k-1 node)
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 4: Set new head and break the list
        ListNode newHead = newTail.next;
        newTail.next = null;

        // Step 5: Connect old tail to old head
        current.next = head;  // Current was already at the old tail

        return newHead;
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

    // Iterative approach to merge nodes summaries
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
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
