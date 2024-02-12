import data.ListNode;

import java.util.HashSet;

public class _141_LinkedListCycle {
    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode_4 = new ListNode(-4);
        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode_4;
        listNode_4.next = listNode2;
        boolean expected = true;
        boolean actual = hasCycle(listNode3);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean hasCycle(ListNode head) { // Runtime Beats 100%
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) { // Runtime Beats 11.98%
        if (head == null || head.next == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        while(head.next != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
