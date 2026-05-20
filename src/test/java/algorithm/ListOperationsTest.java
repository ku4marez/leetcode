package algorithm;

import algorithm.ListOperations.ListNode;
import algorithm.ListOperations.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {

    private ListNode buildList(int... vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    @Test
    void getDecimalValue() {
        assertEquals(0, ListOperations.getDecimalValue(buildList(0)));
        assertEquals(5, ListOperations.getDecimalValue(buildList(1, 0, 1)));
    }

    @Test
    void deleteDuplicates() {
        assertArrayEquals(new int[]{1, 2}, toArray(ListOperations.deleteDuplicates(buildList(1, 1, 2))));
    }

    @Test
    void hasCycle() {
        ListNode node = buildList(1, 2, 3);
        assertFalse(ListOperations.hasCycle(node));
    }

    @Test
    void rotateRight() {
        assertArrayEquals(new int[]{4, 5, 1, 2, 3}, toArray(ListOperations.rotateRight(buildList(1, 2, 3, 4, 5), 2)));
    }

    @Test
    void mergeTwoLists() {
        ListNode merged = ListOperations.mergeTwoLists(buildList(1, 2, 4), buildList(1, 3, 4));
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, toArray(merged));
    }

    @Test
    void addTwoNumbers() {
        // 342 + 465 = 807
        ListNode result = ListOperations.addTwoNumbers(buildList(2, 4, 3), buildList(5, 6, 4));
        assertArrayEquals(new int[]{7, 0, 8}, toArray(result));
    }

    @Test
    void removeElements() {
        assertArrayEquals(new int[]{1, 2}, toArray(ListOperations.removeElements(buildList(1, 2, 3), 3)));
    }

    @Test
    void reverseList() {
        assertArrayEquals(new int[]{3, 2, 1}, toArray(ListOperations.reverseList(buildList(1, 2, 3))));
    }

    @Test
    void reverseList2() {
        assertArrayEquals(new int[]{3, 2, 1}, toArray(ListOperations.reverseList2(buildList(1, 2, 3))));
    }

    @Test
    void mergeSort() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, toArray(ListOperations.mergeSort(buildList(4, 2, 1, 3))));
    }

    @Test
    void isPalindrome() {
        assertTrue(ListOperations.isPalindrome(buildList(1, 2, 1)));
        assertFalse(ListOperations.isPalindrome(buildList(1, 2)));
    }

    @Test
    void reorderList() {
        ListNode head = buildList(1, 2, 3, 4);
        ListOperations.reorderList(head);
        assertArrayEquals(new int[]{1, 4, 2, 3}, toArray(head));
    }

    @Test
    void mergeAlternating() {
        ListNode result = ListOperations.mergeAlternating(buildList(1, 3, 5), buildList(2, 4, 6));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(result));
    }

    @Test
    void copyRandomList() {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        n0.next = n1;
        n1.random = n0;

        Node copied = ListOperations.copyRandomList(n0);
        assertNotNull(copied);
        assertEquals(7, copied.val);
        assertEquals(13, copied.next.val);
        assertEquals(copied, copied.next.random);
    }

    @Test
    void reverse() {
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(ListOperations.reverse(buildList(1, 2, 3, 4, 5))));
    }
}
