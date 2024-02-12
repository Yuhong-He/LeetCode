import data.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _234_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        boolean expected = true;
        boolean actual = isPalindrome(listNode);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean isPalindrome(ListNode head) { // 双指针 + 反转链表, Beats 86.70%
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static boolean isPalindrome2(ListNode head) { // store in array, Beats 31.78%
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            if (!Objects.equals(list.get(i), list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
