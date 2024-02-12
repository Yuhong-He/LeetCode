import data.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd2(listNode, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        int target = length - n;
        ListNode cur = dummy;
        int index = 0;
        while (cur != null) {
            if (index == target) {
                cur.next = cur.next.next;
                break;
            } else {
                cur = cur.next;
                index++;
            }
        }
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) { // Beats 100.00%
        if (head == null) return null;
        ListNode copy = head;
        int count = 0;
        while (copy != null) {
            count++;
            copy = copy.next;
        }
        int target = count - n - 1;
        ListNode node = head;
        for (int i = 0; i < target; i++) {
            node = node.next;
        }
        if (count == 1) { // 链表只有一个节点
            return null;
        } else if (n == 1) { // 移除的是最后一个节点
            node.next = null;
        } else if (count == n) { // 移除的是第一个节点
            head = head.next;
        } else {
            node.next = node.next.next;
        }
        return head;
    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) { // Beats 12.14%
        if (head == null) return null;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode copy = head;
        int i = 1;
        while (copy != null) {
            map.put(i, copy);
            i++;
            copy = copy.next;
        }
        int target = i - n - 1;
        ListNode node = map.get(target);
        if (i == 2) { // 链表只有一个节点
            return null;
        } else if (n == 1) { // 移除的是最后一个节点
            node.next = null;
        } else if (i - 1 == n) { // 移除的是第一个节点
            head = head.next;
        } else {
            node.next = node.next.next;
        }
        return head;
    }
}
