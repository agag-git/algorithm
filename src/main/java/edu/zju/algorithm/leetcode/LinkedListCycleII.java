package edu.zju.algorithm.leetcode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return findJoint(head, fast);
        }
        return null;
    }

    public ListNode findJoint(ListNode head, ListNode met) {
        ListNode left = head;
        ListNode right = met;
        int leftLen = 1;
        int rightLen = 1;
        while (left.next != met) {
            leftLen ++;
            left = left.next;
        }
        left = head;
        while (right.next != met) {
            rightLen ++;
            right = right.next;
        }
        right = met;
        if (leftLen > rightLen) {
            for (int i = 0; i < (leftLen - rightLen); i++)
                left = left.next;
        } else {
            for (int i = 0; i < (rightLen - leftLen); i++)
                right = right.next;
        }
        while (left != right) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}