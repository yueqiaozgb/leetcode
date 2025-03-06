package top.yueqiao.leetcode;

/**
 * @Author : yueqiao
 * @Create : 2025/3/6 23:23
 */
public class Solution2 {

    /**
     * 场景模拟题目
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        int tag = 0;
        while (l1 != null && l2 != null) {
            head.val = (l1.val + l2.val + tag) % 10;
            if (l1.val + l2.val + tag >= 10) {
                tag = 1;
            } else {
                tag = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null) {
                head.next = new ListNode();
                head = head.next;
            }
        }
        while (l1 != null) {
            head.val = (l1.val + tag) % 10;
            if (l1.val + tag >= 10) {
                tag = 1;
            } else {
                tag = 0;
            }
            l1 = l1.next;
            if (l1 != null) {
                head.next = new ListNode();
                head = head.next;
            }
        }
        while (l2 != null) {
            head.val = (l2.val + tag) % 10;
            if (l2.val + tag >= 10) {
                tag = 1;
            } else {
                tag = 0;
            }
            l2 = l2.next;
            if (l2 != null) {
                head.next = new ListNode();
                head = head.next;
            }
        }
        if (tag == 1) {
            head.next = new ListNode();
            head = head.next;
            head.val = 1;
        }
        return result;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum%10);
            } else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(9);

        addTwoNumbers1(l1, l2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}