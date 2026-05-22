package archive_misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListAlgorithmsTest {

    @Test
    void hasCycle() {
        ListAlgorithms.ListNode head = new ListAlgorithms.ListNode(1);
        head.next = new ListAlgorithms.ListNode(2);
        head.next.next = new ListAlgorithms.ListNode(3);
        head.next.next.next = head.next; // cycle
        assertTrue(ListAlgorithms.hasCycle(head));
    }

    @Test
    void hasCycleNoCycle() {
        ListAlgorithms.ListNode head = new ListAlgorithms.ListNode(1);
        head.next = new ListAlgorithms.ListNode(2);
        head.next.next = new ListAlgorithms.ListNode(3);
        assertFalse(ListAlgorithms.hasCycle(head));
    }

    @Test
    void isHappy() {
        assertTrue(ListAlgorithms.isHappy(19));  // 19 → 82 → 68 → 100 → 1
        assertFalse(ListAlgorithms.isHappy(2));
    }

    @Test
    void findMiddleNode() {
        ListAlgorithms.ListNode head = new ListAlgorithms.ListNode(1);
        head.next = new ListAlgorithms.ListNode(2);
        head.next.next = new ListAlgorithms.ListNode(3);
        head.next.next.next = new ListAlgorithms.ListNode(4);
        head.next.next.next.next = new ListAlgorithms.ListNode(5);
        assertEquals(3, ListAlgorithms.findMiddleNode(head).getVal());
    }
}
