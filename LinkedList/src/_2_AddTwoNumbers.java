import data.ListNode;

public class _2_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    // 32 / 1568
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int num1 = numHelper(l1, 0, 1);
        int num2 = numHelper(l2, 0, 1);
        int finalNum = num1 + num2;
        String strFinalNum = "" + finalNum;
        String[] arrFinalNum = strFinalNum.split("");
        ListNode result = new ListNode();
        result.val = Integer.parseInt(arrFinalNum[arrFinalNum.length - 1]);
        convertHelper(result, arrFinalNum, 0);
        return result;
    }

    public static void convertHelper(ListNode node, String[] nums, int index) {
        if (index != nums.length - 1) {
            node.next = new ListNode(Integer.parseInt(nums[nums.length - 2 - index]));
            convertHelper(node.next, nums, index + 1);
        }
    }

    public static int numHelper(ListNode node, int currNum, int digit) {
        if (node != null) {
            currNum = currNum + node.val * digit;
            return numHelper(node.next, currNum, digit * 10);
        }
        return currNum;
    }
}
