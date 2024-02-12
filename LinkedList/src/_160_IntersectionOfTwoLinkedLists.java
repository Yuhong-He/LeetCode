import data.ListNode;

import java.util.HashSet;

public class _160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode listNodeA1 = new ListNode(1);
        ListNode listNodeA2 = new ListNode(2);
        ListNode listNodeA3 = new ListNode(3);
        ListNode listNodeA4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNodeB1 = new ListNode(1);
        ListNode listNodeB2 = new ListNode(2);
        ListNode listNodeB3 = new ListNode(3);
        listNodeA1.next = listNodeA2;
        listNodeA2.next = listNodeA3;
        listNodeA3.next = listNodeA4;
        listNodeA4.next = listNode5;
        listNodeB1.next = listNodeB2;
        listNodeB2.next = listNodeB3;
        listNodeB3.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        ListNode actual = getIntersectionNode(listNodeA1, listNodeB1);
        System.out.println("expected: " + listNode5.val);
        System.out.println("actual: " + actual.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) { // 和getIntersectionNode2耗时一样，比getIntersectionNode2内存消耗多
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0, lenB = 0, diff = 0;
        while (nodeA != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        while (nodeB != null) {
            nodeB = nodeB.next;
            lenB++;
        }
        if (lenA > lenB) {
            nodeA = headA;
            nodeB = headB;
            diff = lenA - lenB;
        } else {
            nodeA = headB;
            nodeB = headA;
            diff = lenB - lenA;
        }
        for (int i = 0; i < diff; i++)
            nodeA = nodeA.next;
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next; // 如果移到末尾，A挪到B的开头，B挪到A的开头
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        // 一定相遇，因为 a + b = b + a，如果为null，说明在链表外相遇，如果不为null说明在链表内相遇
        return nodeA;
    }

    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) { // hashset, Beats 25.67%
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode4(ListNode headA, ListNode headB) { // brute force
        ListNode copyB = headB;
        while (headA != null) {
            while (copyB != null) {
                if (headA == copyB) {
                    return headA;
                }
                copyB = copyB.next;
            }
            copyB = headB;
            headA = headA.next;
        }
        return null;
    }
}
