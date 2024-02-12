import data.ListNode;

public class _83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = deleteDuplicates(listNode);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
