import data.ListNode;

public class _876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode actual = middleNode(listNode);
        System.out.println("expected: " + 3);
        System.out.println("actual: " + actual.val);
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
