package org.example.leetcode.demo.hot100;

import org.example.leetcode.demo.tool.ListNode;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/4
 */
public class D019 {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode returnHead = new D019().removeNthFromEnd(listNode1, 2);
        while (returnHead != null) {
            System.out.println(returnHead.val);
            returnHead = returnHead.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nullNode = new ListNode(0, head);
        ListNode slow = nullNode;
        ListNode fast = nullNode;
        int index = 0;
        ListNode before = null;
        ListNode after = null;
        while (fast.next != null) {
            fast = fast.next;
            if (index < n - 1) {
                index++;
            } else {
                if (slow != nullNode) {
                    before = slow;
                }
                if (slow.next != null) {
                    after = slow.next.next;
                } else {
                    after = null;
                }
                slow = slow.next;
            }
        }

        if (before != null) {
            before.next = after;
        }else {
            return head.next;
        }
        return head;
    }

}


