package archive_misc;

import java.util.Comparator;
import java.util.TreeMap;

public class ListAlgorithms {
    // 1. Detect Cycle in Linked List
    static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 2. Happy Number
    static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    static int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    // 3. Find Middle of Linked List
    static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode reverseBetweenPositions(ListNode head, int n, int m) {
        ListNode prevStart = null;
        ListNode startNode = head;

        int pos = 1;
        while (pos < n) {
            prevStart = startNode;
            startNode = startNode.next;
            pos++;
        }

        ListNode curr = startNode;
        ListNode prev = null;
        while (curr != null && pos <= m) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            pos++;
        }
        if (prevStart != null) prevStart.next = prev;
        else head = prev;

        if (startNode != null) startNode.next = curr;
        return head;
    }

    static ListNode reorderList(ListNode head) {
        TreeMap<Integer, ListNode> map = new TreeMap<>((a, b) -> b - a);


        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode p1 = head;
        ListNode p2 = prev;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (p1 != null && p2 != null) {
            tail.next = p1;
            p1 = p1.next;
            tail = tail.next;

            tail.next = p2;
            p2 = p2.next;
            tail = tail.next;
        }
        if (p1 != null) tail.next = p1;
        return dummy.next;
    }

    // Basic definition of singly linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}
