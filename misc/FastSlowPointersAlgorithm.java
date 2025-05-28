package misc;

public class FastSlowPointersAlgorithm {
    public static void main(String[] args) {
        // 1. Detect Cycle in a Linked List
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle
        System.out.println("Detect if a cycle exists in the linked list: ");
        System.out.println(hasCycle(head));

        // 2. Happy Number
        int n = 19;
        System.out.println("Determine whether a number is a happy number: ");
        System.out.println(isHappy(n));

        // 3. Find Middle of Linked List
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        System.out.println("Return the middle node of the linked list: ");
        System.out.println(findMiddleNode(head2).val);
    }

    // 1. Detect Cycle in Linked List
    private static boolean hasCycle(ListNode head) {
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
    private static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    // 3. Find Middle of Linked List
    private static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Basic definition of singly linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
