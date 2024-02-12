import data.ListNode;

public class _142_LinkedListCycle_II {
    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode_4 = new ListNode(-4);
        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode_4;
        listNode_4.next = listNode2;
        ListNode actual = detectCycle(listNode3);
        System.out.println("expected: " + listNode2.val);
        System.out.println("actual: " + actual.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        // 假设第一题中两指针相遇慢指针走了n步，那么快指针走了2n步，计算相遇点到循环开始点的距离x=（2n-m）-（n-m
        // 此处m为循环开始点的位置，计算出x=n，这时候慢指针快指针变为同速，都是走n步，相遇
        if (hasCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
